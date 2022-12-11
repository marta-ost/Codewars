/*
DESCRIPTION:
Your task is to find the nearest square number, nearest_sq(n), of a positive integer n.

Goodluck :)

Check my other katas:

Alphabetically ordered

Case-sensitive!

Not prime numbers
*/

public class CodeWarsMath {
  public static int nearestSq(final int n){
    return findNearest(n, 0);
  }
  
  private static int findNearest(int n, int previousSq) {
    for (int i = 1; i <= n; i++) {
      int currentSq = (int) Math.pow(i, 2);
      if (Math.abs(currentSq - n) < Math.abs(previousSq - n)) {
        previousSq = currentSq;
      } else {
        return previousSq;
      }
    }
    return previousSq;
  }
}