package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        assertTrue(true);
    }
    @Test
    void testGameCharacterName(){
        GameCharacter g = new GameCharacter("Caspian", 100);
        assertEquals("Caspian", g.getName());
    }
    @Test
    void testGameCharacterHP(){
        GameCharacter g = new GameCharacter("Caspian", 100);
        //player.Damage();
        g.setHitPoints(g.takeDamage(30));
        assertEquals(70, g.getHitPoints());
    }



}