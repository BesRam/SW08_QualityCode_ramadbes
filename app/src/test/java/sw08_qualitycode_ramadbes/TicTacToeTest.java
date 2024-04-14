package sw08_qualitycode_ramadbes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
    }

    @Test
    void testInitialBoardIsEmpty() {
        assertTrue(game.isBoardEmpty(), "The board should be empty at the beginning of the game.");
    }

    @Test
    void testPlayerXGoesFirst() {
        assertEquals('X', game.getCurrentPlayer(), "Player X should start the game.");
    }

    @Test
    void testMakeMove() {
        game.makeMove(0, 0);
        assertFalse(game.isBoardEmpty(), "The board should not be empty after a move.");
        assertEquals('O', game.getCurrentPlayer(), "Player O should be next after X makes a move.");
    }

    @Test
    void testInvalidMove() {
        game.makeMove(0, 0); // X macht einen Zug.
        game.switchPlayer(); // Wechsle zu O.
        game.makeMove(0, 0); // O versucht denselben Zug.
        game.switchPlayer(); // Wechsle zurück zu X.
        // Wir könnten prüfen, ob das Spiel korrekt behandelt wurde, indem wir sehen, ob der Spieler gewechselt hat.
        assertEquals('X', game.getCurrentPlayer(), "The current player should still be X after an invalid move by O.");
    }

    @Test
    void testSwitchPlayer() {
        game.switchPlayer();
        assertEquals('O', game.getCurrentPlayer(), "It should be player O's turn after switching.");
    }

    @Test
    void testCheckForWin() {
        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X gewinnt.
        assertTrue(game.checkForWin(), "Player X should have won.");
    }

    @Test
    void testBoardFull() {
        // Befülle das Brett mit abwechselnden Zügen.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.makeMove(i, j);
                game.switchPlayer();
            }
        }
        assertTrue(game.isBoardFull(), "The board should be full.");
    }
}
