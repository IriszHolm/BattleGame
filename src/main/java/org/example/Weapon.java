package org.example;

import java.io.Serializable;

public class Weapon implements Serializable {
    // Weapon class returns the weapons name and damage
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
    public String getWName(){
        return name;
    }
    public int getWDamage(){
        return damage;
    }

    public static String[] getNpcWeaponName() {
        return npcWeaponName;
    }
    static String[] npcWeaponName = {"Sword",  "Sledgehammer", "Axe", "Torch", "Knife"};




}
