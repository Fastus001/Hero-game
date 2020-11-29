package npc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    private Enemy enemy;

    @BeforeEach
    void setup()
    {
        enemy = new Monster("Ork",25,20,"BigUnz");
    }
    @Test
    void isDamageLethal() {
        enemy.getDamage(25);

        assertTrue(enemy.isDamageLethal());
    }

    @Test
    void changeHeath() {
        enemy.changeHeath(8);

        assertEquals(17,enemy.getHealth());
    }

    @Test
    void dealDamage() {
        for (int i = 0; i < 100; i++) {
            int damage = enemy.dealDamage();
            assertThat(damage).isBetween(20,24);
        }
    }
}