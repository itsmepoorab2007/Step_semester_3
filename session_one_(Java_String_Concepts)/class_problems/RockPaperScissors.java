import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        playerMove = playerMove.trim().toLowerCase();
        computerMove = computerMove.toLowerCase();

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
            (playerMove.equals("paper") && computerMove.equals("rock")) ||
            (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0, losses = 0, draws = 0;
        int totalRounds = 5;

        System.out.println("=== Rock-Paper-Scissors Arcade ===");
        for (int i = 1; i <= totalRounds; i++) {
            System.out.print("\nRound " + i + " - Enter your move (Rock, Paper, Scissors): ");
            String playerMove = scanner.nextLine();

            String computerMove = moves[random.nextInt(moves.length)];
            System.out.println("Computer chose: " + computerMove);

            String result = playRound(playerMove, computerMove);
            System.out.println("Result: " + result);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        double winPercentage = ((double) wins / totalRounds) * 100;
        System.out.println("\nFinal Summary (after " + totalRounds + " rounds)");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");
        
        scanner.close();
    }
}
