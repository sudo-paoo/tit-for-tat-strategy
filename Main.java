import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TitForTat tft = new TitForTat();
        Friedman friedman = new Friedman();
        Randoomed rand = new Randoomed();
        Player player = new Player();

        // initialization
        char userMove;
        char compMove;

        // display rules
        displayRules();

        System.out.println("\n\n");

        System.out.println("------------------------");
        System.out.println("| Choose your opponent |");
        System.out.println("| [1] Tit-For-Tat      |");
        System.out.println("| [2] Friedman         |");
        System.out.println("| [3] Randoomed        |");
        System.out.println("------------------------");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        while (choice != 1 && choice != 2 && choice != 3) {
            System.out.print("Invalid input. Please enter 1 or 2: ");
            choice = sc.nextInt();
        }
        for (int round = 1; round <= 10; round++) {
            switch (choice) {
                case 1:
                    // Tit-For-Tat
                    System.out.println("\nRound " + round);
                    userMove = getUserMove(sc);

                    compMove = tft.makeMove();

                    displayMoves(compMove, userMove);
                    // update tft logic information
                    tft.updatePlayerLastMove(userMove);

                    // update scores of both players
                    tft.updateScore(compMove, userMove);
                    player.updateScore(userMove, compMove);
                    break;
                case 2:
                    // Friedman
                    System.out.println("\nRound " + round);
                    userMove = getUserMove(sc);

                    compMove = friedman.makeMove(round);

                    // display moves
                    displayMoves(compMove, userMove);

                    // update friedman logic information
                    friedman.updatePlayerLastMove(userMove);

                    // update scores of both players
                    friedman.updateScore(compMove, userMove);
                    player.updateScore(userMove, compMove);
                    break;
                case 3:
                    // randoomed
                    System.out.println("\nRound " + round);
                    userMove = getUserMove(sc);

                    compMove = rand.makeMove();

                    displayMoves(compMove, userMove);

                    // update scores of both players
                    rand.updateScore(compMove, userMove);
                    player.updateScore(userMove, compMove);
                    break;
                default:
                    System.out.println("Something went wrong. Try again");
            }
        }

        // Display scores at the end
        System.out.println("\nScores:");
        int playerScore = player.getScore();
        int computerScore = getOpponentScore(choice, tft, friedman, rand);
        System.out.println("-----------------------");
        System.out.println("| Computer Score: " + computerScore + " |");
        System.out.println("| Player Score: " + playerScore + "   |");
        System.out.println("-----------------------");
        if (computerScore > playerScore) {
            System.out.println("Computer Wins!!");
        } else if (playerScore > computerScore) {
            System.out.println("Player Wins!!");
        } else {
            System.out.println("Draw!!");
        }
        sc.close();
    }

    private static char getUserMove(Scanner sc) {
        System.out.print("Your move (C for Cooperate, D for Defect): ");
        char userMove = sc.next().toUpperCase().charAt(0);

        while (userMove != 'C' && userMove != 'D') {
            System.out.print("Invalid input. Please enter C or D: ");
            userMove = sc.next().toUpperCase().charAt(0);
        }
        return userMove;
    }

    private static void displayMoves(char compMove, char userMove) {
        System.out.println("----------------------");
        System.out.println("| Computer's move: " + compMove + " |");
        System.out.println("| Your move: " + userMove + "       |");
        System.out.println("----------------------");
    }

    private static int getOpponentScore(int choice, TitForTat tft, Friedman friedman, Randoomed rand) {
        if (choice == 1) {
            return tft.getScore();
        } else if (choice == 2) {
            return friedman.getScore();
        }
        return rand.getScore();
    }

    private static void displayRules() {
        System.out.println(
                "The Prisoner's Dilemma is a classic game theory scenario involving two players who can choose to cooperate or betray each other.");
        System.out.println("Here are the rules:");
        System.out.println("[1] This game consist of only 2 players.");
        System.out.println("[2] Each player has only 2 options: Cooperate or Defect.");
        System.out.println("[3] The pointing system for this game will be as follows:");
        System.out.println("    [3.1] If both players cooperate, they each get 3 points.");
        System.out.println("    [3.2] If both players defect, they each get 1 point.");
        System.out.println(
                "    [3.3] If one of the player cooperate, but the other defects, then the one who defected gets 5 points and the other gets nothing.");
        System.out.println("[4] The player with the highest total points at the end of 10 rounds wins.");
    }
}