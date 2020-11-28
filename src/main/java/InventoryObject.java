public class InventoryObject {
    private String name;
    private double weight;
    private int count;

    public InventoryObject(String name, double weight, int count) {
        this.name = name;
        this.weight = weight;
        this.count = count;
    }

    public InventoryObject(String name, double weight) {
        this(name,weight,1);
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

    public int getCount() {
        return count;
    }

    public void showItem()
    {
        System.out.printf("Item: %s, weight: %.2f, count: %d\n", name,weight,count);
    }
}
