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
        GameCharacter player = new GameCharacter("Caspian", 50);
        assertEquals("Caspian", player.getName());
    }
    @Test
    void testGameCharacterHP(){
        GameCharacter player = new GameCharacter("Caspian", 50);
        //player.Damage();
        player.setHitPoints(player.Damage());
        assertEquals(30, player.getHitPoints());
    }



}