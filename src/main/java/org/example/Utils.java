package org.example;

import java.util.Scanner;

public class Utils {

    // Method that asks for an Integer from the user
    static int getIntInput(){
        int value;
        Scanner intInput = new Scanner(System.in);
        Scanner strInput = new Scanner(System.in);


        while (true)
            try {
                System.out.println("Submit an Integer");
                int userIntInput = Integer.parseInt(strInput.nextLine());
                value = userIntInput;
                break;

            }catch (NumberFormatException | NullPointerException e){
                    System.out.println("You have to submit an Integer");

            }catch (Exception e){
                    System.out.println("Something went wrong");
            }
        return value;
    }
}
