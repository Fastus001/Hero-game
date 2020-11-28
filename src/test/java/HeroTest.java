import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    public void testClass()
    {
        Hero hero = new Hero("Tom", "Hero");
        hero.addNewItem(new InventoryObject("Sword", 10));
        hero.addNewItem(new InventoryObject("Sword", 10));
        hero.addNewItem(new InventoryObject("Potatoes", 100));
        hero.showEquipment();
    }

    @Test
    public void testTooManyItems()
    {
        Hero hero = new Hero("Tom", "Hero");
        for (int i = 0; i < 11; i++) {
            hero.addNewItem(new InventoryObject("Sword"+i, 10));
        }
        hero.showEquipment();
        assertFalse(hero.addNewItem(new InventoryObject("Swordsas", 10)));
    }

}