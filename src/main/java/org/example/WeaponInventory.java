package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class WeaponInventory implements Serializable {

    private ArrayList<Weapon> weapons = new ArrayList<>();

    public void addInventory(Weapon weapon) {
        weapons.add(weapon);
    }

    public void removeInventory(Weapon weapon) {
        weapons.remove(weapon);
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
/*
    public Weapon chooseWeapon(int weaponIndex) {
        Weapon chosenWeapon;
        while (true) {
            try {
                chosenWeapon = weapons.get(weaponIndex);
                break;
            } catch (Exception e) {
                weaponIndex = Utils.getIntInput("No such weapon, try again.");
            }
        }
        return chosenWeapon;
    }

 */



}


