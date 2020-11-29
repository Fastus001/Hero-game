package npc;

import inventory.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    @Test
    public void testMonsterClass()
    {
        Enemy enemy = new Monster("T",10,12,"Monstrous T");
        enemy.changeHeath(12);
        assertTrue(enemy.isDamageLethal());
    }

    @Test
    public void testMonsterBandit()
    {
        Enemy enemy = new Bandit("band",10,12,
                new Weapon("Sword", 10, 15));
        enemy.changeHeath(6);
        assertFalse(enemy.isDamageLethal());
    }


}