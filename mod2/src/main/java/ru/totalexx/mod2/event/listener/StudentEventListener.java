package ru.totalexx.mod2.event.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.totalexx.mod2.event.AddStudentEvent;
import ru.totalexx.mod2.event.RemoveStudentEvent;

@Component
public class StudentEventListener {

    @EventListener
    public void addStudentListener(AddStudentEvent event) {
        System.out.println("Добавлен студент");
        System.out.println(event.getStudent());
    }

    @EventListener
    public void removeStudentListener(RemoveStudentEvent event) {
        System.out.println("Студент удалён");
        System.out.println(event.getStudent().getId());
    }
}
