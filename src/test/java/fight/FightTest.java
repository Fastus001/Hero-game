package fight;

import character.Hero;
import inventory.Weapon;
import npc.Bandit;
import npc.Enemy;
import npc.Monster;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FightTest {
    @Test
    public void testFighClass()
    {
        Hero hero = new Hero("tom", "Kar");
        Enemy enemy = new Monster("most",25,10,"To jest potwór");
        Fight fight = new Fight(hero,enemy);

        fight.executeFight();

        assertTrue(enemy.isDamageLethal());
    }


    @Test
    public void testFighClassWithBandit()
    {
        Hero hero = new Hero("tom", "Kar");
        Enemy enemy = new Bandit("Bandit",25,10,
                new Weapon("axe",10,15));
        Fight fight = new Fight(hero,enemy);

        fight.executeFight();
        assertEquals("axe",hero.getItem(0).getName());
    }

}