package org.example;

import java.util.Scanner;

public class Utils {

    // Method that asks for an Integer from the user

    static int getIntInput(String prompt){
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
    static String getIntInp(String val){
        while (true)
            try {
                if (val.equals("q")){
                    return val;
                }
                if (!val.equals("q")){
                    //int userIntInput = Integer.parseInt(val);
                    return null;
                }
            } catch (NumberFormatException | NullPointerException e){
                    System.out.println("You have to submit an Integer");
            } catch (Exception e){
                    System.out.println("Something went wrong");
            }
    }

   /* static int getIntInput() {
        return getIntInput("Submit an Integer");
    }*/



    // Method that checks if username is a valid text
    static String getStringInput(String string){
        Scanner strInput = new Scanner(System.in);
        String userInp = string;

        while (true)
        try {
            while (!userInp.matches("[a-zA-Z- ]+")){
                System.out.printf("Only use characters, please ");
                userInp = strInput.nextLine();
            } break;

        }catch (Exception e){
            System.out.println("Something went wrong");

        } return userInp;
    }

    /*public Weapon chooseWeapon(int weaponIndex) {
        Weapon chosenWeapon;
        while (true) {
            try {
                //chosenWeapon = weapons.get(weaponIndex);
                chosenWeapon = weaponIndex;
                inventory.get(Integer.parseInt(weaponIndex);
                break;
            } catch (Exception e) {
                weaponIndex = Utils.getIntInput("No such weapon, try again.");
            }
        }
        return chosenWeapon;


    }*/

}



