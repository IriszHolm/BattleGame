package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       //int chosenInteger = Utils.getIntInput();
       //System.out.println(chosenInteger);

        // Skapa en vapenShop där player kan välja och goblin få något random.
        // Minimum damage=20, Maximum damage=40
        int randomDamagePoints = (int)Math.floor((Math.random() * (40 - 20 + 1)))+ 20;


        // Weapons
        Weapon weapon = new Weapon("Sword", 20);
        Weapon weaponG = new Weapon("Sledgehammer", randomDamagePoints);
        //Weapon weapon2 = new Weapon("Axe", 30);


        GameCharacter player = new Player("Player", 50, weapon, 0.8);
        GameCharacter goblin = new Npc("Ghoul", 100, weaponG, 0.5);

        //System.out.println(goblin.getWeapon().getWName());
        //goblin.setWeapon(weapon2);
        //System.out.println("Goblin Weapon: " + goblin.equippedWeapon.getWName() + ", Damage: "+ goblin.equippedWeapon.getWDamage());
        //System.out.println("Player Weapon: " + player.equippedWeapon.getWName() + ", Damage: "+ player.equippedWeapon.getWDamage());

        //System.out.println("Player's Attack damage: " + player.attack(goblin));
        //System.out.println("Goblin's HP after attack " + goblin.getHitPoints());
        //System.out.println("Attack damage: " + goblin.attack(player));
        //System.out.println("Player's HP after attack " + player.getHitPoints());



        //System.exit(0);


        // I'll give both 100HP so that the chance of winning is equal
        // If the computer has 50HP, its HP can end at -10HP, which doesn't look very good

        // Whom does the first attack is decided randomly
        Random rand = new Random();
        int counter = 0; //rand.nextInt(2);

        boolean gameEnded = false;
        int round = 1;
        Scanner strINP = new Scanner(System.in);
        String noYes;

        // Battle Game begins
        System.out.printf("Welcome brave warrior! Enter your name: ");
        String userName = strINP.nextLine();
        System.out.println("A scary-looking Ghoul runs towards you. You decide to attack");

        // Loop starts here: Loops through each attack until either reaches 0 in HP
        while (true) {

            if ((counter % 2) == 0) {
                    System.out.println("Attack (Enter) or flee (q)?");
                    String userStrINP = strINP.nextLine();

                    if (userStrINP.equals("q")){
                        System.out.println("You decided to flee");
                        gameEnded = true;
                        break;
                        }

                System.out.println("Round " + round + ": " + userName + " hits " +
                        goblin.getName() + " with a "+ player.getWeapon().getWName() + ", for " + player.attack(goblin) + " Damage, " + goblin.getName() + " has " +
                        goblin.getHitPoints() + "HP left");
            }
            if (counter % 2 == 1) {
                System.out.println("Round " + round + ": " + goblin.getName() + " hits " +
                        userName + " with a "+ goblin.getWeapon().getWName() + ", for " + goblin.attack(player) + " Damage, " + userName + " has " +
                        player.getHitPoints() + "HP left");

            }

            counter++;
            round++;

            // If either reaches 0HP, the game has now ended
            if (player.getHitPoints() <= 0 || goblin.getHitPoints() <= 0) {
                break;
            }

        } // Loop ends here

        // When the game has ended, the winner is printed out
            if (player.getHitPoints() <= 0) {
                System.out.println("Game has ended, Ghoul won");
                gameEnded = true;
            }
            if (goblin.getHitPoints() <= 0){
                System.out.println("Game has ended, " + userName +" won");
                gameEnded = true;
            }

            if (gameEnded) {
                    System.out.printf("Want to try again? yes/no ");
                    noYes = strINP.nextLine();
                    if (noYes.equals("yes")){
                        gameEnded = false;
                    }
                    if (noYes.equals("no")){
                        System.out.println("\nGAME OVER\nThank you for playing " + userName +"\n");
                        System.exit(0);
                    }
                }

    }

}

