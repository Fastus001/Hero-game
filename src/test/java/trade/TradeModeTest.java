package trade;

import character.Hero;
import exceptions.NoEmptySlotException;
import inventory.Food;
import inventory.PricedItem;
import inventory.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Race;

import static org.junit.jupiter.api.Assertions.*;

class TradeModeTest {
    TradeMode tradeMode;
    Hero hero;

    @BeforeEach
    void setUp() {
        Trader trader = setUpTrader();
        hero = setUpHero();
        tradeMode = new TradeMode(trader,hero);
    }

    private Hero setUpHero() {
        hero = new Hero("Wayl", Race.DWARF);
        hero.addMoney(100);
        return hero;
    }

    private Trader setUpTrader() {
        Trader trader = new Trader();
        trader.addNewItem(new PricedItem(new Weapon("miecz",10,20),20));
        trader.addNewItem(new PricedItem(new Food("jabłko", 12, 10, 15),2));
        return trader;
    }

    @Test
    void showAvailableItem() {
        tradeMode.showAvailableItem();
    }

    @Test
    void buyItem() throws NoEmptySlotException {
        tradeMode.buyItem("miecz");
        assertEquals("miecz",hero.getItem(0).getName());
    }
}