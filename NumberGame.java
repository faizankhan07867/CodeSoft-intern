import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("=== Number Guessing Game ===");

        boolean playAgain = true;
        while (playAgain) {
            int max = 100;
            int secret = rand.nextInt(max) + 1; // 1..100
            int attemptsAllowed = 7; // changeable
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nI have chosen a number between 1 and " + max + ".");
            System.out.println("You have " + attemptsAllowed + " attempts. Good luck!");

            while (attempts < attemptsAllowed) {
                System.out.print("Enter your guess: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a whole number.");
                    sc.next(); // discard invalid token
                    continue;
                }
                int guess = sc.nextInt();
                attempts++;

                if (guess == secret) {
                    System.out.println("🎉 Correct! You guessed it in " + attempts + " attempt(s).");
                    guessed = true;
                    break;
                } else if (guess < secret) {
                    System.out.println("Too low. Attempts left: " + (attemptsAllowed - attempts));
                } else {
                    System.out.println("Too high. Attempts left: " + (attemptsAllowed - attempts));
                }
            }

            if (!guessed) {
                System.out.println("Sorry — you've used all attempts. The number was: " + secret);
            }

            System.out.print("Play again? (y/n): ");
            String answer = sc.next();
            playAgain = answer.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing!");
        sc.close();
    }
}
