package npc;

import inventory.Weapon;

public class Bandit extends  Enemy{
    private Weapon weapon;

    public Bandit(String name, int health, int damage, Weapon weapon) {
        super(name, health, damage);
        this.weapon = weapon;
    }

    @Override
    public void getDamage(int dmg) {
        super.changeHeath(dmg);
        if(this.isDamageLethal())
            System.out.println("Bandit die,due to damage received!");
    }

    @Override
    public int dealDamage() {
        return weapon.getDamagePoints();
    }

    public Weapon dropWeapon()
    {
        return this.weapon;
    }
}
