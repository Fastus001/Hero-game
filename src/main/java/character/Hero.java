package character;

import exceptions.GameOverException;
import exceptions.NoEmptySlotException;
import inventory.Food;
import inventory.InventoryObject;
import utils.Fightable;
import utils.Race;

public class Hero implements Fightable {
    public static double MAX_LOAD = 100;
    public static int DAMAGE = 10;
    private final String name;
    private final Race race;
    private int currentHealth;
    private final InventoryObject[] inventory = new InventoryObject[10];
    private boolean overloaded;

    public Hero(String name, Race race) {
        this.name = name;
        this.race = race;
        this.currentHealth = race.getHealth();
    }

    public void consumeFood(int index)
    {
        InventoryObject io = inventory[index];
        if(io instanceof Food)
        {
            addHealth(((Food) io).getHealthPoints());
            io.removeOneToCount();
            if(io.getCount()==0)
                inventory[index] = null;
        }
    }

    public void showEquipment() {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                System.out.print((i + 1) + " " + inventory[i].showItem());
            }
        }
    }

    public void addNewItem(InventoryObject io) throws NoEmptySlotException {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].equals(io)) {
                inventory[i].addOneToCount();
                System.out.println("Item:" + io.getName() + " was added to your inventory. Current quantity is: "
                        + inventory[i].getCount());
                checkOverload();
                return;
            } else if (inventory[i] == null) {
                inventory[i] = io;
                checkOverload();
                System.out.println("Item:" + io.getName() + " was added to your inventory.");
                return;
            }
        }
        throw new NoEmptySlotException();
    }

    private void checkOverload() {
        double sum = 0;
        for (InventoryObject inv : inventory) {
            if (inv != null) {
                sum += inv.getWeight() * inv.getCount();
            }
        }
            overloaded = sum > MAX_LOAD;
        }

    public void addHealth(int heal)
    {
        this.currentHealth +=heal;
    }

    public InventoryObject getItem(int i) {
        return inventory[i];
    }

    public InventoryObject[] getInventory() {
        return inventory;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public boolean isDead() {
        return currentHealth<=0;
    }

    @Override
    public void getDamage(int dmg) throws GameOverException {
        currentHealth-=dmg;
        if(currentHealth<1)
            throw new GameOverException();
    }

    @Override
    public int dealDamage() {
        return DAMAGE;
    }
}
