import java.util.Scanner;

public class TicTacToe {
    static Scanner in = new Scanner(System.in);
    static char[][] board = new char[3][3];
    static char player = 'X';
    static int[] check = new int[9];


    //	TicTacToe in one class without OOP

    public static void main(String[] args) {

        initializeBoard(); 	// Method for initialize this char: '-' to the board.
        int movesLeft = 9;
        boolean gameFinished = false;
        boolean checking = false;
        printBoard(); 	// Method for print the board.

        while (!gameFinished) {

            for (int i = 0; !gameFinished; i++) {
                System.out.println("\nPlayer " + player + " enter an number: #" + (i + 1));
                check[i] = in.nextInt();

                for (int y = i - 1; y >= 0; y--) {

                    if (check[i] == check[y]) {
                        checking = true;
                    }
                }

                if (validMove(check[i]) && !checking) {
                    if (check[i] == 1) {
                        board[0][0] = player;

                    } else if (check[i] == 2) {
                        board[0][1] = player;

                    } else if (check[i] == 3) {
                        board[0][2] = player;

                    } else if (check[i] == 4) {
                        board[1][0] = player;

                    } else if (check[i] == 5) {
                        board[1][1] = player;

                    } else if (check[i] == 6) {
                        board[1][2] = player;

                    } else if (check[i] == 7) {
                        board[2][0] = player;

                    } else if (check[i] == 8) {
                        board[2][1] = player;

                    } else if (check[i] == 9) {
                        board[2][2] = player;

                    }
                    if (checkwins()) {
                        printBoard();
                        System.out.println("\nPlayer " + player + " you win");
                        gameFinished = true;
                        break;
                    }
                    movesLeft--;
                    printBoard();

                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                    if (movesLeft == 0) {
                        System.out.println("\nIt's a draw.");
                        gameFinished = true;
                    }

                } else {
                    System.out.println("Invalid Input.Try again");
                    System.out.println("------------------------");
                    i--;
                    checking = false;
                    printBoard();
                }

            }
        }
    }

    // All the Method that are using in this program.

    public static void initializeBoard() { // Method for initialize this char: '-' to the board.
        for (int raw = 0; raw < 3; raw++) {
            for (int col = 0; col < 3; col++) {
                board[raw][col] = '-';
            }
        }
    }

    public static void printBoard() { // Method for print the board
        System.out.print("\t\t\t-------------");
        for (int row = 0; row < board.length; row++) {
            System.out.println("");
            System.out.print("\t\t\t| ");

            for (int col = 0; col < board.length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.print("\n\t\t\t-------------");
        }
    }

    public static boolean validMove(int r) { // Method that are checking the input if is valid or not means between[1-9]
        if (r >= 1 && r <= 9)
            return true;
        else
            return false;
    }

    public static boolean checkwins() { // Method that check if there is a winner or not

        if (board[0][0] == player && board[0][1] == player && board[0][2] == player) {
            return true;
        }
        if (board[1][0] == player && board[1][1] == player && board[1][2] == player) {
            return true;
        }
        if (board[2][0] == player && board[2][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][0] == player && board[1][0] == player && board[2][0] == player) {
            return true;
        }
        if (board[0][1] == player && board[1][1] == player && board[2][1] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][2] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        } else {
            return false;
        }
    }

    public static void checkRep() {		// Method for checking if is a duplicate input or case.

        for (int q = 0; q < check.length; q++) {

            for (int y = q - 1; y >= 0; y--) {

                if (check[q] == check[y]) {
                    q--;
                    System.out.println("invalid num");
                }
            }
        }
    }
}