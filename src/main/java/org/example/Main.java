package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //int chosenInteger = Utils.getIntInput();
        //System.out.println(chosenInteger);

        // weaponShop?
        // Minimum damage=20, Maximum damage=40
        int randomDamagePoints = (int)Math.floor((Math.random() * (40 - 20 + 1)))+ 20;

        // Weapons
        Weapon weapon = new Weapon("Sword", 20);
        Weapon weaponG = new Weapon("Sledgehammer", randomDamagePoints);

        GameCharacter player = new Player("Player", 100, weapon, 0.8);
        GameCharacter goblin = new Npc("Ghoul", 50, weaponG, 0.5);


        boolean gameEnded = false;
        Scanner strINP = new Scanner(System.in);
        String noYes;
        String userName;

        // Battle Game begins
        while(!gameEnded) {
            // setWeapon() på goblin?
            int counter = 0;
            int round = 1;

            System.out.printf("Welcome brave warrior! Enter your name: ");
            userName = strINP.nextLine();
            System.out.println("A scary-looking Ghoul runs towards you. You decide to attack");

            // Loop starts here: Loops through each attack until either reaches 0 in HP
            while (true) {

                if ((counter % 2) == 0) {
                    System.out.println("Attack (Enter) or flee (q)?");
                    String userStrINP = strINP.nextLine();

                    if (userStrINP.equals("q")) {
                        System.out.println("You decided to flee");
                        gameEnded = true;
                        break;
                    }

                    System.out.println("Round " + round + ": " + userName + " hits " +
                            goblin.getName() + " with a " + player.getWeapon().getWName() + ", for " + player.attack(goblin) + " Damage, " + goblin.getName() + " has " +
                            goblin.getHitPoints() + "HP left");
                }
                if (counter % 2 == 1) {
                    System.out.println("Round " + round + ": " + goblin.getName() + " hits " +
                            userName + " with a " + goblin.getWeapon().getWName() + ", for " + goblin.attack(player) + " Damage, " + userName + " has " +
                            player.getHitPoints() + "HP left");

                }

                counter++;
                round++;

                // If either reaches 0HP, the game has now ended
                if (player.getHitPoints() <= 0 || goblin.getHitPoints() <= 0) {
                    gameEnded = true;
                    break;
                }

            } // Inner Loop ends here

            if (gameEnded) {
                if (player.getHitPoints() <= 0) {
                    System.out.println("Game has ended, Ghoul won");
                }
                if (goblin.getHitPoints() <= 0 ){
                    System.out.println("Game has ended, " + userName +" won");
                }

                System.out.printf("Want to try again? yes/no ");
                noYes = strINP.nextLine();
                if (noYes.equals("yes")){
                    gameEnded=false;
                    player.setHitPoints(100);
                    goblin.setHitPoints(50);
                }
                if (noYes.equals("no")){
                    System.out.println("\nGAME OVER\nThank you for playing " +userName +"\n");
                    System.exit(0);
                }

            }

        }// Loop ends here


    }

}

