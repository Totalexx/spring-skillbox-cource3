package ru.totalexx.mod2;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.totalexx.mod2.event.AddStudentEvent;
import ru.totalexx.mod2.event.RemoveStudentEvent;
import ru.totalexx.mod2.model.Student;
import ru.totalexx.mod2.service.StudentService;

import java.util.UUID;

@ShellComponent
@RequiredArgsConstructor
public class ShellManager {

    private final ApplicationEventPublisher publisher;
    private final StudentService studentService;

    @ShellMethod
    public void print() {
        studentService.getStudents().forEach(System.out::println);
    }

    @ShellMethod
    public void add(String firstName, String lastName, int age) {
        Student student = new Student(firstName, lastName, age);
        studentService.addStudent(student);

        publisher.publishEvent(new AddStudentEvent(this, student));
    }

    @ShellMethod
    public void remove(UUID id) {
        Student removedStudent = studentService.removeStudent(id);
        publisher.publishEvent(new RemoveStudentEvent(this, removedStudent));
    }

    @ShellMethod()
    public void clearAll() {
        studentService.removeAll();
    }
}
