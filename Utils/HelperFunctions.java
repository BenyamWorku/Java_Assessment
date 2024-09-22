package Utils;
import java.util.Scanner;

public class HelperFunctions {
    private static Scanner scanner = new Scanner(System.in);
    public static void displayMainMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1: Add Building");
        System.out.println("2: Add Villager");
        System.out.println("3: Assign Villager to Building");
        System.out.println("4: View Territory Structure");
        System.out.println("5: Exit");
        System.out.println("6: Attack Enemy Territory");
        System.out.println("7: Restart the Game");
        System.out.print("Enter choice: ");
    }

    public static int getValidatedIntegerInput(int min, int max) {
        int input = -1;
        boolean valid = false;
        while (!valid) {
            String line = scanner.nextLine();
            try {
                input = Integer.parseInt(line);
                if (input >= min && input <= max) {
                    valid = true;
                } else {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
        return input;
    }
    /**
     * Gets a non-empty string input from the user.
     *
     * @param prompt The prompt to display to the user.
     * @return Non-empty string input.
     */
    public static String getNonEmptyStringInput(String prompt) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        }
        return input.trim();
    }
}
