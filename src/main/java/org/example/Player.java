package org.example;

public class Player extends GameCharacter{
    // Player is a Subclass to GameCharacter

    public Player(String name, int hitPoints) {
        super(name, hitPoints);
    }
    public Player(String name, int hitPoints, Weapon weapon, double dexterity) {
        super(name, hitPoints, weapon, dexterity);

    }
}
