package util;

import java.util.Scanner;


public class InputUtil {
    private final Scanner scanner = new Scanner(System.in);

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
        String input = scanner.nextLine();
        String trimmedInput = input.trim();
        return trimmedInput;
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
    
    
    public static boolean containsNormalized(String source, String query) {
        String normSourceLower = source.toLowerCase(java.util.Locale.ROOT);
        String normSourceTrimmed = normSourceLower.trim();
        String normQueryLower = query.toLowerCase(java.util.Locale.ROOT);
        String normQueryTrimmed = normQueryLower.trim();
        return normSourceTrimmed.indexOf(normQueryTrimmed) != -1;
    }
}
