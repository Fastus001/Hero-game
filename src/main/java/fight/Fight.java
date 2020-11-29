package fight;

import character.Hero;
import npc.Bandit;
import npc.Enemy;

public class Fight {
    private Hero hero;
    private Enemy enemy;

    public Fight(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    public void executeFight()
    {
        while (true)
        {
            enemy.getDamage(hero.dealDamage());
            if(enemy.isDamageLethal())
            {
                if(enemy instanceof Bandit)
                {
                    hero.addNewItem(((Bandit) enemy).dropWeapon());
                }
                break;
            }
            hero.getDamage(enemy.dealDamage());
            if (hero.isDead())
            {
                break;
            }
        }
    }
}
