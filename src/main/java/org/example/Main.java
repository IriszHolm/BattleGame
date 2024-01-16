package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("A scary-looking Ghoul runs towards you. You decide to attack");

        GameCharacter player = new GameCharacter("Player", 100);
        GameCharacter goblin = new GameCharacter("Ghoul", 100);
        //Jag ger båda 100 hitPoints, då har båda en chans att vinna.
        //Om datorn har 50hp så får denne -10 i HP på slutet.

        // Den som får göra första attacken görs slumpmässigt.
        Random rand = new Random();
        int counter = rand.nextInt(2);
        boolean gameEnded = false;
        int round = 1;

        while (!gameEnded) {

            if ((counter % 2) == 0) {
                //player.setHitPoints(player.Damage());
                player.setHitPoints(player.takeDamage(20));

                System.out.println("Round " + round + ": " + goblin.getName() + " hits " +
                        player.getName() + ", for 20HP Damage, " + player.getName() + " have " +
                        player.getHitPoints() + "HP left");
            }
            if (counter % 2 == 1) {
                //goblin.setHitPoints(goblin.Damage());
                goblin.setHitPoints(goblin.takeDamage(20));

                System.out.println("Round " + round + ": " + player.getName() + " hits " +
                        goblin.getName() + ", for 20HP Damage, " + goblin.getName() + " has " +
                        goblin.getHitPoints() + "HP left");
            }
            counter++;
            round++;

            if (player.getHitPoints() <= 0 || goblin.getHitPoints() <= 0) {
                gameEnded = true;
            }
        }
        if (gameEnded) {
            if (player.getHitPoints() == 0) {
                System.out.println("Game has ended, Ghoul won");
            } else {
                System.out.println("Game has ended, Player won");
            }
        }
    }
}
