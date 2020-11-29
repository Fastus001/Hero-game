package character;

import inventory.Weapon;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HeroTest {

    @Test
    public void testTooManyItems()
    {
        Hero hero = new Hero("Tom", "hero.Hero");

        for (int i = 0; i < 11; i++) {
            hero.addNewItem(new Weapon("Sword"+i, 10,15));
        }
        hero.showEquipment();
    }

    @Test
    public void testAddItemMethod()
    {
        Hero hero = new Hero("Tom", "hero.Hero");

        hero.addNewItem(new Weapon("Sword", 10,15));

        assertThat(hero.getItem(0)).isEqualTo(new Weapon("Sword", 10,15));
    }

}