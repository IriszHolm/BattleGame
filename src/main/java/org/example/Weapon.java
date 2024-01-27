package org.example;

public class Weapon {
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


}
