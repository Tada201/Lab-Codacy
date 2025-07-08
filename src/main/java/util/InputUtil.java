package util;

import java.util.Scanner;

public class InputUtil {
    private Scanner scanner = new Scanner(System.in);

    public int getIntInput(String prompt) {
        while(true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public double getGpaInput(String prompt) {
        while(true) {
            try {
                double gpa = Double.parseDouble(getStringInput(prompt));
                if(gpa >= 0.0 && gpa <= 4.0) {
                    return gpa;
                }
                System.out.println("GPA must be between 0.0 and 4.0");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
    }
}
