package ru.totalexx.mod2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.totalexx.mod2.model.Student;
import ru.totalexx.mod2.repository.StudentRepository;

import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Set<Student> getStudents() {
        return studentRepository.getStudents();
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public Student removeStudent(UUID id) {
        Student student = studentRepository.getStudent(id);
        studentRepository.removeStudent(id);

        return student;
    }

    public void removeAll() {
        studentRepository.clear();
    }
}
