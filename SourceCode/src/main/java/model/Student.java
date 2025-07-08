package model;

public class Student {
    private final int id;
    private final String fullName;
    private final double gpa;

    public Student(int id, String fullName, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.gpa = gpa;
    }

    // Getters only (no setters for immutability)
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, GPA: %.2f", id, fullName, gpa);
    }
}
