package game;

import java.util.Random;

public class Game {

    // Symbols and reward coefficients
    private static final String[] SYMBOLS = {"A", "B", "C", "D", "E", "F", "10x", "5x", "+1000", "+500", "MISS"};
    private static final double[] REWARDS = {5, 3, 2.5, 2, 1.2, 1, 10, 5, 1000, 500, 0};
    private static final Random RANDOM = new Random();

    // 3x3 Game Board
    private static String[][] board = new String[3][3];

    // Rastgele bir sembol seçme
    private static String getRandomSymbol() {
        return SYMBOLS[RANDOM.nextInt(SYMBOLS.length)];
    }

    // Fill the game board
    private static void populateBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = getRandomSymbol();
            }
        }
    }

    private static boolean checkWinGame() {
        // Vertical gains
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
                return true;
            }
        }
        // Horizontal gains
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
                return true;
            }
        }
        // Cross earnings
        if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            return true;
        }
        if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
            return true;
        }
        return false;
    }

    public static void playGame() {
        populateBoard();
        System.out.println("Oyun tahtası:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        if (checkWinGame()) {
            System.out.println("You win!");
        } else {
            System.out.println("You have lost!");
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}
