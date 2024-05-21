package com.amibotnaidra.code.util;

import java.util.Scanner;

public class TodoListUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getUserInputOption(String prompt) {
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                number = Integer.parseInt(input);

                if (number < 1 || number > 4) {
                    System.out.println("Error: The number must be between 1 and 4.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
            }
        }
        return number;
    }

    public static String getUserInputTodo() {
        return scanner.nextLine();
    }

    public static int getUserInputNumberTodo() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < 0) {
                    System.out.println("Error: number of todo isn't exist.");
                    System.out.print("Please input a valid number: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please input a valid number.");
                System.out.print("Please input a valid number: ");
            }
        }
        return input;
    }

}
