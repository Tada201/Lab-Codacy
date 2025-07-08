package service;

import model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private static final int MAX_STUDENTS = 100;

    private boolean hasStudentWithId(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void addStudent(Student student) {
        if (students.size() >= MAX_STUDENTS) {
            throw new IllegalArgumentException("Maximum student capacity reached");
        }
        
        if (hasStudentWithId(student.getId())) {
            throw new IllegalArgumentException("Student ID must be unique");
        }
        
        if (student.getGpa() < 0.0 || student.getGpa() > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
        
        students.add(student);
    }


    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public List<Student> searchStudents(String nameQuery) {
        String normalizedQuery = nameQuery.toLowerCase(Locale.ROOT);
        return students.stream()
                .filter(student -> student.getFullName().toLowerCase(Locale.ROOT).contains(normalizedQuery))
                .collect(Collectors.toList());
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
