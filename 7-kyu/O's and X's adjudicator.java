/*
DESCRIPTION:
Write a method to determine the outcome of a game of O's and X's. https://en.wikipedia.org/wiki/Tic-tac-toe

The method public String judge(List<Integer> history) accepts a List of Integer objects representing the move history of both players in order as zero indexed offsets. The board squares are numbered with on offset as follows:

012
345
678

The X player makes the first move. The method should return a String, either "X_WIN", "O_WIN", or "NO_WINNER", to indicate the outcome of the game.

Input is guaranteed to represent a valid Os and Xs game.
*/

import java.util.*;
import java.util.stream.*;

public class OXAdjudicator {
  public String judge(List<Integer> history) {
    String xMoves = getPlayerMoves(history, true);
    String oMoves = getPlayerMoves(history, false);
    
    return checkIfPlayerWin(xMoves) && checkIfPlayerWin(oMoves) ? "DRAW" 
      : checkIfPlayerWin(xMoves) ? "X_WIN" 
      : checkIfPlayerWin(oMoves) ? "O_WIN"
      : "NO_WINNER";
  }
  
  private boolean checkIfPlayerWin(String moves) {  
    return checkMoves(moves, "[^[012]]") || checkMoves(moves, "[^[345]]") 
        || checkMoves(moves, "[^[678]]") || checkMoves(moves, "[^[036]]") 
        || checkMoves(moves, "[^[147]]") || checkMoves(moves, "[^[258]]") 
        || checkMoves(moves, "[^[048]]") || checkMoves(moves, "[^[246]]");
  } 
  
  private boolean checkMoves(String moves, String pattern) {
    return moves.replaceAll(pattern, "").length() == 3;
  }
  
  private String getPlayerMoves(List<Integer> history, boolean firstPlayer) {
    return IntStream
      .range(0, history.size())
      .filter(i -> firstPlayer ? i % 2 == 0 : i % 2 != 0)
      .mapToObj(i -> String.valueOf(history.get(i)))
      .collect(Collectors.joining(""));
  }
}