package org.example;

import java.util.Scanner;

public class Utils {

    // Method that asks for an Integer from the user
    static int getIntInput(String prompt){
        Scanner console = new Scanner(System.in);
        while (true) {
            try {
                //System.out.print(prompt + ": ");
                return Integer.parseInt(console.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Submit an Integer!");
            }
        }
        /*
        int value;
        Scanner intInput = new Scanner(System.in);
        Scanner strInput = new Scanner(System.in);

        while (true)
            try {
                System.out.println("Submit an Integer");
                int userIntInput = Integer.parseInt(strInput.nextLine());
                value = userIntInput;
                break;

            } catch (NumberFormatException | NullPointerException e){
                    System.out.println("You have to submit an Integer");
            } catch (Exception e){
                    System.out.println("Something went wrong");
            }
        return value;*/
    }
    static int getIntInput() {
        return getIntInput("Submit an Integer");
    }



    // Method that checks if username is a valid text
    static String getStringInput(String string){
        Scanner strInput = new Scanner(System.in);
        String userInp = string;

        while (true)
        try {
            while (!userInp.matches("[a-zA-Z- ]+")){
                System.out.printf("Please enter a valid name! ");
                userInp = strInput.nextLine();
            } break;

        }catch (Exception e){
            System.out.println("Something went wrong");

        } return userInp;
    }
}


