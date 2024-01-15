package org.example;
import org.junit.jupiter.api.Test;


public class GameCharacter {

    private String name;
    private int hitPoints;
    private int takeDamage = 0;
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
    } //Med denna kan man nu ändra hitPoints
    public int Damage() {
        this.takeDamage = 20;
        return hitPoints - takeDamage;
    }



}
