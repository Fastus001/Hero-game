package repository;

import character.Hero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroRepositoryTest {
    HeroRepository repository;

    @BeforeEach
    void setUp() {
        repository = new HeroRepository();
    }

    @Test
    void addNewHero() {
        assertEquals(6,repository.getSize());
    }

    @Test
    void chooseHero() {
        repository.showList();
        Hero hero = repository.chooseHero("Thrud");
        assertEquals("Thrud",hero.getName());
    }
}