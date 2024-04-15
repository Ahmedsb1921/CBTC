import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {

    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 100;
        int attempts = 0;
        int targetNumber = generateRandomNumber(lowerBound, upperBound);

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number game!\nI've picked a number between "
                + lowerBound + " and " + upperBound + ".\nTry to guess it!");

        int guess;
        boolean guessedCorrectly = false;
        while (!guessedCorrectly) {
            guess = getUserGuess(lowerBound, upperBound);
            attempts++;
            if (guess == targetNumber) {
                guessedCorrectly = true;
                JOptionPane.showMessageDialog(null,
                        "Congratulations! You guessed the number " + targetNumber + " correctly!\nNumber of attempts: "
                                + attempts);
            } else if (guess < targetNumber) {
                JOptionPane.showMessageDialog(null, "Try a higher number.");
            } else {
                JOptionPane.showMessageDialog(null, "Try a lower number.");
            }
        }
    }

    public static int generateRandomNumber(int lowerBound, int upperBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    public static int getUserGuess(int lowerBound, int upperBound) {
        String userInput = JOptionPane.showInputDialog("Enter your guess between " + lowerBound + " and " + upperBound
                + ":");
        int guess = Integer.parseInt(userInput);
        while (guess < lowerBound || guess > upperBound) {
            userInput = JOptionPane.showInputDialog("Invalid input! Enter your guess between " + lowerBound + " and "
                    + upperBound + ":");
            guess = Integer.parseInt(userInput);
        }
        return guess;
    }
}
