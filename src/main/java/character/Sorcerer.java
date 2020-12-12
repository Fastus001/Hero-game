package character;

import exceptions.GameOverException;
import spells.Spell;
import utils.Race;

import java.util.Set;
import java.util.TreeSet;

public class Sorcerer extends Hero{
    private int resistance;
    private final Set<Spell> spellBook = new TreeSet<>();

    public Sorcerer(String name, Race race, int resistance) {
        super(name, race);
        super.setDamage(super.damage*2);
        this.resistance = resistance;
    }

    public void addNewSpell(Spell spell){
        if(spellBook.add(spell)){
            super.addDamage(spell.getAddDamage());
            super.addHealth(spell.getAddHealth());
            this.resistance+= spell.getImmunePts();
        }else{
            System.out.println("Spell is already in your spell book.");
        }
    }

    public void showAvailableSpells(){
        System.out.println("Available spell in your spell book:");
        for(Spell spell:spellBook){
            System.out.println(spell);
        }
    }

    @Override
    public void getDamage(int dmg) throws GameOverException {
        int finalDamage = dmg - getResistance();
        super.getDamage(Math.max(finalDamage, 0));
    }

    public int getResistance() {
        return resistance;
    }
}
