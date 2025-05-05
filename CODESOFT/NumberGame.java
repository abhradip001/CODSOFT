import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain;

        do {
            int numberToGuess = (int) (Math.random() * 100) + 1;
            double userGuess = 0; // Changed to double to handle fractional input
            int attempts = 0;

            System.out.println("Welcome to the Number Guessing Game! Hope you enjoy it!");
            System.out.println("I have selected a number between 1 and 100. Can you guess it? If you guess it right, you will get a score out of 100.");

            while ((int) userGuess != numberToGuess) { // Cast to int for comparison
                System.out.print("Enter your guess: ");
                if (!sc.hasNextDouble()) { // Check if input is not a number
                    System.out.println("Invalid input! Please enter a valid number.");
                    sc.next(); // Clear invalid input
                    continue;
                }

                userGuess = sc.nextDouble();

                // Check if the guess is out of range
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Invalid input! Please enter a number between 1 and 100.");
                    continue; // Skip the rest of the loop and prompt again
                }

                attempts++;

                if ((int) userGuess < numberToGuess) { // Cast to int for comparison
                    System.out.println("Too low! Try again. Keep your mind fresh and think about the number.");
                } else if ((int) userGuess > numberToGuess) { // Cast to int for comparison
                    System.out.println("Too high! Try again. Keep your mind fresh and think about the number.");
                } else {
                    int score = Math.max(0, 100 - (attempts - 1) * 10); // Calculate score
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    System.out.println("Your score: " + score + "/100");

                    // Display message based on the score range
                    if (score <= 30) {
                        System.out.println("Bad score. Can you play another game and improve your score?");
                    } else if (score <= 60) {
                        System.out.println("Average score. Keep trying to improve!");
                    } else if (score <= 80) {
                        System.out.println("Good score. Well done!");
                    } else {
                        System.out.println("Very good guessing skills you have!");
                    }
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thank you for playing the game ! Goodbye! Have a nice day!");
        sc.close();
    }
}