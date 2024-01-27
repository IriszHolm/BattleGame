package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Font styles and colors
        String BOLD = "\033[0;1m";
        String NO_BOLD = "\033[0m";
        String RED = "\u001B[31m";
        String NO_RED = "\u001B[0m";
        String YELLOW = "\u001B[33m";
        String NO_YELLOW = "\u001B[0m";

        //int chosenInteger = Utils.getIntInput();
        //System.out.println(chosenInteger);

        // weaponShop?

        // Minimum damage=20, Maximum damage=40 (Randomized weapon damage for the enemy)
        int randomDamagePoints = (int)Math.floor((Math.random() * (40 - 20 + 1)))+ 20;
        boolean isEnded = false;
        Scanner strINP = new Scanner(System.in);
        String noYes;
        String userName;

        // Weapons
        Weapon weapon = new Weapon("Sword", 20);
        Weapon weaponG = new Weapon("Sledgehammer", randomDamagePoints);

        // Characters
        GameCharacter player = new Player("Player", 100, weapon, 0.8);
        GameCharacter goblin = new Npc("Ghoul", 80, weaponG, 0.5);

        // Battle Game begins
        while(!isEnded) {
            int counter = 0;
            int round = 1;

            System.out.printf("Welcome brave warrior! " + BOLD + "Enter your name: " + NO_BOLD);
            userName = strINP.nextLine();
            System.out.println("A scary-looking Ghoul runs towards you. You decide to attack");

            // Loop starts here: Loops through each attack until either reaches 0 in HP
            while (true) {
                // counter makes attack switches possible
                if ((counter % 2) == 0) {
                    System.out.println(BOLD + "Attack (Enter) or flee (q)?" + NO_BOLD);
                    String userStrINP = strINP.nextLine();

                    // Player decides if they want to end the game or continue
                    if (userStrINP.equals("q")) {
                        System.out.println("You decided to flee");
                         isEnded = true;
                        break;
                    }

                    System.out.println(RED +"ROUND " + round + NO_RED + "\n" + userName + " hits " +
                            goblin.getName() + " with a " + player.getWeapon().getWName() + ", for " + player.attack(goblin) + " Damage, " + goblin.getName() + " has " +
                            goblin.getHitPoints() + "HP left");
                }
                // Enemy attack
                if (counter % 2 == 1) {
                    round = round -1;

                    System.out.println(goblin.getName() + " hits " +
                            userName + " with a " + goblin.getWeapon().getWName() + ", for " + goblin.attack(player) + " Damage, " + userName + " has " +
                            player.getHitPoints() + "HP left");
                }

                counter++;
                round++;

                // If either reaches 0HP, the game has now ended
                if (player.getHitPoints() <= 0 || goblin.getHitPoints() <= 0) {
                    isEnded = true;
                    break;
                }

            } // Inner Loop ends here

            // Different if-statements for when game has ended for x reason
            if (isEnded) {
                if (player.getHitPoints() <= 0) {
                    System.out.println( RED +"\nGame over...\n"+ NO_RED + goblin.getName() +" won with " + goblin.getHitPoints() + "HP left");
                    System.exit(0);
                }
                if (goblin.getHitPoints() <= 0 ){
                    System.out.println("\nGame has ended, " + userName +" won with "  + player.getHitPoints() + "HP left");
                }

                System.out.printf( YELLOW + "Want to try again? " + NO_YELLOW + BOLD +"yes/no "+ NO_BOLD);
                noYes = strINP.nextLine();
                if (noYes.equals("yes")){
                    isEnded = false;

                    player.setHitPoints(100);
                    goblin.setHitPoints(80);
                    // New weapon for enemy?
                }
                if (noYes.equals("no")){
                    System.out.println( BOLD +"\nGAME OVER\n"+ NO_BOLD + "Thank you for playing, " +userName +"\n");
                    System.exit(0);
                }

            } // if(isEnded) ends here

        } // Loop ends here

    }

}

