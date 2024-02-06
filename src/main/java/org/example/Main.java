package org.example;

import java.util.ArrayList;
import java.util.Random;
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
        String GREEN = "\u001B[32m";
        String NO_GREEN = "\u001B[0m";


        boolean isEnded = false;
        Scanner strINP = new Scanner(System.in);
        String noYes;


        // Creating Weapons & Inventory
        Weapon weapon = new Weapon("Sword", 20);
        ArrayList<Weapon> inventory = new ArrayList<>();
        inventory.add(new Weapon("Empty", 0));
        inventory.add(weapon);
        inventory.add(new Weapon("PickAxe", 22));


        // SAVE FILE FUNCTIONS
        String saveFile = "player.save";
        GameCharacter player;
        String gameInp;

        try {
            player = (Player) FileUtils.loadObject(saveFile);
            System.out.println("There is a save file, would you like to continue or create new character?\n" +
                    "press c->continue or Enter->new game: ");
            gameInp = strINP.nextLine();

            if (!gameInp.equals("c")) {
                player = null;
            }
        } catch (RuntimeException e) {
            player = null;
            System.out.println("No save file");

        }
        if (player == null) {
            System.out.println("Creates new player");
            player = new Player("Player", 100, weapon, 0.8, inventory);


            System.out.printf("Welcome brave warrior! " + BOLD + "Enter your name: " + NO_BOLD);
            String userName = strINP.nextLine();
            player.setName(Utils.getStringInput(userName));
        }

        GameCharacter goblin = Npc.SpawnNpc(80, 0.5); // Random generated monster

        // Battle Game begins
        while (!isEnded) {
            int counter = 0;
            int round = 1;


            System.out.println("\nA scary-looking " + goblin.getName() + " runs towards you. You decide to attack");

            // Loop starts here: Loops through each attack until either reaches 0 in HP
            outerloop:
            while (true) { //loop.2
                // counter makes attack switches possible
                if ((counter % 2) == 0) {
                    System.out.println("--- Inventory ---");

                    for (int i = 1; i < player.inventory.size(); i++) {
                        Weapon W = player.inventory.get(i);
                        System.out.printf("[%d] %s (%d)\n",
                                i,
                                W.getWName(),
                                W.getWDamage());
                    }

                    innerloop:
                    while (true) { //loop.3 Choose wrong --> repeat choose weapon meny
                        System.out.println(BOLD + "\nChoose weapon for Attack (" + 1 + "-" + (player.inventory.size() - 1) + ") or flee (q)?" + NO_BOLD);
                        String userStrINP = strINP.nextLine();

                        // Player decides if they want to end the game or continue
                        if (userStrINP.equals("q")) {
                            System.out.println("You decided to flee");
                            isEnded = true;
                            break outerloop; // Jumps out of inner and outerloop

                        } else if (userStrINP.matches("^[0-9]+$")) {
                            int i = Integer.parseInt(userStrINP);
                            while (true) {
                                try {
                                    player.setWeapon(player.inventory.get(i));
                                    break innerloop;
                                } catch (Exception e) {
                                    i = Utils.getIntInput("No such weapon, try again.");
                                }
                            }


                        } else {
                            System.out.println("You were too slow... Choose again");
                        }
                    } // Inner loop 3 ends here

                    System.out.println(RED + "ROUND " + round + NO_RED + "\n" + player.getName() + " hits " +
                            goblin.getName() + " with a " + player.getWeapon().getWName() + ", for " + player.attack(goblin) + " Damage, " + goblin.getName() + " has " +
                            goblin.getHitPoints() + "HP left");
                }

                // Enemy attack
                if (counter % 2 == 1) {
                    round = round - 1;

                    System.out.println(goblin.getName() + " hits " +
                            player.getName() + " with a " + goblin.getWeapon().getWName() + ", for " + goblin.attack(player) + " Damage, " + player.getName() + " has " +
                            player.getHitPoints() + "HP left");
                }

                counter++;
                round++;

                // If either reaches 0HP, the game has now ended
                if (player.getHitPoints() <= 0 || goblin.getHitPoints() <= 0) {
                    isEnded = true;
                    break;
                }

            } // Outer Loop 2 ends here

            // Different if-statements for when game has ended for x reason
            if (isEnded) {
                if (player.getHitPoints() <= 0) {
                    System.out.println(RED + "\nGame over...\n" + NO_RED + goblin.getName() + " won with " + goblin.getHitPoints() + "HP left");
                    System.exit(0);
                }
                if (goblin.getHitPoints() <= 0) {
                    System.out.println("\nGame has ended, " + player.getName() + " won with " + player.getHitPoints() + "HP left");
                    System.out.println(goblin.getName() + " dropped: " + goblin.getWeapon().getWName() + " (" + goblin.getWeapon().getWDamage() + ")");
                    System.out.println("Add to inventory? (a) or continue? (Enter)");
                    String userStrINP = Utils.getStringInput(strINP.nextLine());

                    if (userStrINP.equals("a")) {
                        player.inventory.add(goblin.getWeapon());
                        System.out.println(goblin.getWeapon().getWName() + " Added");
                    }

                    // 50% chance you find a potion
                    Random random = new Random();
                    int num = random.nextInt(1, 2);
                    if (1 == num) {
                        System.out.println(GREEN + "You found a healing potion! " + NO_GREEN);
                        System.out.println("Your HP got raised by " + GREEN + player.heal() + NO_GREEN + "HP");
                    }
                }

                System.out.printf(YELLOW + "Want to try again? " + NO_YELLOW + BOLD + "yes/no " + NO_BOLD);
                noYes = Utils.getStringInput(strINP.nextLine());

                if (noYes.equals("yes")) {
                    isEnded = false;
                    goblin = Npc.SpawnNpc(80, 0.5);
                }
                if (noYes.equals("no")) {
                    System.out.println(BOLD + "\nGAME OVER\n" + NO_BOLD + "Thank you for playing, " + player.getName() + "\n");
                    System.out.println("Would you like to save your game? y/n");
                    String userStrINP = Utils.getStringInput(strINP.nextLine());

                    if (userStrINP.equals("y")) {
                        FileUtils.saveObject(player, saveFile);
                        System.out.println("File saved");
                        System.exit(0);
                    }
                    if (userStrINP.equals("n")) {
                        System.exit(0);
                    }
                } // no/yes ends here

            } // if(isEnded) ends here

        } // Loop ends here

    }

}

