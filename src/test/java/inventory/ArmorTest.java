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
        assertNull(armor.equipArmour(new ArmorPart("Hełm",15,2, BodyPart.HEAD)));
        InventoryObject armourPart = armor.equipArmour(new ArmorPart("Kask", 125, 2, BodyPart.HEAD));
        assertEquals("Hełm",armourPart.getName());
    }

    @Test
    public void testEquipEachPartOfArmor()
    {
        armor.equipArmour(new ArmorPart("Helmet", 10, 1,BodyPart.HEAD));
        armor.equipArmour(new ArmorPart("Left arm", 11, 2,BodyPart.LEFT_ARM));
        armor.equipArmour(new ArmorPart("Right arm", 20, 3,BodyPart.RIGHT_ARM));
        armor.equipArmour(new ArmorPart("Lef leg", 30, 4,BodyPart.LEFT_LEG));
        armor.equipArmour(new ArmorPart("Right leg", 21, 5,BodyPart.RIGHT_LEG));
        armor.equipArmour(new ArmorPart("Torso", 55, 6,BodyPart.TORSO));

        assertAll(()->assertEquals("Left arm",armor.getLeftArm().getName()),
                ()->assertEquals(55,armor.getTorso().getWeight()),
                ()->assertEquals(21,armor.getDamageResistance())
                );
    }

    @Test
    @DisplayName("Show be after change one armor part on another")
    public void shouldBeAfterChangingArmor()
    {
        armor.equipArmour(new ArmorPart("Helmet", 10, 3,BodyPart.HEAD));
        armor.equipArmour(new ArmorPart("Helmet", 10, 1,BodyPart.HEAD));
        assertEquals(1,armor.getDamageResistance());
    }

}