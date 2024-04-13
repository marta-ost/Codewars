/*
DESCRIPTION:

Rock Paper Scissors

Let's play! You have to return which player won! In case of a draw return Draw!.

Examples(Input1, Input2 --> Output):

"scissors", "paper" --> "Player 1 won!"
"scissors", "rock" --> "Player 2 won!"
"paper", "paper" --> "Draw!"
*/

import java.util.*;

public class Kata {
  final static String SCISSORS = "scissors";
  final static String PAPER = "paper";
  final static String ROCK = "rock";
  final static List<String> wins = List.of(SCISSORS + PAPER, PAPER + ROCK, ROCK + SCISSORS);
  
  public static String rps(String p1, String p2) {  
    return p1.equals(p2) ? "Draw!"
      : wins.contains(p1 + p2) ? "Player 1 won!"
      : "Player 2 won!";
  }
}