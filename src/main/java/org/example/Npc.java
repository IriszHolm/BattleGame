package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Npc extends GameCharacter{
    // Npc is a Subclass to GameCharacter

    public Npc(String name, int hitPoints) {
        super(name, hitPoints);
    }

    public Npc(String name, int hitPoints, Weapon weapon, double dexterity) {
        super(name, hitPoints,weapon, dexterity);
    }

    // Static factory method for random Weapon name and kind (and damage)
    public static Npc SpawnNpc(int hitPoints, double dexterity){
        String[] npcNames = {"Skeleton", "Elon Musk", "Jeff Bezos", "Mark Zuckerberg", "Ed Sheeran"};
        Random rand = new Random();

        int randomDamagePoints = (int)Math.floor((Math.random() * (40 - 20 + 1)))+ 20;
        int num = rand.nextInt(0,4);
        String randomName = npcNames[rand.nextInt(npcNames.length)];
        Weapon randomWeapon = new Weapon(Weapon.getNpcWeaponName()[num], randomDamagePoints);

        return new Npc(randomName, hitPoints, randomWeapon, dexterity);

    }
}
