import java.util.Scanner;

public class connectFourGame {
    String board[][];
    Boolean winner, draw;
    int winningPlayer, playerTurn;

    public connectFourGame() {
        winningPlayer = 0;
        draw = false;
        playerTurn = 1;
        board = new String[6][7];
        newBoard();  
    }

    private void newBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = "-";
            }
        }
    }

    private void displayBoard() {
        System.out.println("\n----CONNECT 4----\n");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean validInput(String input) {
        return (input.equals("1") ||
                input.equals("2") ||
                input.equals("3") ||
                input.equals("4") ||
                input.equals("5") ||
                input.equals("6") ||
                input.equals("7"));
    }

    private boolean isColumnFull(int column) {
        return board[0][column - 1].equals("X") || board[0][column - 1].equals("O");
    }

    private int getNextAvailableSlot(int column) {
        int position = 5;
        while (position >= 0) {
            if (board[position][column].equals("-")) {
                return position;
            }
            position--;
        }
        return -1;
    }

    private void swapPlayerTurn() {
        playerTurn = (playerTurn == 1) ? 2 : 1;
    }

    private void placePiece() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player " + playerTurn + " - Please select which column to place your piece (1-7): ");
        String input = sc.nextLine();

        while (!validInput(input) || isColumnFull(Integer.parseInt(input))) {
            if (!validInput(input)) {
                System.out.println("Invalid input - Please select a column from 1-7");
            } else {
                System.out.println("Column full, choose another column");
            }
            input = sc.nextLine();
        }

        int columnChoice = Integer.parseInt(input) - 1;
        int rowChoice = getNextAvailableSlot(columnChoice);

        String pieceToPlace = (playerTurn == 1) ? "X" : "O";
        board[rowChoice][columnChoice] = pieceToPlace;
        displayBoard();
        swapPlayerTurn();  
    }

    private boolean isBoardFull() {
        for (int j = 0; j < 7; j++) {
            if (board[0][j].equals("-")) {
                return false;
            }
        }
        return true;
    }

    private String checkVerticalWinner() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j].equals(board[i + 1][j]) &&
                    board[i][j].equals(board[i + 2][j]) &&
                    board[i][j].equals(board[i + 3][j]) &&
                    !board[i][j].equals("-")) {
                    return board[i][j];
                }
            }
        }
        return null;
    }

    private String checkHorizontalWinner() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j].equals(board[i][j + 1]) &&
                    board[i][j].equals(board[i][j + 2]) &&
                    board[i][j].equals(board[i][j + 3]) &&
                    !board[i][j].equals("-")) {
                    return board[i][j];
                }
            }
        }
        return null;
    }

    private String checkLeftDiagonalWinner() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j].equals(board[i + 1][j + 1]) &&
                    board[i][j].equals(board[i + 2][j + 2]) &&
                    board[i][j].equals(board[i + 3][j + 3]) &&
                    !board[i][j].equals("-")) {
                    return board[i][j];
                }
            }
        }
        return null;
    }

    private String checkRightDiagonalWinner() {
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                if (board[i][j].equals(board[i + 1][j - 1]) &&
                    board[i][j].equals(board[i + 2][j - 2]) &&
                    board[i][j].equals(board[i + 3][j - 3]) &&
                    !board[i][j].equals("-")) {
                    return board[i][j];
                }
            }
        }
        return null;
    }

    private int checkWinner() {
        String symbol = checkVerticalWinner();
        if (symbol == null) symbol = checkHorizontalWinner();
        if (symbol == null) symbol = checkLeftDiagonalWinner();
        if (symbol == null) symbol = checkRightDiagonalWinner();

        if (symbol != null) {
            return symbol.equals("X") ? 1 : 2;
        }
        return 0;
    }

    private boolean checkDraw() {
        return isBoardFull() && checkWinner() == 0;
    }

    private void showWinner() {
        System.out.println("\n*****************************");
        System.out.println("PLAYER " + winningPlayer + " WINS!!!");
        System.out.println("*****************************\n");
    }

    public void playGame() {
        while (winningPlayer == 0 && !draw) {
            placePiece();
            winningPlayer = checkWinner();
            draw = checkDraw();
            if (winningPlayer != 0) {
                showWinner();
            } else if (draw) {
                System.out.println("It's a DRAW!");
            }
        }
    }

    public static void main(String[] args) {
        connectFourGame c4 = new connectFourGame();
        c4.playGame();
    }
}
