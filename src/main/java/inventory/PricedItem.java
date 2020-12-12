package inventory;

public class PricedItem {
    private InventoryObject item;
    private int price;

    public PricedItem(InventoryObject item, int price) {
        this.item = item;
        this.price = price;
    }

    public InventoryObject getItem() {
        return item;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "PricedItem{" +
                "item=" + item +
                ", price=" + price +
                '}';
    }
}
