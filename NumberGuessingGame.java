import java.util.*;
class NumberGuessingGame{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String play="yes";
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("^              WELCOME TO NUMBER GUESSING GAME!           ^");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        while(play.equals("yes")){
            int guess=-1;
            int trial=0;
            Random rand = new Random();
            int num=rand.nextInt(100);
            while(guess!=num){
                System.out.println("--------------------------------------");
                System.out.print("Guess a number between 1 and 100: ");
                
                guess = sc.nextInt();
                
                trial++;
                if(guess==num){
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("| Congratulations! You guessed the right number!                |");
                    System.out.println("| You guessed it in "+trial+" trials                                    |");
                    System.out.println("| Would you like to continue to play the game? Type: yes or no. |");
                    System.out.println("----------------------------------------------------------------");
                    play = sc.next().toLowerCase();
                }
                else if(guess>num){
                    System.out.println("| Your guess is too high!            |");
                    System.out.println("--------------------------------------");
                }else{ 
                    System.out.println("| Your guess is too low!             |");
                    System.out.println("--------------------------------------");
                }
            }
        }
        sc.close();
    }
}