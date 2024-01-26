package org.example;

import java.util.Random;

// Represents a gameCharacter with different attributes and methods than can be used
abstract public class GameCharacter {
    private String name;
    private int hitPoints;
    double dexterity;
    Weapon equippedWeapon;

    public GameCharacter(String name, int hitPoints) {
        // Incapsulated attributes
        this.name = name;
        this.hitPoints = hitPoints;
    }
    public GameCharacter(String name, int hitPoints, Weapon equippedWeapon, double dexterity) {
        // Incapsulated attributes
        this.name = name;
        this.hitPoints = hitPoints;
        this.equippedWeapon = equippedWeapon;
        this.dexterity = dexterity;
    }


    public String getName(){
        return name;
    }
    public int getHitPoints(){
        return hitPoints;
    }

    // You can change the value of hitPoints
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    // You can subtract damage from the players hitPoints
    public int takeDamage(int damage) {
        return hitPoints - damage;
    }
    public Weapon getWeapon() {
        // ta in namn och damage i parameter?? Behöver returnera hela vapnet
        // Hur få namn och damage hit?
        //equippedWeapon.getWName();
        return equippedWeapon;
    }
    public Weapon setWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
        return equippedWeapon;
    }

    // Method that lets a player attack another player
    public int attack(GameCharacter defender){
        Random dexterityRand = new Random();
        double num = dexterityRand.nextDouble(dexterity, 1.0);
        double weaponDamage = Math.round(equippedWeapon.getWDamage() * num);
        double remainingHP = defender.hitPoints - weaponDamage;
        defender.setHitPoints((int)remainingHP);
        return (int)weaponDamage;
    }



    //abstract void mend();




}
