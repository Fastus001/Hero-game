package repository;

import inventory.Weapon;
import npc.Bandit;
import npc.Enemy;
import npc.Monster;

import java.util.ArrayList;
import java.util.List;

public class NpcRepository {
    private final List<Enemy> enemies = new ArrayList<>();

    public NpcRepository() {
        populateRepository();
    }

    private void populateRepository(){
        enemies.add(new Monster("Ogr",120,40,"Big nasty greenskin!"));
        enemies.add(new Monster("Troll",180,20,"Ugly as shi..."));
        enemies.add(new Monster("Goblin",40,20,"Small and cruel"));
        enemies.add(new Monster("Snotling",30,10,"What is this tiny little...?"));
        enemies.add(new Monster("Skeleton",25,20,"What is that smell?!"));
        enemies.add(new Bandit("Burglar", 40, 10, new Weapon("Sword",10,30)));
        enemies.add(new Bandit("Thief", 60, 10, new Weapon("Dagger",10,40)));
        enemies.add(new Bandit("Thief Master", 80, 10, new Weapon("Magic Dagger",10,55)));
        enemies.add(new Bandit("Bandit Leader", 130, 10, new Weapon("Magic Sword",10,70)));
    }

    public Enemy getRandomEnemies(){
            int i = (int) (Math.random() * enemies.size());
        return enemies.get(i);
    }

}
