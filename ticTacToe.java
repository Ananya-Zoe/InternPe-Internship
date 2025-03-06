import java.util.*;

public class ticTacToe {
    static ArrayList<Integer> playerPostion = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPostion = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] board = {
            {' ', '|', ' ', '|', ' '},
            {'_', '+', '_', '+', '_'},
            {' ', '|', ' ', '|', ' '},
            {'_', '+', '_', '+', '_'},
            {' ', '|', ' ', '|', ' '}
        };
        printBoard(board);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your section/block (1-9): ");
            int playerPos = sc.nextInt();

            while (playerPostion.contains(playerPos) || cpuPostion.contains(playerPos)) {
                System.out.println("Position already taken, enter another position.");
                playerPos = sc.nextInt();
            }

            placePiece(board, playerPos, "player");

            String result = checkWinner();
            if (result.length() > 0) {
                printBoard(board);
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPostion.contains(cpuPos) || cpuPostion.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(board, cpuPos, "cpu");

            printBoard(board);

            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        }
    }

    public static void placePiece(char[][] board, int postion, String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPostion.add(postion);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPostion.add(postion);
        }

        switch (postion) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String checkWinner() {
        List<List<Integer>> winning = new ArrayList<>();
        winning.add(Arrays.asList(1, 2, 3));
        winning.add(Arrays.asList(4, 5, 6));
        winning.add(Arrays.asList(7, 8, 9));
        winning.add(Arrays.asList(1, 4, 7));
        winning.add(Arrays.asList(2, 5, 8));
        winning.add(Arrays.asList(3, 6, 9));
        winning.add(Arrays.asList(1, 5, 9));
        winning.add(Arrays.asList(7, 5, 3));

        for (List<Integer> l : winning) {
            if (playerPostion.containsAll(l)) {
                return "Congratulations you won!";
            } else if (cpuPostion.containsAll(l)) {
                return "Sorry you lost! CPU wins :(";
            }
        }

        if (playerPostion.size() + cpuPostion.size() == 9) {
            return "DRAW!";
        }

        return "";
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
