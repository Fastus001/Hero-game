package character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spells.Spell;
import utils.Race;

import static org.junit.jupiter.api.Assertions.*;

class SorcererTest {
    Sorcerer sorcerer;

    @BeforeEach
    void setUp() {
        sorcerer = new Sorcerer("Rastlin", Race.ELF,10);

    }

    @Test
    void addNewSpell() {
        sorcerer.addNewSpell(new Spell("Mage armor",-5, 10, 25));
        sorcerer.addNewSpell(new Spell("Mage armor",-5, 10, 25));
        assertAll(
                ()->assertEquals(15,sorcerer.damage),
                ()->assertEquals(90,sorcerer.getCurrentHealth()),
                ()->assertEquals(35,sorcerer.getResistance())
        );
    }

    @Test
    void showAvailableSpells() {
        sorcerer.addNewSpell(new Spell("Mage armor",-5, 10, 25));
        sorcerer.addNewSpell(new Spell("Arm",10, 10, 25));
        sorcerer.addNewSpell(new Spell("Xwing",-5, 10, 25));
        sorcerer.showAvailableSpells();
    }

    @Test
    void getDamage() {
        sorcerer.addNewSpell(new Spell("Mage armor",15, 10, 25));
        assertEquals(35,sorcerer.damage);
    }

    @Test
    void getResistance() {
        sorcerer.addNewSpell(new Spell("Mage armor",15, 10, -10));
        assertEquals(0,sorcerer.getResistance());
    }
}