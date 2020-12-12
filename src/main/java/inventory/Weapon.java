package inventory;

public class Weapon extends InventoryObject{
    private final int damagePoints;

    public Weapon(String name, double weight, int damagePoints) {
        super(name, weight);
        this.damagePoints = damagePoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    @Override
    public String toString() {
        return super.getName() +
                ", dmg=" + damagePoints +
                '}';
    }
}
