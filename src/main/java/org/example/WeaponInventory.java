package org.example;

import java.util.ArrayList;

public class WeaponInventory {

    // Eller hämtas den från GameCharacter??
    private ArrayList<Weapon> weapons = new ArrayList<>();

    public void addInventory(Weapon weapon){
        weapons.add(weapon);
    }
    public void removeInventory(Weapon weapon) {weapons.remove(weapon);}

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public Weapon chooseWeapon(){

        while (true){
            try{
                int chosenWeapon = Utils.getIntInput("Choose");
                return weapons.get(chosenWeapon);
            } catch (Exception e){
                System.out.println("Out of bounds");
            }
        }
    }

}
