package inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BodyPart;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {
    Armor armor;

    @BeforeEach
    void setArmor()
    {
        armor = new Armor();
    }

    @Test
    public void testArmorClass()
    {
        assertNull(armor.equipArmorAdvanced(new ArmorPart("Hełm",15,2, BodyPart.HEAD)));
        InventoryObject armourPart = armor.equipArmorAdvanced(new ArmorPart("Kask", 125, 2, BodyPart.HEAD));
        assertEquals("Hełm",armourPart.getName());
    }

    @Test
    public void testEquipEachPartOfArmor()
    {
        armor.equipArmorAdvanced(new ArmorPart("Helmet", 10, 1,BodyPart.HEAD));
        armor.equipArmorAdvanced(new ArmorPart("Left arm", 11, 2,BodyPart.LEFT_ARM));
        armor.equipArmorAdvanced(new ArmorPart("Right arm", 20, 3,BodyPart.RIGHT_ARM));
        armor.equipArmorAdvanced(new ArmorPart("Lef leg", 30, 4,BodyPart.LEFT_LEG));
        armor.equipArmorAdvanced(new ArmorPart("Right leg", 21, 5,BodyPart.RIGHT_LEG));
        armor.equipArmorAdvanced(new ArmorPart("Torso", 55, 6,BodyPart.TORSO));

        assertAll(()->assertEquals("Left arm",armor.getBodyPart(BodyPart.LEFT_ARM).getName()),
                ()->assertEquals(55,armor.getBodyPart(BodyPart.TORSO).getWeight()),
                ()->assertEquals(21,armor.getDamageResistance())
                );
    }

    @Test
    @DisplayName("Show be after change one armor part on another")
    public void shouldBeAfterChangingArmor()
    {
        armor.equipArmorAdvanced(new ArmorPart("Helmet", 10, 3,BodyPart.HEAD));
        armor.equipArmorAdvanced(new ArmorPart("Helmet", 10, 1,BodyPart.HEAD));
        assertEquals(1,armor.getDamageResistance());
    }

    @Test
    void equipArmorAdvanced() {
        armor.equipArmorAdvanced(new ArmorPart("Helmet34", 10, 3,BodyPart.HEAD));
        ArmorPart helmet = armor.equipArmorAdvanced(new ArmorPart("Helmet", 10, 1, BodyPart.HEAD));
        assertEquals(1,armor.getDamageResistance());
    }
}