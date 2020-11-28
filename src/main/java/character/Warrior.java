package character;

import inventory.Armor;
import inventory.ArmorPart;
import inventory.Weapon;

public class Warrior extends Hero{
    private Weapon weapon;
    private Armor armor;

    public Warrior(String name, String race, Weapon weapon, Armor armor) {
        super(name, race);
        this.weapon = weapon;
        this.armor = armor;
    }

    public void assignWeapon(int index)
    {
        if(super.getItem(index) instanceof Weapon)
        {
            addNewItem(this.weapon);
            this.weapon = (Weapon) super.getItem(index);
            super.getInventory()[index]= null;
        }else{
            System.out.println("It's nota a weapon!");
        }
    }

    public void assignArmorPart(int index)
    {
        if(super.getItem(index) instanceof ArmorPart)
        {
            this.armor.equipArmour((ArmorPart) super.getItem(index));
            super.getInventory()[index] = null;
        }else{
            System.out.println("It's nota a armor!");
        }
    }


}
