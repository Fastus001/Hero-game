package trade;

import inventory.PricedItem;

import java.util.HashMap;
import java.util.Map;

public class Trader {
    private String name;
    private final Map<String, PricedItem> stock = new HashMap<>();

    public void addNewItem(PricedItem pricedItem){
        stock.put(pricedItem.getItem().getName(),pricedItem);
    }

    public void showStock(){
        stock.values().forEach(System.out::println);
    }

    public PricedItem getPricedItem(String itemName){
        return stock.get(itemName);
    }

    public void removeItem(String itemName){
        stock.remove(itemName);
    }

}

