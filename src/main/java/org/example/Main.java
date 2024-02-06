package org.example;

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


        // Minimum damage=20, Maximum damage=40 (Randomized weapon damage for the enemy)
        int randomDamagePoints = (int) Math.floor((Math.random() * (40 - 20 + 1))) + 20;
        boolean isEnded = false;
        Scanner strINP = new Scanner(System.in);
        String noYes;
        String userName;

        // Weapons
        Weapon weapon = new Weapon("Sword", 20);
        Weapon weaponG = new Weapon("Sledgehammer", randomDamagePoints);


        WeaponInventory inventory = new WeaponInventory();
        inventory.addInventory(new Weapon("Empty", 0));
        inventory.addInventory(weapon);
        inventory.addInventory(new Weapon("PickAxe", 22));

        WeaponInventory inventoryG = new WeaponInventory();
        inventory.addInventory(weaponG);

        // SAVE FILE FUNCTIONS

        // Savear inte inventory, men namn och annat!
        String saveFile = "player.save";
        GameCharacter player;
        String gameInp;

        try{
            player = (Player) FileUtils.loadObject(saveFile);
            System.out.println("There is a save file, would you like to continue or create new character?\n" +
                    "press c->continue or Enter->new game: ");
            gameInp = strINP.nextLine();

            if (!gameInp.equals("c")){
               player=null;
            }
        } catch (RuntimeException e){
            player=null;
            System.out.println("Ingen save-fil, skapar ny player");

        }
        if (player ==null){
            System.out.println("Creates new player");
            player = new Player("Player", 100, weapon, 0.8, inventory.getWeapons());

            System.out.printf("Welcome brave warrior! " + BOLD + "Enter your name: " + NO_BOLD);
            String userNameT = strINP.nextLine();
            userName = Utils.getStringInput(userNameT); // Checks for valid userName
            player.setName(userName);
        }

        GameCharacter goblin = new Npc("Ghoul", 80, weaponG, 0.5, inventoryG.getWeapons());

        // Battle Game begins
        while (!isEnded){
            int counter = 0;
            int round = 1;


            System.out.println("A scary-looking " + goblin.getName() + " runs towards you. You decide to attack");

            // Loop starts here: Loops through each attack until either reaches 0 in HP
            outerloop: while (true) { //loop.2
                // counter makes attack switches possible
                if ((counter % 2) == 0) {
                    System.out.println("--- Inventory ---");

                    for (int i = 1; i < inventory.getWeapons().size(); i++) {
                        Weapon W = inventory.getWeapons().get(i);
                        System.out.printf("[%d] %s (%d)\n",
                                i,
                                W.getWName(),
                                W.getWDamage());
                    }


                    while (true) { //loop.3 Choose wrong --> repeat choose weapon meny
                        System.out.println(BOLD + "\nChoose weapon for Attack (" + 1 + "-" + (inventory.getWeapons().size() - 1) + ") or flee (q)?" + NO_BOLD);
                        String userStrINP = strINP.nextLine(); //hit sparas q
                        Weapon chosenWep;

                        // Player decides if they want to end the game or continue
                        if (userStrINP.equals("q")) {
                            System.out.println("You decided to flee");
                            isEnded = true;
                            break outerloop; // Jumps out of inner and outerloop

                        } else if (userStrINP.matches("^[0-9]+$")) {
                            chosenWep = inventory.chooseWeapon(Integer.parseInt(userStrINP));
                            player.setWeapon(chosenWep);
                            break;
                        } else {
                            System.out.println("You were too slow... Choose again");
                        }
                    }

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

            } // Inner Loop ends here

            // Different if-statements for when game has ended for x reason
            if (isEnded) {
                if (player.getHitPoints() <= 0) {
                    System.out.println(RED + "\nGame over...\n" + NO_RED + goblin.getName() + " won with " + goblin.getHitPoints() + "HP left");
                    System.exit(0);
                }
                if (goblin.getHitPoints() <= 0) {
                    System.out.println("\nGame has ended, " + player.getName() + " won with " + player.getHitPoints() + "HP left");
                    System.out.println(goblin.getName() + "dropped: " + goblin.getWeapon().getWName());
                    System.out.println("Add to inventory? (a) or continue? (Enter)");
                    String userStrINP = strINP.nextLine();

                    // Hålla koll på spelets rundor, randoisa ett numme mellan det om round = nuber == heal
                    Random random = new Random();
                    int num = random.nextInt(1, 5);
                    if (userStrINP.equals("a")) {
                        inventory.addInventory(goblin.getWeapon());
                        System.out.println(goblin.getWeapon().getWName() + " Added");
                    }
                    if (round == num){
                        System.out.println("You found a healing potion! Yeee ");
                        player.heal();
                    }
                }

                System.out.printf(YELLOW + "Want to try again? " + NO_YELLOW + BOLD + "yes/no " + NO_BOLD);
                noYes = strINP.nextLine();
                if (noYes.equals("yes")) {
                    isEnded = false;

                    player.setHitPoints(100);
                    goblin.setHitPoints(80);
                    goblin = Npc.SpawnNpc(80, 0.5);

                }
                if (noYes.equals("no")) {
                    System.out.println(BOLD + "\nGAME OVER\n" + NO_BOLD + "Thank you for playing, " + player.getName() + "\n");
                    System.out.println("Would you like to save your game? y/n");
                    String userStrINP = strINP.nextLine();

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

