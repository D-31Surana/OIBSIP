
import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        int maxAttempts = 5;
        int score = 0;
        boolean gameWon = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between " + lowerBound + " and " + upperBound);

        for (int attempts = 1; attempts <= maxAttempts; attempts++) {
            System.out.print("Attempt " + attempts + ": Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                gameWon = true;
                score = maxAttempts - attempts + 1;
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (gameWon) {
            System.out.println("Congratulations! You guessed the number. Your score: " + score);
        } else {
            System.out.println("Sorry, you ran out of attempts. The correct number was: " + randomNumber);
        }
    }
}
