package npc;

import utils.Fightable;

public abstract class Enemy implements Fightable {
    private String name;
    private int health;
    private final int damage;

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public boolean isDamageLethal() {
        return health <= 0;
    }

    public void changeHeath(int dmg) {
        health -= dmg;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public int dealDamage() {
        double bonus = (Math.random() * (20) + 1) / 100;
        return (int) (bonus * damage) + damage;
    }


}
