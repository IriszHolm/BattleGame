package org.example;

public class Player extends GameCharacter{
    public Player(String name, int hitPoints) {
        super(name, hitPoints);

    }
    public Player(String name, int hitPoints, Weapon weapon) {
        super(name, hitPoints, weapon);

    }
}
