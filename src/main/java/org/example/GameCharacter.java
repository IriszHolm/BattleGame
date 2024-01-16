package org.example;

public class GameCharacter {
    private String name;
    private int hitPoints;
    private int damage;
    //Före: private int damage = 0;
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
    public int takeDamage(int damage) {
        this.damage = damage;
        //Före: this.damage = 20;
        return hitPoints - damage;
    }

}
