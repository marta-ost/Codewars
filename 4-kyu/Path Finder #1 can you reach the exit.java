/*
DESCRIPTION:
Task
You are at position [0, 0] in maze NxN and you can only move in one of the four cardinal directions (i.e. North, East, South, West). Return true if you can reach position [N-1, N-1] or false otherwise.

Empty positions are marked ..
Walls are marked W.
Start and exit positions are empty in all test cases.
Path Finder Series:
#1: can you reach the exit?
#2: shortest path
#3: the Alpinist
#4: where are you?
#5: there's someone here
*/

public class Finder {
  
    private static final char OPEN = '.';
    private static final char TRIED = 'T';
    private static final char PATH = 'P';
    
    static boolean pathFinder(String maze) {
      char[][] m = convertTo2dArray(maze);
      return traverse(0, 0, m);
    }

    static boolean traverse(int i, int j, char[][] m) {
      boolean solved = false;
      if (isValidPosition(i, j, m)) {
        m[i][j] = TRIED;
        if (i == m.length - 1 && j == m[0].length - 1) {
          solved = true;
        } else {
          if (!solved) {
            solved = traverse(i - 1, j, m); //go up
          }
          if (!solved) {
            solved = traverse(i, j - 1, m); //go left
          }
          if (!solved) {
            solved = traverse(i + 1, j, m); //go down
          }
          if (!solved) {
            solved = traverse(i, j + 1, m); //go right
          }
        }
        if (solved) {
          m[i][j] = PATH;
        }
      }
      return solved;
    }

    static boolean isValidPosition(int i, int j, char[][] m) {
      return i >= 0 && i < m.length && j >= 0 && j < m[i].length && m[i][j] == OPEN;
    }

    static char[][] convertTo2dArray(String string) {
      String[] a = string.split("\n");
      char[][] a2d = new char[a.length][a[0].length()];

      for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[0].length(); j++) {
          a2d[i][j] = a[i].charAt(j);
        }
      }
      return a2d;
    }
}