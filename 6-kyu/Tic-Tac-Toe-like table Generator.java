/*
DESCRIPTION:
Do you have in mind the good old TicTacToe?

Assuming that you get all the data in one array, you put a space around each value, | as a columns separator and multiple - as rows separator, with something like ["O", "X", " ", " ", "X", " ", "X", "O", " "] you should be returning this structure (inclusive of new lines):

 O | X |   
-----------
   | X |   
-----------
 X | O |   

Now, to spice up things a bit, we are going to expand our board well beyond a trivial 3 x 3 square and we will accept rectangles of big sizes, still all as a long linear array.

For example, for "O", "X", " ", " ", "X", " ", "X", "O", " ", "O"] (same as above, just one extra "O") and knowing that the length of each row is 5, you will be returning

 O | X |   |   | X 
-------------------
   | X | O |   | O 

And worry not about missing elements, as the array/list/vector length is always going to be a multiple of the width.
*/

public class Kata {
  static public String displayBoard(final char[] board, int width) {
    final String SPACE = " ";
    final String BAR = "|";
    final String NEW_LINE = "\n";
    final String DASH = "-";
    
    StringBuilder result = new StringBuilder();
    
    int elemIndex = 0;
    
    while (elemIndex < board.length) {
      for (int index = 0; index < width; index++) {
        result.append(SPACE).append(board[elemIndex]).append(SPACE);
        
        if (index != width - 1)
          result.append(BAR);
        else if (index == width - 1 && elemIndex != board.length - 1)
          result.append(NEW_LINE).append(DASH.repeat(width * 3 + (width - 1))).append(NEW_LINE);
        
        elemIndex++;
      }
    }
    
    return result.toString();
  }
}