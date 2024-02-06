package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

abstract public class GameCharacter implements Serializable {
    // Super Class
    // Represents a gameCharacter with different attributes and methods than can be used in game

    private String name;
    private int hitPoints;
    double dexterity;
    Weapon equippedWeapon;
    ArrayList<Weapon> inventory;

    public GameCharacter(String name, int hitPoints) {
        // Encapsulated attributes
        this.name = name;
        this.hitPoints = hitPoints;
    }

    public GameCharacter(String name, int hitPoints, Weapon equippedWeapon, double dexterity) {
        // Encapsulated attributes
        this.name = name;
        this.hitPoints = hitPoints;
        this.equippedWeapon = equippedWeapon;
        this.dexterity = dexterity;
    }

    public GameCharacter(String name, int hitPoints, Weapon equippedWeapon, double dexterity, ArrayList<Weapon> inventory) {
        // Encapsulated attributes
        this.name = name;
        this.hitPoints = hitPoints;
        this.equippedWeapon = equippedWeapon;
        this.dexterity = dexterity;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    // You can change the value of hitPoints
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Weapon getWeapon() {
        return equippedWeapon;
    }

    public Weapon setWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
        return equippedWeapon;
    }


    // Method that lets a player attack another player with randomized attack damage
    public int attack(GameCharacter defender) {
        double min = dexterity * equippedWeapon.getWDamage();
        double max = equippedWeapon.getWDamage();
        double num = Math.floor(Math.random() * (max - min + 1) + min);
        double remainingHP = defender.hitPoints - num;
        defender.setHitPoints((int) remainingHP);

        return (int) num;
    }

    // Method that restores health to max 100hp
    public int heal() {
        Random rand = new Random();
        int health = rand.nextInt(15, 100 - hitPoints);
        int newHealth = hitPoints + health;
        setHitPoints(newHealth);

        return newHealth;

    }


}
