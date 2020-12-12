package character;

import exceptions.GameOverException;
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
                hero.addNewItem(new Weapon("Sword"+i, 15,15));
            } catch (NoEmptySlotException e) {
                e.printStackTrace();
            }
        }
        assertTrue(hero.isOverloaded());
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

    @Test
    public void testReceivedLethalDamage() throws GameOverException {
        Hero hero = new Hero("Tom", Race.HUMAN);
        assertThrows(GameOverException.class,()->hero.getDamage(100));
    }

}