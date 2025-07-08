package service;

import model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            String fullName = student.getFullName();
            String lowerFullName = fullName.toLowerCase(Locale.ROOT);
            boolean containsQuery = lowerFullName.contains(normalizedQuery);
            if (containsQuery) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
