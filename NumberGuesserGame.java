import java.util.Scanner;
import java.util.Random;

public class NumberGuesserGame {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean playAgain = true; // adds option to play again at the end of the game
        while (playAgain) {
            Random r = new Random();
            int attempts = 5;
            int generatedNumber = r.nextInt(101); // computer generates number
            System.out.println("The computer has picked an integer between 0-100, try to guess it!\n");

            boolean gameWon = false;
            int guess = 0;

            while (attempts > 0 && !gameWon) {
                System.out.println("Input your guess (attempts remaining: " + attempts + "):");
                if (userInput.hasNextInt()) {
                    guess = userInput.nextInt();
                } else {
                    System.out.println("Please input an integer!");
                    userInput.next();
                    continue;
                } // makes sure that player inputs an integer instead of something else

                if (guess > generatedNumber) {
                    attempts--;
                    if (attempts > 0) {
                        System.out.println("Too high, guess lower!");
                    }
                } else if (guess < generatedNumber) {
                    attempts--;
                    if (attempts > 0) {
                        System.out.println("Too low, guess higher!");
                    }
                } else {
                    gameWon = true;
                    System.out.println("You guessed correctly! Good job!");
                    System.out.println("Thanks for playing!");
                }
            }

            if (attempts == 0 && !gameWon) {
                if (guess > generatedNumber) {
                    System.out.println("You guessed too high and ran out of attempts!");
                    System.out.println("Better luck next time!");
                } else {
                    System.out.println("You guessed too low and ran out of attempts!");
                    System.out.println("Better luck next time!");
                }
                System.out.println("The number was: " + generatedNumber);
            }

            System.out.println("Do you want to play again? (y/n)");
            String playAgainOption;
            boolean validInput = false;
            while (!validInput) {
                playAgainOption = userInput.next().toLowerCase();
                if (playAgainOption.equals("y") || playAgainOption.equals("yes")) {
                    playAgain = true;
                    validInput = true;
                } else if (playAgainOption.equals("n") || playAgainOption.equals("no")) {
                    System.out.println("Hope you had fun!");
                    playAgain = false;
                    validInput = true;
                } else {
                    System.out.println("Please enter 'y' for yes or 'n' for no!");
                } // makes sure the player enters y or n instead of something else
            }
        }
    }
}
