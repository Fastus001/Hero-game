package character;

import exceptions.GameOverException;
import exceptions.InvalidTypeException;
import exceptions.NoEmptySlotException;
import inventory.Armor;
import inventory.ArmorPart;
import inventory.Weapon;
import utils.Race;

public class Warrior extends Hero{
    private Weapon weapon;
    private final Armor armor;

    public Warrior(String name, Race race, Weapon weapon, Armor armor) {
        super(name, race);
        this.weapon = weapon;
        this.armor = armor;
    }

    public void assignWeapon(int index) throws InvalidTypeException, NoEmptySlotException {
        if(super.getItem(index) instanceof Weapon)
        {
            addNewItem(this.weapon);
            this.weapon = (Weapon) super.getItem(index);
            super.getInventory()[index]= null;
        }else{
                throw new InvalidTypeException("It's no a weapon!");
        }
    }

    public void assignArmorPart(int index) throws InvalidTypeException {
        if(super.getItem(index) instanceof ArmorPart)
        {
            this.armor.equipArmorAdvanced((ArmorPart) super.getItem(index));
            super.getInventory()[index] = null;
        }else{
            throw new InvalidTypeException("It's no a armor!");
        }
    }

    @Override
    public void getDamage(int dmg) throws GameOverException {
        int finalDamage = dmg - this.armor.getDamageResistance();
        super.getDamage(Math.max(finalDamage, 0));
    }

    @Override
    public int dealDamage() {
        return weapon.getDamagePoints();
    }
}
