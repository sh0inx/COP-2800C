import java.util.Scanner;

public class Guess {

    public static void greeting() {
        System.out.println("Hello there!");
        System.out.println("How about a guessing game?\n");
    }

    public static void guide() {
        System.out.println("HOW TO PLAY");
        System.out.println("=-=-=-=-=-=-=");

        System.out.println("The goal is to guess the sum of the dice.");
        System.out.println("If you guess correctly, you win!");
        System.out.println("However, you only get three chances.");
        System.out.println("If you don't guess correctly three times, you lose.");
    }

    public static boolean prompt(Scanner scanner) {
        System.out.println("\nWhat would you like to do?\n");

        System.out.println("r - View information on How to Play");
        System.out.println("g - Guess the sum of the dice");
        System.out.println("q - Quit the game\n");

        String input = scanner.next();

        while (!((input.equalsIgnoreCase("r")) ||
                 (input.equalsIgnoreCase("g")) ||
                 (input.equalsIgnoreCase("q")))) {

            System.out.println("Sorry, that's not a valid option.");
            System.out.println("Please select \"r\" (how-to-play), \"g\" (play game), or \"q\" (quit).");
            input = scanner.next();
        }

        boolean end = true;

        if (input.equalsIgnoreCase("r")) {
            end = false;
            guide();
            prompt(scanner);
        } else if (input.equalsIgnoreCase("g")) {
            end = false;
        }

        return end;
    }

    public static int playerGuess(Scanner scanner) {
        System.out.print("Please select a number between 2 and 12. ");
        int guess = scanner.nextInt();

        while((guess < 2) || (guess > 12)) {
            System.out.println("Sorry, that wasn't a valid guess.");
            System.out.print("Please select a number between 2 and 12. ");

            guess = scanner.nextInt();
        }

        return guess;
    }

    public static void win(int result, int attempts, int streak) {
        System.out.println("\nCongratulations!");
        System.out.println("The dice rolled a " + result + "!\n");
        System.out.println("You took " + attempts + " tries to guess correctly.");
        System.out.println("You have a win streak of " + streak + ".\n");
    }

    public static void lose(int result, int streak) {
        System.out.println("\nToo bad!");
        System.out.println("The dice rolled a " + result + "!\n");
        System.out.println("You've used all three of your turns.");
        System.out.println("You've lost your win streak (" + streak + ").");
    }

    public static boolean playAgain(Scanner scanner) {
        System.out.println("Would you like to play again? (\"Y\" for yes) (\"N\" for no)");
        String input = scanner.next();

        while(!((input.equalsIgnoreCase("y")) ||
                (input.equalsIgnoreCase("n")))) {

            System.out.println("Sorry, that's not a valid input.");
            System.out.println("Would you like to play again? (\"Y\" for yes) (\"N\" for no)");

            input = scanner.next();
        }

        switch (input) {
            case "Y":
            case "y":
                return true;
            case "N":
            case "n":
            default:
                return false;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean end = false;
        boolean win = false;
        int streak = 0;

        greeting();
        guide();

        Die dieA = new Die();
        Die dieB = new Die();

        int result = 0;

        do {
            end = prompt(scanner);

            dieA.roll();
            dieB.roll();

            result = (dieA.getRoll() + dieB.getRoll());

            for (int i = 0; i <= 2; i++) {
                if (end) {
                    break;
                }

                int guess = playerGuess(scanner);
                System.out.print("\nYour guess: " + guess + "\n");

                if (guess == result) {
                    streak++;
                    win = true;
                    win(result, (i + 1), streak);
                    break;
                }
            }

            if (end) {
                break;
            }

            if(!win) {
                lose(result, streak);
                streak = 0;
                win = false;
            }

        }


        while(playAgain(scanner));

        scanner.close();

    }
}
