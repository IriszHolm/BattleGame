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


        GameCharacter player = new Player("Player", 100, weapon, 0.8);
        GameCharacter goblin = new Npc("Ghoul", 100, weaponG, 0.5);

        System.out.println("Weapon: " + goblin.equippedWeapon.getWName() + ", Damage: "+ goblin.equippedWeapon.getWDamage());
        System.out.println(goblin.getWeapon().getWName());
        //goblin.setWeapon(weapon2);
        System.out.println("Goblin Weapon: " + goblin.equippedWeapon.getWName() + ", Damage: "+ goblin.equippedWeapon.getWDamage());
        System.out.println("Player Weapon: " + player.equippedWeapon.getWName() + ", Damage: "+ player.equippedWeapon.getWDamage());

        //System.out.println("Attack damage: " + player.attack(goblin));
        //System.out.println("Goblin's HP after attack " + goblin.getHitPoints());
        System.out.println("Attack damage: " + goblin.attack(player));
        System.out.println("Player's HP after attack " + player.getHitPoints());




        System.exit(0);


        // I'll give both 100HP so that the chance of winning is equal
        // If the computer has 50HP, its HP can end at -10HP, which doesn't look very good

        // Whom does the first attack is decided randomly
        Random rand = new Random();
        int counter = rand.nextInt(2);

        boolean gameEnded = false;
        int round = 1;

        // Battle Game begins
        System.out.println("A scary-looking Ghoul runs towards you. You decide to attack");

        // Loop starts here: Loops through each attack until either reaches 0 in HP
        while (!gameEnded) {

            if ((counter % 2) == 0) {

                player.setHitPoints(player.takeDamage(20));

                System.out.println("Round " + round + ": " + goblin.getName() + " hits " +
                        player.getName() + ", for 20HP Damage, " + player.getName() + " have " +
                        player.getHitPoints() + "HP left");
            }

            if (counter % 2 == 1) {

                goblin.setHitPoints(goblin.takeDamage(20));

                System.out.println("Round " + round + ": " + player.getName() + " hits " +
                        goblin.getName() + ", for 20HP Damage, " + goblin.getName() + " has " +
                        goblin.getHitPoints() + "HP left");
            }

            counter++;
            round++;

            // If either reaches 0HP, the game has now ended
            if (player.getHitPoints() <= 0 || goblin.getHitPoints() <= 0) {
                gameEnded = true;
            }
        } // Loop ends here

        // When the game has ended, the winner is printed out
        if (gameEnded) {
            if (player.getHitPoints() == 0) {
                System.out.println("Game has ended, Ghoul won");
            } else {
                System.out.println("Game has ended, Player won");
            }
        }
    }
}
