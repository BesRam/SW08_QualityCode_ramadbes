package sw08_qualitycode_ramadbes;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private final char EMPTY_FIELD = ' ';

    public TicTacToe() {
        this.board = new char[3][3];
        // Initialisiere das Brett mit leeren Feldern
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = EMPTY_FIELD;
            }
        }
        this.currentPlayer = 'X'; // X beginnt immer
    }

    public boolean isBoardEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] != EMPTY_FIELD) {
                    return false; // Ein Feld ist nicht leer
                }
            }
        }
        return true; // Alle Felder sind leer
    }

    public char getCurrentPlayer() {
        return this.currentPlayer;
    }

    public boolean isMoveValid(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && this.board[row][col] == EMPTY_FIELD;
    }

    public void makeMove(int row, int col) {
        if (isMoveValid(row, col)) {
            this.board[row][col] = this.currentPlayer;
            switchPlayer();
        }
    }

    public void switchPlayer() {
        this.currentPlayer = (this.currentPlayer == 'X') ? 'O' : 'X';
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(this.board[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("-----");
    }

    public boolean checkForWin() {
        // Horizontal, vertikal und diagonal prüfen
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(this.board[i][0], this.board[i][1], this.board[i][2]) ||
                checkRowCol(this.board[0][i], this.board[1][i], this.board[2][i])) {
                return true;
            }
        }
        return checkRowCol(this.board[0][0], this.board[1][1], this.board[2][2]) ||
               checkRowCol(this.board[0][2], this.board[1][1], this.board[2][0]);
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] == EMPTY_FIELD) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return (c1 != EMPTY_FIELD) && (c1 == c2) && (c2 == c3);
    }
}
