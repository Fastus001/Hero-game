package character;

import exceptions.InvalidTypeException;
import exceptions.NoEmptySlotException;
import inventory.Armor;
import inventory.ArmorPart;
import inventory.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.BodyPart;
import utils.Race;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    Warrior warrior;

    @BeforeEach
    public void setup()
    {
        warrior = new Warrior("Wolf", Race.HUMAN,
                new Weapon("Miecz", 10,25),
                new Armor());
    }

    @Test
    public void testEquipWeapon() throws InvalidTypeException, NoEmptySlotException {
        warrior.addNewItem(new Weapon("Topór", 15,34));
        warrior.assignWeapon(0);
        warrior.showEquipment();
        warrior.assignWeapon(1);
        warrior.showEquipment();
    }

    @Test
    public void testAddingArmorToWarrior() throws InvalidTypeException, NoEmptySlotException {
        warrior.addNewItem(new ArmorPart("Helmet",10, 1, BodyPart.HEAD));
        warrior.addNewItem(new ArmorPart("Helmet+5",30, 5, BodyPart.HEAD));

        warrior.assignArmorPart(0);
        warrior.showEquipment();
    }

    @Test
    public void testReceivedDamageReducedByArmor()
    {

    }

    @Test
    void getLoadFactor() throws NoEmptySlotException, InvalidTypeException {
        warrior.addNewItem(new ArmorPart("Helmet",10, 1, BodyPart.HEAD));
        warrior.assignArmorPart(0);

        assertEquals(20, warrior.getTotalWeight());
    }
}