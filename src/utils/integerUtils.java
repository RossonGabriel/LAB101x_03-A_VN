package utils;

import java.util.Scanner;

public class integerUtils {
    public static int getIntFromUser(Scanner scanner, String inputMessage, String errorMessage) {
        /* ask user util get the integer input */
        while (true) {
            System.out.println(inputMessage);
            String userInput = scanner.nextLine();

            if (isNumeric(userInput))
                return Integer.parseInt(userInput);

            System.out.println(errorMessage);
        }
    }

    public static int getIntFromUser(String inputMessage, String errorMessage) {
        Scanner scanner = new Scanner(System.in);
        /* ask user util get the integer input */
        while (true) {
            System.out.print(inputMessage);
            String userInput = scanner.nextLine();

            if (isNumeric(userInput))
                return Integer.parseInt(userInput);

            System.out.println(errorMessage);
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
