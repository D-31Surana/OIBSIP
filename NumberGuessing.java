
import javax.swing.*;
public class class1 {

	public static void main(String[] args) {
	        playGame();
	    }

	    public static void playGame() {
	        int compNumber = (int) (Math.random() * 100 + 1);
	        int userAns = 0;
	        int count = 1;

	        while (userAns != compNumber) {
	            String response = JOptionPane.showInputDialog(null,
	                    "Enter a guess between 1 and 100", "Number Guessing Game", JOptionPane.PLAIN_MESSAGE);
	            try {
	                userAns = Integer.parseInt(response);

	                if (userAns <= 0 || userAns > 100) {
	                    JOptionPane.showMessageDialog(null, "Your guess is out of range. Try again.",
	                            "Invalid Guess", JOptionPane.WARNING_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(null, determineGuess(userAns, compNumber, count),
	                            "Result", JOptionPane.INFORMATION_MESSAGE);
	                    count++;
	                }
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.",
	                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	        int playAgain = JOptionPane.showConfirmDialog(null, "Congratulations! You guessed the number in " + (count - 1) + " attempts.\nDo you want to play again?",
	                "Game Over", JOptionPane.YES_NO_OPTION);

	        if (playAgain == JOptionPane.YES_OPTION) {
	            playGame();
	        } else {
	            JOptionPane.showMessageDialog(null, "Thank you for playing. Goodbye!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
	        }
	    }
	    public static String determineGuess(int userAns, int compNumber, int count) {
	        if (userAns == compNumber) {
	            return "Correct!\nTotal Guesses: " + count;
	        } else if (userAns > compNumber) {
	            return "Your guess is too high. Try again.\nTry Number: " + count;
	        } else {
	            return "Your guess is too low. Try again.\nTry Number: " + count;
	        }
	    }
	}
