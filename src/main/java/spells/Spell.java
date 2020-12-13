package spells;

import java.util.Objects;

public class Spell implements Comparable<Spell>{
    private final String name;
    private final int addDamage;
    private final int addHealth;
    private final int immunePts;

    public Spell(String name, int addDamagePts, int addHealth, int immunePts) {
        this.name = name;
        this.addDamage = addDamagePts;
        this.addHealth = addHealth;
        this.immunePts = immunePts;
    }

    public int getAddDamage() {
        return addDamage;
    }

    public int getAddHealth() {
        return addHealth;
    }

    public int getImmunePts() {
        return immunePts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spell spell = (Spell) o;

        if (addDamage != spell.addDamage) return false;
        if (addHealth != spell.addHealth) return false;
        if (immunePts != spell.immunePts) return false;
        return Objects.equals(name, spell.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + addDamage;
        result = 31 * result + addHealth;
        result = 31 * result + immunePts;
        return result;
    }



    @Override
    public String toString() {
        return "Spell name:" + name + " damage: " + addDamage +
                ", health: " + addHealth +
                ", resistance: " + immunePts + ".";
    }

    @Override
    public int compareTo(Spell spell) {
        return this.name.compareTo(spell.name);
    }
}
