package fight;

import character.Hero;
import character.Warrior;
import exceptions.GameOverException;
import inventory.Armor;
import inventory.Weapon;
import npc.Bandit;
import npc.Enemy;
import npc.Monster;
import org.junit.jupiter.api.Test;
import utils.Race;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {
    @Test
    public void testFightClass()
    {
        Hero hero = new Hero("tom", Race.HUMAN);
        Enemy enemy = new Monster("most",25,10,"To jest potwór");
        Fight fight = new Fight(hero,enemy);

        try {
            fight.executeFight();
        } catch (GameOverException e) {
            e.printStackTrace();
        }

        assertTrue(enemy.isDamageLethal());
    }


    @Test
    public void testFightClassWithBandit()
    {
        Hero hero = new Hero("tom", Race.HUMAN);
        Enemy enemy = new Bandit("Bandit",25,10,
                new Weapon("axe",10,15));
        Fight fight = new Fight(hero,enemy);

        try {
            fight.executeFight();
        } catch (GameOverException e) {
            e.printStackTrace();
        }
        assertEquals("axe",hero.getItem(0).getName());
    }

    @Test
    public void testFightWithWarrior()
    {
        Hero hero = new Warrior("tom", Race.HUMAN,
                new Weapon("Sword",10,25),new Armor());
        Enemy enemy = new Bandit("Bandit",25,10,
                new Weapon("axe",10,15));
        Fight fight = new Fight(hero,enemy);
        try {
            fight.executeFight();
        } catch (GameOverException e) {
            e.printStackTrace();
        }

        assertEquals(25,hero.dealDamage());
    }

}