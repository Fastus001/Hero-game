package utils;

public enum Race {
    HUMAN(100), ELF(80), DWARF(120);

    private int health;

    Race(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}
