package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Npc extends GameCharacter implements Serializable {
    // Npc is a Subclass to GameCharacter

    public Npc(String name, int hitPoints) {
        super(name, hitPoints);
    }

    public Npc(String name, int hitPoints, Weapon weapon, double dexterity) {
        super(name, hitPoints,weapon, dexterity);
    }
    public Npc(String name, int hitPoints, Weapon weapon, double dexterity, ArrayList<Weapon> inventory) {
        super(name, hitPoints,weapon, dexterity, inventory);
    }


    // Static factory method for random Weapon name and kind (and damage)
    public static GameCharacter SpawnNpc(int hitPoints, double dexterity){
        String[] npcNames = {"Skeleton", "Elon Musk", "Jeff Bezos", "Mark Zuckerberg", "Ed Sheeran"};
        Random rand = new Random();

        // Minimum damage=20, Maximum damage=40 (Randomized weapon damage for the enemy)
        int randomDamagePoints = (int)Math.floor((Math.random() * (40 - 20 + 1)))+ 20;
        int num = rand.nextInt(0,4);
        String randomName = npcNames[rand.nextInt(npcNames.length)];
        Weapon randomWeapon = new Weapon(Weapon.getNpcWeaponName()[num], randomDamagePoints);

        //WeaponInventory inventory = new WeaponInventory();
        ArrayList<Weapon> inventory = new ArrayList<>();
        inventory.add(randomWeapon);
        // ELLER omvandla arraylist till weaponinventory

        return new GameCharacter(randomName, hitPoints, randomWeapon, dexterity, inventory) {
        };

    }
}
