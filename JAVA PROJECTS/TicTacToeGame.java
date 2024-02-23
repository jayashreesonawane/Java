import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        int moves = 0;
        displayBoard(board);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            makeMove(board, 'X', scanner);
            moves++;
            displayBoard(board);
            if (isGameFinished(board, 'X')) {
                System.out.println("Player X wins!");
                break;
            }
            if (moves == 9) {
                System.out.println("It's a tie!");
                break;
            }

            makeMove(board, 'O', scanner);
            moves++;
            displayBoard(board);
            if (isGameFinished(board, 'O')) {
                System.out.println("Player O wins!");
                break;
            }
        }
        scanner.close();
    }

    public static void displayBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " | ");
            }
            System.out.println();
        }
    }

    public static void makeMove(char[][] board, char player, Scanner scanner) {
        int row, col;

        while (true) {
            System.out.print("Player " + player + ", enter row (0-2): ");
            row = scanner.nextInt();
            System.out.print("Player " + player + ", enter column (0-2): ");
            col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move, try again.");
            } else {
                break;
            }
        }
        board[row][col] = player;
    }

    public static boolean isGameFinished(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
}
