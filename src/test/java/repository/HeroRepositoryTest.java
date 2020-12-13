package repository;

import character.Hero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Race;

import java.util.List;

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

    @Test
    void getHeroesByFirstLetterOfName() {
        List<Hero> b = repository.getHeroesByFirstLetterOfName("B");
        assertEquals(3,b.size());
    }

    @Test
    void getHeroesByRace() {
        List<Hero> heroesByRace = repository.getHeroesByRace(Race.DWARF);
        assertEquals(1,heroesByRace.size());
    }

    @Test
    void getHeroesByHP() {
        List<Hero> heroesByHP = repository.getHeroesByHP(90);
        assertEquals(5,heroesByHP.size());
    }

    @Test
    void getHeroesByWeaponName() {
        List<Hero> axe = repository.getHeroesByWeaponName("Axe");
        assertEquals(1,axe.size());
    }

    @Test
    void getHeroesByLoad() {
        List<Hero> heroesByLoad = repository.getHeroesByWeight(10,100);
        assertEquals(3,heroesByLoad.size());
    }
}