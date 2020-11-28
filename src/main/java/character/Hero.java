package character;

import inventory.Food;
import inventory.InventoryObject;

public class Hero {
    private static final double MAX_LOAD = 100;
    private String name;
    private String race;
    private int currentHealth;
    private InventoryObject[] inventory = new InventoryObject[10];
    private boolean overloaded;

    public Hero(String name, String race) {
        this.name = name;
        this.race = race;
        this.currentHealth = 100;
    }

    public void receiveDamage(int damage)
    {
        this.currentHealth -= damage;
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

    public void addNewItem(InventoryObject io) {
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
        System.out.println("The new item can't be added to inventory!");
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

    public InventoryObject getItem(int i) {
        return inventory[i];
    }

    public void addHealth(int heal)
    {
        this.currentHealth +=heal;
    }

    public InventoryObject[] getInventory() {
        return inventory;
    }
}
