package service;

import model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();
    private static final int MAX_STUDENTS = 100;

    public void addStudent(Student student) throws IllegalArgumentException {
        if (students.size() >= MAX_STUDENTS) {
            throw new IllegalArgumentException("Maximum student capacity reached");
        }
        
        if (students.stream().anyMatch(s -> s.getId() == student.getId())) {
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
        return students.stream()
                .filter(student -> student.getFullName().toLowerCase().contains(nameQuery.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
