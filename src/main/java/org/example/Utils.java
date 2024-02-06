package org.example;

import java.util.Scanner;

public class Utils {

    // Method that asks for an Integer from the user
    static int getIntInput(String prompt) {
        Scanner console = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(prompt + ": ");
                String input = console.nextLine();
                return Integer.parseInt(input);

            } catch (NumberFormatException e) {
                System.out.println("Submit an Integer!");
            }
        }
    }

    // Method that checks if username is a valid text
    static String getStringInput(String string) {
        Scanner strInput = new Scanner(System.in);
        String userInp = string;

        while (true)
            try {
                while (!userInp.matches("[a-zA-Z- ]+")) {
                    System.out.printf("Only use characters, please ");
                    userInp = strInput.nextLine();
                }
                break;

            } catch (Exception e) {
                System.out.println("Something went wrong");

            }
        return userInp;
    }

}



