package utils;

import exceptions.GameOverException;

public interface Fightable {

    void getDamage(int dmg) throws GameOverException;

    int dealDamage();
}
