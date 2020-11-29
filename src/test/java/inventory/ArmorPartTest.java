package inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.BodyPart;

import static org.junit.jupiter.api.Assertions.*;

class ArmorPartTest {
    ArmorPart armorPart;

    @BeforeEach
    void setArmor()
    {
        armorPart = new ArmorPart("Breastplate",25,8, BodyPart.TORSO);
    }

    @Test
    void getBodyPart() {
        assertEquals("TORSO",armorPart.getBodyPartName());
    }

    @Test
    void getDamageResistance() {
        assertEquals(8,armorPart.getDamageResistance());
    }
}