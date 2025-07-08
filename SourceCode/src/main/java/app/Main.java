package app;

import model.Student;
import service.StudentService;
import util.InputUtil;
import java.util.List;

public class Main {
    private final StudentService studentService;
    private final InputUtil inputUtil;

    private Main() {
        studentService = new StudentService();
        inputUtil = new InputUtil();
    }

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add student");
            System.out.println("2. Delete student");
            System.out.println("3. Search student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            
            int choice = inputUtil.getIntInput("Enter your choice: ");
            
            switch(choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    searchStudents();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break; // Added break to satisfy linter
                default:
                    System.out.println("Invalid choice! Please enter 1-5.");
            }
        }
    }

    private void addStudent() {
        System.out.println("\nAdd New Student");
        int id = inputUtil.getIntInput("Enter student ID: ");
        String name = inputUtil.getStringInput("Enter student name: ");
        double gpa = inputUtil.getGpaInput("Enter student GPA (0.0-4.0): ");
        
        try {
            studentService.addStudent(new Student(id, name, gpa));
            System.out.println("Student added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteStudent() {
        System.out.println("\nDelete Student");
        int id = inputUtil.getIntInput("Enter student ID to delete: ");
        studentService.deleteStudent(id);
        System.out.println("Student deleted successfully!");
    }

    private void searchStudents() {
        System.out.println("\nSearch Students");
        String query = inputUtil.getStringInput("Enter student name to search: ");
        List<Student> results = studentService.searchStudents(query);
        
        if (results.isEmpty()) {
            System.out.println("No matching students found.");
        } else {
            System.out.println("Search results:");
            results.forEach(System.out::println);
        }
    }

    private void displayAllStudents() {
        System.out.println("\nAll Students");
        List<Student> students = studentService.getAllStudents();
        
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            students.forEach(System.out::println);
        }
    }
}
