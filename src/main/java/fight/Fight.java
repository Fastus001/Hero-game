package fight;

import character.Hero;
import exceptions.GameOverException;
import exceptions.NoEmptySlotException;
import npc.Bandit;
import npc.Enemy;

public class Fight {
    private final Hero hero;
    private final Enemy enemy;

    public Fight(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    public void executeFight() throws GameOverException {
        while (true)
        {
            enemy.getDamage(hero.dealDamage());
            if(enemy.isDamageLethal())
            {
                if(enemy instanceof Bandit)
                {
                    try {
                        hero.addNewItem(((Bandit) enemy).dropWeapon());
                    } catch (NoEmptySlotException e) {
                        e.printStackTrace();
                    }
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
