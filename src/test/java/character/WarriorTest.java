package character;

import inventory.Armor;
import inventory.ArmorPart;
import inventory.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    Warrior warrior;

    @BeforeEach
    public void setup()
    {
        warrior = new Warrior("Wolf", "człek",
                new Weapon("Miecz", 10,25),
                new Armor());
    }

    @Test
    public void testEquipWeapon()
    {
        warrior.addNewItem(new Weapon("Topór", 15,34));
        warrior.assignWeapon(0);
        warrior.showEquipment();
        warrior.assignWeapon(1);
        warrior.showEquipment();
    }

    @Test
    public void testAddingArmorToWarrior()
    {
        warrior.addNewItem(new ArmorPart("Helmet",10, 1, "Head"));
        warrior.addNewItem(new ArmorPart("Helmet+5",30, 5, "Head"));

        warrior.assignArmorPart(0);
        warrior.showEquipment();
    }

    @Test
    public void testReceivedLethalDamage()
    {
        warrior.getDamage(100);
        assertEquals(0,warrior.getCurrentHealth());
    }

}