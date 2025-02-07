package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class Player extends GameCharacter implements Serializable {
    // Player is a Subclass to GameCharacter

    public Player(String name, int hitPoints) {
        super(name, hitPoints);
    }
    public Player(String name, int hitPoints, Weapon weapon, double dexterity) {
        super(name, hitPoints, weapon, dexterity);
    }

    public Player(String name, int hitPoints, Weapon weapon, double dexterity, ArrayList<Weapon> inventory) {
        super(name, hitPoints, weapon, dexterity, inventory);
    }
}
