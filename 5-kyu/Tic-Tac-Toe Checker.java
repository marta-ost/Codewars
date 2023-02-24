/*
DESCRIPTION:
If we were to set up a Tic-Tac-Toe game, we would want to know whether the board's current state is solved, wouldn't we? Our goal is to create a function that will check that for us!

Assume that the board comes in the form of a 3x3 array, where the value is 0 if a spot is empty, 1 if it is an "X", or 2 if it is an "O", like so:

[[0, 0, 1],
 [0, 1, 2],
 [2, 1, 0]]
We want our function to return:

-1 if the board is not yet finished AND no one has won yet (there are empty spots),
1 if "X" won,
2 if "O" won,
0 if it's a cat's game (i.e. a draw).
You may assume that the board passed in is valid in the context of a game of Tic-Tac-Toe.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
  public static int isSolved(int[][] board) {
    List<Integer> winningAndEmptyLines = getWinningAndEmptyLines(board);
    long numberOfWinners = getNumberOfWinners(winningAndEmptyLines);
    boolean gameFinished = checkIfGameIsFinished(board);
    
    return numberOfWinners == 2 || (numberOfWinners == 0 && gameFinished) ? 0 :
           numberOfWinners == 0 && !gameFinished ? -1 :
           Integer.valueOf(winningAndEmptyLines
                           .stream()
                           .distinct()
                           .filter(sign -> sign != 0)
                           .findFirst()
                           .get());
  }
  
  public static boolean checkIfGameIsFinished(int[][] board) {
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[i].length; j++)
        if (board[i][j] == 0)
          return false;
    
    return true;
  }
  
  public static long getNumberOfWinners(List<Integer> winningAndEmptyLines) {
    return winningAndEmptyLines
      .stream()
      .distinct()
      .filter(sign -> sign != 0)
      .count();
  }
  
  public static List<Integer> getWinningAndEmptyLines(int[][] board) {
    List<Integer> winningAndEmptyLines = new ArrayList<>();
    
    for (int i = 0; i < board.length; i++) {
      if (board[i][0] == board[i][1] && board[i][1] == board[i][2])
        winningAndEmptyLines.add(board[i][0]);
      if (board[0][i] == board[1][i] && board[1][i] == board[2][i])
        winningAndEmptyLines.add(board[0][i]);
    }
    
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
      winningAndEmptyLines.add(board[1][1]);
    if (board[2][0] == board[1][1] && board[1][1] == board[0][2])
      winningAndEmptyLines.add(board[1][1]);
    
    return winningAndEmptyLines;
  }
}