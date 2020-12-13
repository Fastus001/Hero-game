package trade;

import character.Hero;
import exceptions.NoEmptySlotException;
import inventory.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.BodyPart;
import utils.Race;

import java.util.List;

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
        trader.addItem(new PricedItem(new Weapon("miecz",10,20),20));
        trader.addItem(new PricedItem(new Weapon("axe",20,30),20));
        trader.addItem(new PricedItem(new Weapon("bow",10,25),80));
        trader.addItem(new PricedItem(new Food("jabłko", 12, 10, 15),2));
        trader.addItem(new PricedItem(new Food("chleb", 4, 2, 5),1));
        trader.addItem(new PricedItem(new ArmorPart("Hełm", 10, 2, BodyPart.HEAD),30));
        trader.addItem(new PricedItem(new ArmorPart("Klata", 30, 8, BodyPart.TORSO),80));
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

    @Test
    void filterByPrice() {
        assertEquals(3,tradeMode.filterByPrice(19, 50).size());
    }

    @Test
    void sumOfTraderGoods() {
        assertEquals(252,tradeMode.sumOfTraderGoods());
    }

    @Test
    void getWeaponsByDamage() {
        List<InventoryObject> weaponsByDamage = tradeMode.getWeaponsByDamage(19, 26);
        Weapon weapon = (Weapon) weaponsByDamage.get(1);
        assertAll(
                ()->assertEquals(2,weaponsByDamage.size()),
                ()->assertEquals(25,weapon.getDamagePoints()));
    }
}