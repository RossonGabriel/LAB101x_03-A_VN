package utils;

import java.util.Scanner;

public class stringUtils {
    public static String getStringFromUser(String inputMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(inputMessage);

        String userInput = scanner.nextLine();
        return userInput.trim();
    }
}
