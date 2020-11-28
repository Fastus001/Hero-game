package inventory;

public class Food extends InventoryObject{
    private int healthPoints;

    public Food(String name, double weight, int count, int healthPoints) {
        super(name, weight, count);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}
