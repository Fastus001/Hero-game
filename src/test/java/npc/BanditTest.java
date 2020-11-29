package npc;

import inventory.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BanditTest {
    private Enemy enemy;

    @BeforeEach
    void setEnemy()
    {
        enemy = new Bandit("Band", 40,10,
                new Weapon("Axe",10,15));
    }
    @Test
    void getDamage() {
        enemy.getDamage(41);
        assertEquals(-1,enemy.getHealth());
    }

    @Test
    void dealDamage() {
        int damage = enemy.dealDamage();

        assertEquals(15,damage);
    }

    @Test
    void dropWeapon() {
        Weapon weapon = ((Bandit) enemy).dropWeapon();
        assertEquals("Axe", weapon.getName());
    }
}