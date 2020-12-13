package character;

import exceptions.GameOverException;
import exceptions.NoEmptySlotException;
import inventory.Food;
import inventory.InventoryObject;
import utils.Fightable;
import utils.Race;

import java.util.Objects;
import java.util.stream.Stream;

public class Hero implements Fightable {
    public static double MAX_LOAD = 100;
    public int damage = 10;
    private final String name;
    private final Race race;
    private int currentHealth;
    private final InventoryObject[] inventory = new InventoryObject[10];
    private boolean overloaded;
    private int money = 200;

    public Hero(String name, Race race) {
        this.name = name;
        this.race = race;
        this.currentHealth = race.getHealth();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void consumeFood(int index) {
        InventoryObject io = inventory[index];
        if (io instanceof Food) {
            addHealth(((Food) io).getHealthPoints());
            io.removeOneToCount();
            if (io.getCount() == 0)
                inventory[index] = null;
        }
    }

    public void showEquipment() {
        Stream.of(inventory)
                .filter(Objects::nonNull)
                .map(InventoryObject::showItem)
                .forEach(System.out::println);
    }

    public void addDamage(int dmg) {
        this.damage += dmg;
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

    public double getTotalWeight(){
        return Stream.of(inventory)
                .filter(Objects::nonNull)
                .map(i->i.getCount()*i.getWeight())
                .reduce(Double::sum)
                .orElse(0.0);
    }

    private void checkOverload() {
        overloaded = getTotalWeight() > MAX_LOAD;
    }

    public void addHealth(int heal) {
        this.currentHealth += heal;
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
        return currentHealth <= 0;
    }


    @Override
    public void getDamage(int dmg) throws GameOverException {
        currentHealth -= dmg;
        if (currentHealth < 1)
            throw new GameOverException();
    }

    @Override
    public int dealDamage() {
        return damage;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hero hero = (Hero) o;

        if (name != null ? !name.equals(hero.name) : hero.name != null) return false;
        return race == hero.race;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (race != null ? race.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", race=" + race +
                '}';
    }

    public int getMoney() {
        return money;
    }

    public Race getRace() {
        return race;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void deductMoney(int amount) {
        this.money -= amount;
    }

    public boolean isOverloaded() {
        return overloaded;
    }
}
