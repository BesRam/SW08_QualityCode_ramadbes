package sw08_qualitycode_ramadbes;

import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static TicTacToe game = new TicTacToe();

    public static void main(String[] args) {
        int row, col;
        while (true) {
            System.out.println("Aktueller Stand des Spielfelds:");
            game.printBoard();  // Zeigt das Spielbrett an
            System.out.println("Spieler " + game.getCurrentPlayer() + " ist an der Reihe.");
            System.out.println("Bitte Reihe eingeben (0, 1 oder 2): ");
            row = scanner.nextInt();
            System.out.println("Bitte Spalte eingeben (0, 1 oder 2): ");
            col = scanner.nextInt();
            
            if (game.isMoveValid(row, col)) {
                game.makeMove(row, col);
            } else {
                System.out.println("Ungültiger Zug! Bitte ein leeres Feld wählen.");
                continue;  // Überspringt den Rest der Schleife und fährt mit der nächsten Iteration fort.
            }

            if (isGameOver()) {
                game.printBoard();  // Zeigt das endgültige Spielbrett an
                System.out.println("Spiel ist vorbei! Spieler " + game.getCurrentPlayer() + " hat gewonnen!");
                break;
            } else if (game.isBoardFull()) {
                game.printBoard();  // Zeigt das endgültige Spielbrett an
                System.out.println("Spiel ist vorbei! Es ist ein Unentschieden!");
                break;
            }
            game.switchPlayer(); // Wechselt den Spieler für den nächsten Zug
        }
        scanner.close();
    }

    private static boolean isGameOver() {
        return game.checkForWin();
    }
}
