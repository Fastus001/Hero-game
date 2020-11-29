package character;

import exceptions.NoEmptySlotException;
import inventory.Weapon;
import org.junit.jupiter.api.Test;
import utils.Race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    public void testTooManyItems()
    {
        Hero hero = new Hero("Tom", Race.HUMAN);

        for (int i = 0; i < 10; i++) {
            try {
                hero.addNewItem(new Weapon("Sword"+i, 10,15));
            } catch (NoEmptySlotException e) {
                e.printStackTrace();
            }
        }
        assertThrows(NoEmptySlotException.class,()->hero.addNewItem(new Weapon("Swords", 10,15)));
    }

    @Test
    public void testAddItemMethod() throws NoEmptySlotException {
        Hero hero = new Hero("Tom", Race.HUMAN);

        hero.addNewItem(new Weapon("Sword", 10,15));

        assertThat(hero.getItem(0)).isEqualTo(new Weapon("Sword", 10,15));
    }

    @Test
    public void shouldHealthBeWhenRaceIsDwarf()
    {
        Hero hero = new Hero("Tom", Race.DWARF);

        assertThat(hero.getCurrentHealth()).isEqualTo(120);
    }

}