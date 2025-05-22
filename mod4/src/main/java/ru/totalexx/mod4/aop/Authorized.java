package ru.totalexx.mod4.aop;

import ru.totalexx.mod4.model.access.Owned;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorized {
    Class<? extends Owned> entityClass() default Owned.class;
}
