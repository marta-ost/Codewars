/*
DESCRIPTION:

Rock Paper Scissors

Let's play! You have to return which player won! In case of a draw return Draw!.

Examples(Input1, Input2 --> Output):

"scissors", "paper" --> "Player 1 won!"
"scissors", "rock" --> "Player 2 won!"
"paper", "paper" --> "Draw!"
*/

public class Kata {
  final static String SCISSORS = "scissors";
  final static String PAPER = "paper";
  final static String ROCK = "rock";
  
  public static String rps(String p1, String p2) {
    return p1.equals(p2) ? "Draw!"
      : p1.equals(SCISSORS) && p2.equals(PAPER) ||
        p1.equals(PAPER) && p2.equals(ROCK) ||
        p1.equals(ROCK) && p2.equals(SCISSORS) ? "Player 1 won!"
      : "Player 2 won!";
  }
}