package spells;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellTest {
    Spell spell;

    @BeforeEach
    void setUp() {
        spell = new Spell("Fireball",20,1,-15);
    }

    @Test
    void getAddDamagePts() {
        assertEquals(20,spell.getAddDamage());
    }

    @Test
    void getAddHealthPts() {
        assertEquals(1,spell.getAddHealth());
    }

    @Test
    void getAddResistancePts() {
        assertEquals(-15,spell.getImmunePts());
    }

    @Test
    void testEquals() {
        Spell spellNew = new Spell("Fireball",20,1,-15);
        assertEquals(spell,spellNew);
    }

    @Test
    void testToString() {
        System.out.println(spell.toString());
    }
}