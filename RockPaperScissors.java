import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        String rock = 
            "    _______\n" +
            "---'   ____)\n" +
            "      (_____)\n" +
            "      (_____)\n" +
            "      (____)\n" +
            "---.__(___)\n";

        String paper = 
            "    _______\n" +
            "---'   ____)____\n" +
            "          ______)\n" +
            "          _______)\n" +
            "         _______)\n" +
            "---.__________)\n";

        String scissors = 
            "    _______\n" +
            "---'   ____)____\n" +
            "          ______)\n" +
            "       __________)\n" +
            "      (____)\n" +
            "---.__(___)\n";

        String[] gameImages = {rock, paper, scissors};

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("What do you choose? Type 0 for Rock, 1 for Paper, or 2 for Scissors.");
            int userChoice = scanner.nextInt();

            if (userChoice >= 3 || userChoice < 0) {
                System.out.println("You typed an invalid number, you lose!");
            } else {
                System.out.println(gameImages[userChoice]);

                int computerChoice = random.nextInt(3);
                System.out.println("Computer chose:");
                System.out.println(gameImages[computerChoice]);

                if (userChoice == 0 && computerChoice == 2) {
                    System.out.println("You win!");
                } else if (computerChoice == 0 && userChoice == 2) {
                    System.out.println("You lose");
                } else if (computerChoice > userChoice) {
                    System.out.println("You lose");
                } else if (userChoice > computerChoice) {
                    System.out.println("You win!");
                } else if (computerChoice == userChoice) {
                    System.out.println("It's a draw");
                }
            }

            System.out.println("Do you want to play again? Type 'yes' to play again or 'no' to quit.");
            String userResponse = scanner.next().toLowerCase();
            if (!userResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
