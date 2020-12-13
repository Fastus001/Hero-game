package repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NpcRepositoryTest {
    NpcRepository repository;

    @BeforeEach
    void setUp() {
        repository = new NpcRepository();
    }

}