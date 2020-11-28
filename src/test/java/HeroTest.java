import character.Hero;
import inventory.InventoryObject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HeroTest {

    @Test
    public void testTooManyItems()
    {
        Hero hero = new Hero("Tom", "hero.Hero");

        for (int i = 0; i < 11; i++) {
            hero.addNewItem(new InventoryObject("Sword"+i, 10));
        }
        hero.showEquipment();
    }

    @Test
    public void testAddItemMethod()
    {
        Hero hero = new Hero("Tom", "hero.Hero");

        hero.addNewItem(new InventoryObject("Sword", 10));

        assertThat(hero.getItem(0)).isEqualTo(new InventoryObject("Sword",10));
    }

}