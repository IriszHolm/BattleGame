package org.example;

// Represents a gameCharacter with different attributes and methods than can be used
public class GameCharacter {
    private String name;
    private int hitPoints;
    public GameCharacter(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
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

}
