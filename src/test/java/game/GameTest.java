package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException {
        game = new Game();
        game.loadMap();
    }

    @Test
    void loadMap() {
        assertAll(
                ()->assertEquals(9,game.getH().getRow()),
                ()->assertEquals(0,game.getH().getCol())
        );
    }

    @Test
    void testChoosingHero()
    {
        game.chooseHero();
    }

    @Test
    void testMove(){
        game.showMap();
        game.move(0,1);
        game.move(-1,0);

    }
}