package org.example;
import org.junit.jupiter.api.Test;


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
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    public int takeDamage(int damage) {
        return hitPoints - damage;
    }



}
