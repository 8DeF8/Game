package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testWhenFirstPlayerWin() {
        Player hook = new Player(5, "Хук", 500);
        Player vong = new Player(7, "Вонг", 350);
        Game game = new Game();

        game.register(hook);
        game.register(vong);
        int actual = game.round("Хук", "Вонг");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayer2Win() {
        Player hook = new Player(5, "Хук", 200);
        Player vong = new Player(7, "Вонг", 700);
        Game game = new Game();

        game.register(hook);
        game.register(vong);
        int actual = game.round("Хук", "Вонг");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerEqual() {
        Player hook = new Player(5, "Хук", 700);
        Player vong = new Player(7, "Вонг", 700);
        Game game = new Game();

        game.register(hook);
        game.register(vong);
        int actual = game.round("Хук", "Вонг");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist2() {
        Player hook = new Player(5, "Хук", 200);
        Player vong = new Player(7, "Вонг", 700);
        Game game = new Game();

        game.register(hook);
        game.register(vong);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Джек", "Хук")
        );
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player hook = new Player(5, "Хук", 200);
        Player vong = new Player(7, "Вонг", 700);
        Game game = new Game();

        game.register(hook);
        game.register(vong);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round( "Хук", "Клэр")
        );
    }
}