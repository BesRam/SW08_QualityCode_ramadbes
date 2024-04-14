package sw08_qualitycode_ramadbes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    @Test
    void testInitialBoardIsEmpty() {
        TicTacToe game = new TicTacToe();
        assertTrue(game.isBoardEmpty(), "The board should be empty at the beginning of the game.");
    }

    @Test
    void testPlayerXGoesFirst() {
        TicTacToe game = new TicTacToe();
        assertEquals('X', game.getCurrentPlayer(), "Player X should start the game.");
    }
}
