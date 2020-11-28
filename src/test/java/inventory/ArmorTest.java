package inventory;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    @Test
    public void testArmorClass()
    {
        Armor armor = new Armor();
        assertNull(armor.equipArmour(new ArmorPart("Hełm",15,2,"Head")));
        InventoryObject armourPart = armor.equipArmour(new ArmorPart("Kask", 125, 2, "Head"));
        System.out.println("armourPart = " + armourPart);

    }

}