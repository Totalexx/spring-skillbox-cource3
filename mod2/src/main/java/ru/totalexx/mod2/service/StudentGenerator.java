package ru.totalexx.mod2.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ru.totalexx.mod2.model.Student;

import java.util.Random;

@Component
@ConditionalOnProperty("app.student.generator.enabled")
@RequiredArgsConstructor
public class StudentGenerator {

    private final StudentService studentService;
    private final Random random = new Random();

    private final String[] firstNames = new String[] {
            "John",
            "Jane",
            "Nolan",
            "Mary",
            "Jack",
            "Anny"
    };

    private final String[] lastNames = new String[] {
            "Smith",
            "Johnson",
            "Williams",
            "Brown",
            "Jones",
            "Garcia",
            "Miller"
    };

    @PostConstruct
    public void init() {
        generateStudents();
    }

    private void generateStudents() {
        int studentsCount = random.nextInt(15, 25);
        for (int i = 0; i < studentsCount; i++)
            studentService.addStudent(generateStudent());
    }

    private Student generateStudent() {
        return new Student(firstNames[random.nextInt(firstNames.length)],
            lastNames[random.nextInt(lastNames.length)],
            random.nextInt(18, 25)
        );
    }
}
