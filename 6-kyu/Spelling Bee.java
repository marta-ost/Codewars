/*
DESCRIPTION:
How many bees are in the beehive?
bees can be facing UP, DOWN, LEFT, or RIGHT
bees can share parts of other bees
Examples
Ex1

bee.bee     
.e..e..
.b..eeb
Answer: 5

Ex2

bee.bee     
e.e.e.e
eeb.eeb
Answer: 8

Notes
The hive may be empty or null/None/nil/...
Python: the hive is passed as a list of lists (not a list of strings)
*/

public class Dinglemouse {
  public static int howManyBees(final char [][] hive) {
    if (hive == null)
      return 0;
    
    int count = 0;
    
    for (int i = 0; i < hive.length; i++) {
      for (int j = 2; j < hive[i].length; j++) {
        if ((hive[i][j - 2] == 'b' && hive[i][j - 1] == 'e' && hive[i][j] == 'e') ||
            (hive[i][j - 2] == 'e' && hive[i][j - 1] == 'e' && hive[i][j] == 'b'))
          count++;
      }
    }
    
    for (int i = 2; i < hive.length; i++) {
      for (int j = 0; j < hive[i].length; j++) {
        if ((hive[i - 2][j] == 'b' && hive[i - 1][j] == 'e' && hive[i][j] == 'e') ||
            (hive[i - 2][j] == 'e' && hive[i - 1][j] == 'e' && hive[i][j] == 'b'))
          count++;
      }
    }
    
    return count;
  }
}