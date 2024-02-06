package org.example;

import java.util.ArrayList;

public class WeaponInventory {

    // Eller hämtas den från GameCharacter??
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

    public Weapon chooseWeapon(int weaponIndex) {
        Weapon chosenWeapon;
        while (true) {
            try {
                // chosenWeapon = Utils.getIntInput("Choose");
                // Om vapen är inom arrayen --> vidare, annars out of bounds

                chosenWeapon = weapons.get(weaponIndex);
                break;
            } catch (Exception e) {
                weaponIndex = Utils.getIntInput("No such weapon, try again.");
            }

        }
        return chosenWeapon;
    }

}


