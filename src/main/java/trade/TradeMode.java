package trade;

import character.Hero;
import exceptions.NoEmptySlotException;
import inventory.InventoryObject;
import inventory.PricedItem;
import inventory.Weapon;

import java.util.List;
import java.util.stream.Collectors;

public class TradeMode {
    private final Trader trader;
    private final Hero hero;

    public TradeMode(Trader trader, Hero hero) {
        this.trader = trader;
        this.hero = hero;
    }

    public void showAvailableItem() {
        trader.showStock();
    }

    public void buyItem(String itemName) throws NoEmptySlotException {
        PricedItem pricedItem = trader.getPricedItem(itemName);
        if (hero.getMoney() >= pricedItem.getPrice()) {
            hero.addNewItem(pricedItem.getItem());
            hero.deductMoney(pricedItem.getPrice());
            trader.removeItem(itemName);
        } else {
            System.out.println("You don't have enough money to buy that item.");
        }
    }

    public List<PricedItem> getByPrice(int min, int max){
        return trader.getStock()
                .values()
                .stream()
                .filter(v->v.getPrice()>=min && v.getPrice()<=max)
                .collect(Collectors.toList());
    }

    public int sumOfTraderGoods(){
        return trader.getStock()
                .values()
                .stream()
                .map(iP->iP.getPrice()*iP.getItem().getCount())
                .reduce(Integer::sum)
                .orElse(0);
    }

    public List<InventoryObject> getWeaponsByDamage(int min, int max){
        return trader.getStock()
                .values()
                .stream()
                .map(PricedItem::getItem)
                .filter(inventoryObject -> inventoryObject instanceof Weapon)
                .filter(w->((Weapon)w).getDamagePoints()>=min && ((Weapon)w).getDamagePoints()<=max)
                .collect(Collectors.toList());
    }
}
