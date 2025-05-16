package ru.totalexx.mod2.repository;

import org.springframework.stereotype.Component;
import ru.totalexx.mod2.model.Student;

import java.util.*;

@Component
public class StudentRepository {

    private final Map<UUID, Student> students = new HashMap<UUID, Student>();

    public Set<Student> getStudents() {
        return new HashSet<>(students.values());
    }

    public Student getStudent(UUID id) {
        return students.get(id);
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void removeStudent(UUID id) {
        students.remove(id);
    }

    public void clear() {
        students.clear();
    }
}
