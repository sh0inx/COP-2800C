import java.util.Scanner;

public class Matador {

    public static void greeting() {
        System.out.println("Hello there.");
        System.out.println("Let's play some Matador!");
    }

    public static void rules() {
        System.out.printf("""
                    \nThe object of the game is to be the first reach 99 points.
                    
                    On each turn:
                        1) You'll choose a number between 2 and 6.
                        2) You'll get to roll two dice. Depending on the results of the dice:
                            a) 1 & 1 - Your score is reduced by 25.
                            b) 1 & x - Your score is not changed.
                            c) Not 1 - Your score is increased by the sum of the dice.
                        3) Your chosen number is used to determine what happens next:
                            a) # & # - You win!
                            b) # & x - You get to roll again.
                            c) Not # - You end your turn.\n\s""");
    }

    public static boolean prompt(Scanner scanner) {
        System.out.println("\nWhat would you like to do?\n");

        System.out.println("r - Read the rules");
        System.out.println("p - Play");
        System.out.println("q - Quit");

        String input = scanner.next();
        while(!((input.equalsIgnoreCase("r")) ||
                (input.equalsIgnoreCase("p")) ||
                (input.equalsIgnoreCase("q")))) {

            System.out.println("Sorry, that's not a valid response.");
            System.out.println("Please input \"r\" (rules), \"p\" (play), or \"q\" (quit).");
            input = scanner.next();
        }

        boolean end = true;
        if(input.equalsIgnoreCase("r")) {
            end = false;
            rules();
            prompt(scanner);
        } else if((input.equalsIgnoreCase("p"))) {
            end = false;
        }

        return end;
    }

    public static void win(Player player) {
        System.out.println("\nCongratulations! You win!");
        System.out.println("Your score: " + player.getScore());

    }

    public static void lose(Player player) {
        System.out.println("\nYou've lost.");
        System.out.println("Your score: " + player.getScore());
    }

    public static boolean playAgain(Scanner scanner) {

        System.out.println("Would you like to play again? (\"Y\" for yes, \"N\" for no).");
        String input = scanner.next();

        while(!((input.equalsIgnoreCase("y") ||
                (input.equalsIgnoreCase("n"))))) {

            System.out.println("Sorry, but that's not a valid input. Please enter \"Y\" for yes, or \"N\" for no.");
            input = scanner.next();
        }

        switch (input) {
            case "y":
            case "Y":
                return true;
            case "n":
            case "N":
            default:
                return false;
        }
    }

    public static boolean playerTurn(Scanner scanner, Player player, Die dieA, Die dieB) throws InterruptedException {

        boolean win = false;

        System.out.println("\nSelect a number between 2 and 6.");
        int input = scanner.nextInt();

        while(((input < 2) || (input > 6))) {
            System.out.println("\nSorry, that's not a valid response.");
            System.out.println("Please enter a number between 2 and 6.");
            input = scanner.nextInt();
        }

        System.out.println("\nRoll the dice!");
        String toss = scanner.nextLine();

        dieA.roll();
        int resultA = dieA.getRoll();

        dieB.roll();
        int resultB = dieB.getRoll();

        Thread.sleep(300);
        System.out.println("Die 1: " + resultA);
        System.out.println("Die 2: " + resultB);

        int resultTotal = resultA + resultB;

        if ((resultA == 1) || (resultB == 1)) {
           if ((resultA == 1) && (resultB == 1)) {
               System.out.println("\nOh no! Both dice landed on a 1, and that means you lost 25 points!");

               if (player.getScore() < 25) {
                   player.setScore(0);
               } else {
                   player.deductPoints(25);
               }

               System.out.println("Your score is now at " + player.getScore());
           } else {
               System.out.println("\nOh no! One of the dice landed on a 1, and that means you won't get any points for this round.");
           }

        } else if ((resultA == input) || (resultB == input)) {
            if ((resultA == input) && (resultB == input)) {
                System.out.println("Both dice landed on the number you chose at the beginning of your turn (" + input + ").");
                return true;
            }

            if (player.getScore() < 99) {
                System.out.println("\nOne of the dice landed on the number you chose at the beginning of your turn, and that means you get to roll again!");
                playerTurn(scanner, player, dieA, dieB);
            }

        }

        if ((resultA != 1) && (resultB != 1)) {
            System.out.println("\nYou earned a total of " + resultTotal + " points.");
            player.scorePoints(resultTotal);
        } else {
            System.out.println("\nYou earned a total of 0 points.");
        }

        System.out.println("Your score: " + player.getScore());

        if (player.getScore() < 99) {
            if (!win) {
                System.out.println("\nPress enter to end your turn.");
                toss = scanner.nextLine();
            }
        }

        return win;
    }

    public static boolean aiTurn(Scanner scanner, Player ai, Die dieA, Die dieB) throws InterruptedException {

        boolean win = false;

        int input = (int)(Math.random() * 6 + 1);
        System.out.println("\nSerena's number: " + input);

        dieA.roll();
        int resultA = dieA.getRoll();

        dieB.roll();
        int resultB = dieB.getRoll();

        Thread.sleep(300);
        System.out.println("Die 1: " + resultA);
        System.out.println("Die 2: " + resultB);

        int resultTotal = resultA + resultB;

        if ((resultA == 1) || (resultB == 1)) {
            if ((resultA == 1) && (resultB == 1)) {
                System.out.println("\nSerena lost 25 points!");

                if (ai.getScore() < 25) {
                    ai.setScore(0);
                } else {
                    ai.deductPoints(25);
                }

                System.out.println("Serena's score is now: " + ai.getScore());
            } else {
                System.out.println("\nSerena did not earn any points this round.");
            }

        } else if ((resultA == input) || (resultB == input)) {
            if ((resultA == input) && (resultB == input)) {
                System.out.println("\nOh no! Serena's dice both landed on the number she chose at the beginning of her turn(" + input + "). and she has won the game.");
                win = true;
            }

            if (ai.getScore() < 99) {
                System.out.println("\nOne of the dice landed on the number Serena chose at the beginning of her turn, and that means she get to roll again!");
                aiTurn(scanner, ai, dieA, dieB);
            }


        }
        if ((resultA != 1) || (resultB != 1)) {
            System.out.println("\nSerena earned a total of " + resultTotal + " points.");
            ai.scorePoints(resultTotal);
        } else {
            System.out.println("\nS erena earned a total of 0 points.");
        }

        System.out.println("Serena's score: " + ai.getScore());

        if (ai.getScore() < 99) {
            if (!win) {
                System.out.println("\nPress enter to start your turn.");
                String toss = scanner.nextLine();
            }
        }

        return win;
    }

    public static void resetScores(Player player, Player ai) {
        player.setScore(0);
        ai.setScore(0);
    }

    public static void main(String[] args) throws InterruptedException {

        Die dieA = new Die();
        Die dieB = new Die();

        Player player = new Player();
        Player ai = new Player();

        Scanner scanner = new Scanner(System.in);

        greeting();

        do {

            resetScores(player, ai);

            if (prompt(scanner)) {
                break;
            }

            while((player.getScore() < 99) || (ai.getScore() < 99)) {

                if (playerTurn(scanner, player, dieA, dieB)) {
                    win(player);
                    break;
                }

                if (player.getScore() >= 99) {
                    win(player);
                    break;
                }

                if (aiTurn(scanner, ai, dieA, dieB)) {
                    lose(player);
                    break;
                }

                if (ai.getScore() >= 99) {
                    lose(player);
                    break;
                }

            }

        } while (playAgain(scanner));
    }
}