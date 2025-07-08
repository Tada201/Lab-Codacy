package app;

import model.Student;
import service.StudentService;
import util.InputUtil;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        InputUtil inputUtil = new InputUtil();
        
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
                    addStudent(studentService, inputUtil);
                    break;
                case 2:
                    deleteStudent(studentService, inputUtil);
                    break;
                case 3:
                    searchStudents(studentService, inputUtil);
                    break;
                case 4:
                    displayAllStudents(studentService);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter 1-5.");
            }
        }
    }

    private static void addStudent(StudentService service, InputUtil inputUtil) {
        System.out.println("\nAdd New Student");
        int id = inputUtil.getIntInput("Enter student ID: ");
        String name = inputUtil.getStringInput("Enter student name: ");
        double gpa = inputUtil.getGpaInput("Enter student GPA (0.0-4.0): ");
        
        try {
            service.addStudent(new Student(id, name, gpa));
            System.out.println("Student added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteStudent(StudentService service, InputUtil inputUtil) {
        System.out.println("\nDelete Student");
        int id = inputUtil.getIntInput("Enter student ID to delete: ");
        service.deleteStudent(id);
        System.out.println("Student deleted successfully!");
    }

    private static void searchStudents(StudentService service, InputUtil inputUtil) {
        System.out.println("\nSearch Students");
        String query = inputUtil.getStringInput("Enter student name to search: ");
        List<Student> results = service.searchStudents(query);
        
        if (results.isEmpty()) {
            System.out.println("No matching students found.");
        } else {
            System.out.println("Search results:");
            results.forEach(System.out::println);
        }
    }

    private static void displayAllStudents(StudentService service) {
        System.out.println("\nAll Students");
        List<Student> students = service.getAllStudents();
        
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            students.forEach(System.out::println);
        }
    }
}
