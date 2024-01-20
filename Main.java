import java.util.Scanner;

public class Main {
    public static void rules() {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TitForTat tftPlayer = new TitForTat();
        Player player = new Player();
        rules();
        for (int i = 1; i <= 10; i++) {
            System.out.println("\nRound " + i);
            System.out.print("Your move (C for Cooperate, D for Defect): ");
            char userMove = sc.next().charAt(0);
            userMove = Character.toUpperCase(userMove);

            // input validator
            while (userMove != 'C' && userMove != 'D') {
                System.out.print("Invalid input. Please enter C or D: ");
                userMove = sc.next().charAt(0);
            }

            // computer move
            char compMove = tftPlayer.tftMove();

            // display player moves
            System.out.println("----------------------");
            System.out.println("| Computer's move: " + compMove + " |");
            System.out.println("| Your move: " + userMove + "       |");
            System.out.println("----------------------");

            // update info on tit-for-tat
            tftPlayer.updatePlayerLastMove(userMove);

            // update score for both players
            tftPlayer.updateScore(compMove, userMove);
            player.updateScore(userMove, compMove);
        }
        // show their scores at the end
        System.out.println("Computer Score: " + tftPlayer.getScore());
        System.out.println("Player Score: " + player.getScore());
        sc.close();
    }
}