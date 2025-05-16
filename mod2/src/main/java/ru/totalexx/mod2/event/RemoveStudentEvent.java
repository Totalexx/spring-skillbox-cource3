package ru.totalexx.mod2.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.totalexx.mod2.model.Student;

import java.util.UUID;

@Getter
public class RemoveStudentEvent extends ApplicationEvent {

    private final Student student;

    public RemoveStudentEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
