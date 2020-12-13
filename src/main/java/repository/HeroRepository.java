package repository;

import character.Hero;
import character.Sorcerer;
import character.Warrior;
import exceptions.InvalidTypeException;
import exceptions.NoEmptySlotException;
import inventory.Armor;
import inventory.ArmorPart;
import inventory.Food;
import inventory.Weapon;
import spells.Spell;
import utils.BodyPart;
import utils.Race;

import java.util.*;
import java.util.stream.Collectors;

public class HeroRepository {
    private final Map<String,Hero> heroes = new HashMap<>();


    public HeroRepository() {
        try {
            fillHeroRepository();
        } catch (NoEmptySlotException | InvalidTypeException e) {
            e.printStackTrace();
        }
    }

    private void fillHeroRepository() throws NoEmptySlotException, InvalidTypeException {
        Hero bob = new Hero("Bob", Race.DWARF);
        bob.addNewItem(new Food("Apple",5,2,10));

        this.addNewHero( bob );
        this.addNewHero(new Hero("Mark", Race.HUMAN) );

        Warrior warrior = new Warrior("Thrud", Race.HUMAN, new Weapon("Axe",
                50, 123), new Armor());
        warrior.addNewItem(new ArmorPart("Breast Plate",40,20, BodyPart.TORSO));
        warrior.assignArmorPart(0);
        this.addNewHero(warrior);

        this.addNewHero(new Warrior("BohaterElf", Race.ELF,new Weapon("Sword",
                15,25),new Armor()));

        Sorcerer sorcerer = new Sorcerer("BohaterSorcerer", Race.HUMAN, 15);
        sorcerer.addNewSpell(new Spell("Fireball",15,0,0));
        this.addNewHero(sorcerer);

        sorcerer = new Sorcerer("Rastlin", Race.ELF,25);
        sorcerer.addNewSpell(new Spell("Mage Armor",0,10,20));
        sorcerer.addNewSpell(new Spell("Thorns",10,0,5));
        this.addNewHero(sorcerer);
    }

    public void addNewHero(Hero hero){
        heroes.put(hero.getName(),hero);
    }


    public Hero chooseHero(String name){
        return heroes.get(name);
    }

    public void showList() {
        for (Map.Entry<String,Hero> entry:heroes.entrySet()){
            System.out.println("Nazwa = " + entry.getKey() +
                    " - " + entry.getValue());
        }
    }

    public int getSize() {
        return heroes.size();
    }

    public List<Hero> getHeroesByFirstLetterOfName(String ch){
        return heroes.keySet()
                .stream()
                .filter(key -> key.contains(ch))
                .map(heroes::get)
                .collect(Collectors.toList());
    }

    public List<Hero> getHeroesByRace(Race race){
        return heroes.values()
                .stream()
                .filter(val->val.getRace().equals(race))
                .collect(Collectors.toList());
    }
    public List<Hero> getHeroesByHP(int hp){
        return heroes.values()
                .stream()
                .filter(h->h.getCurrentHealth()>=hp)
                .collect(Collectors.toList());
    }

    public List<Hero> getHeroesByWeaponName(String weaponName){
        return heroes.values()
                .stream()
                .filter(h->h instanceof Warrior)
                .filter(h -> ((Warrior) h).getWeapon().getName().equals(weaponName))
                .collect(Collectors.toList());
    }

    public List<Hero> getHeroesByWeight(int min, int max){
        return heroes.values()
                .stream()
                .filter(h -> h.getTotalWeight()>=min && h.getTotalWeight()<=max)
                .collect(Collectors.toList());
    }



}
