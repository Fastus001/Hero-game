package inventory;

public abstract class InventoryObject {
    private final String name;
    private final double weight;
    private int count;

    public InventoryObject(String name, double weight, int count) {
        this.name = name;
        this.weight = weight;
        this.count = count;
    }

    public InventoryObject(String name, double weight) {
        this(name, weight, 1);
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void addOneToCount() {
        this.count++;
    }

    public void removeOneToCount() {
        this.count--;
    }

    public int getCount() {
        return count;
    }


    public String showItem() {
        return String.format("Item: %s, weight: %.2f, count: %d\n", name, weight, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InventoryObject that = (InventoryObject) o;

        if (Double.compare(that.weight, weight) != 0) return false;
        return name.equals(that.name);
    }
}
