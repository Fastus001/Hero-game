package trade;

import character.Hero;
import exceptions.NoEmptySlotException;
import inventory.PricedItem;

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
}
