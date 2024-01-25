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
    }}