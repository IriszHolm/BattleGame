package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameCharacterTest {

    @Test
    void testGameCharacterName(){
        GameCharacter g = new Player("Caspian", 100);
        assertEquals("Caspian", g.getName());
    }
    @Test
    void testGameCharacterHP(){
        GameCharacter g = new Player("Caspian", 100);
        g.setHitPoints(g.takeDamage(30));
        assertEquals(70, g.getHitPoints());
    }
    @Test
    void testGameCharacterINS(){
        Weapon weapon = new Weapon("Sword", 20);
        GameCharacter player = new Player("Iris", 100, weapon, 0.8);
        GameCharacter npc = new Npc("Npc", 100, weapon, 0.8);

        // Attack Tests
        assertEquals("Sword", npc.getWeapon().getWName());

        player.attack(npc);
        assertEquals(100, player.getHitPoints()); // Player HP is still 100
        assertNotEquals(100, npc.getHitPoints()); // NPC has lost HP

        npc.attack(player);
        assertNotEquals(100, player.getHitPoints()); // Player has been attacked

    }
    @Test
    void testSpawnNpc(){
        Weapon weapon = new Weapon("Sword", 20);
        GameCharacter goblin = new Npc("Caspian", 100, weapon, 0.8);

        goblin = Npc.SpawnNpc(80, 0.5);

        assertInstanceOf(GameCharacter.class, goblin);

    }

}