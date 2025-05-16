package ru.totalexx.mod2.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.totalexx.mod2.model.Student;

@Getter
public class AddStudentEvent extends ApplicationEvent {

    private final Student student;

    public AddStudentEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
