package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("A scary-looking Ghoul runs towards you. You decide to attack");

        GameCharacter player = new GameCharacter("You", 100);
        GameCharacter goblin = new GameCharacter("Goblin", 100);

        Random rand = new Random();
        int counter = rand.nextInt(2);
        boolean gameEnded = false;

        while (!gameEnded) {

            if ((counter % 2) == 0) {
                //System.out.println(player.getName() + " " + player.getHitPoints());
                //System.out.println(goblin.getName() + " " + goblin.getHitPoints());

                player.setHitPoints(player.Damage());

                System.out.println(goblin.getName() + " hits " +
                        player.getName() + ", for 20HP Damage, " + player.getName() + " have " +
                        player.getHitPoints() + "HP left");
            }
            if (counter % 2 == 1) {
                //System.out.println(player.getName() + " " + player.getHitPoints());
                //System.out.println(goblin.getName() + " " + goblin.getHitPoints());

                goblin.setHitPoints(goblin.Damage());

                System.out.println(player.getName() + " hit " +
                        goblin.getName() + ", for 20HP Damage," + goblin.getName() + " has " +
                        goblin.getHitPoints() + "HP left");
            }
            counter++;

            if (player.getHitPoints() <= 0 || goblin.getHitPoints() <= 0) {
                gameEnded = true;
            }
        }
        if (gameEnded) {
            if (player.getHitPoints() == 0) {
                System.out.println("Game had ended, Goblin won");

            } else {
                System.out.println("Game had ended, Player won");
            }

        }
    }
        /*
        int round = 0;
        for (int i = 0; i < 3; i++) {
            round += 1;
            // 4 rundow
            System.out.println("Round  " + round);
            System.out.println(player.getName() + " " +player.getHitPoints());
            System.out.println(goblin.getName() + " " +goblin.getHitPoints());

            player.setHitPoints(player.Damage());
            goblin.setHitPoints(goblin.Damage());

            System.out.println( "Player: " + player.getName()+ " have " + player.getHitPoints() + " lives left");
            System.out.println( "Player: " + goblin.getName()+ " have " + goblin.getHitPoints() + " lives left");
                 if(player.getHitPoints() == 0 || goblin.getHitPoints() == 0 ){
                     break;
                 }

         */



    }
