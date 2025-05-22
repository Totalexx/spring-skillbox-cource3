package ru.totalexx.mod4.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import ru.totalexx.mod4.exception.SecurityServiceException;
import ru.totalexx.mod4.model.User;
import ru.totalexx.mod4.model.access.Owned;
import ru.totalexx.mod4.repository.access.OwnedResolver;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class PasswordAuthAspect {

    private final Map<Class<? extends Owned>, OwnedResolver<?>> resolverMap = new HashMap<>();

    public PasswordAuthAspect(List<OwnedResolver<?>> resolvers) {
        for (OwnedResolver<?> resolver : resolvers) {
            resolverMap.put(resolver.getEntityClass(), resolver);
        }
    }

    @Before("@annotation(Authorized)")
    public void authorize(JoinPoint joinPoint) {
        Long entityId = null;
        User actor = null;
        Owned owned = null;

        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof Long id)
                entityId = id;
            else if (arg instanceof User user)
                actor = user;
            else if (arg instanceof Owned ownedEntity)
                owned = ownedEntity;
        }

        if ((owned == null && entityId == null) || actor == null) {
            throw new SecurityServiceException("Missing authorization parameters");
        }

        if (owned == null) {
            Class<? extends Owned> entityClass = getEntityClass(joinPoint);
            owned = resolverMap.get(entityClass)
                    .findById(entityId)
                    .orElseThrow(() -> new SecurityServiceException(entityClass.getSimpleName() + " not found"));
        }

        if (actor.getId() == null || actor.getPassword() == null) {
            throw new SecurityServiceException("User not authorized to access this resource");
        }

        if (!owned.getOwner().getId().equals(actor.getId()) ||
                !owned.getOwner().getPassword().equals(actor.getPassword())) {
            throw new SecurityServiceException("User not authorized to access this resource");
        }
    }

    private static Class<? extends Owned> getEntityClass(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Authorized authorized = method.getAnnotation(Authorized.class);
        return authorized.entityClass();
    }
}
