/*
DESCRIPTION:
No one enjoys carrying around spare change. And to avoid all that jingling it's absolutely necessary to have an efficient algorithm to calculate the minimum number of coins needed to pay for something. So given a set of coin denominations determine the fewest number of coins required to add up to a given amount.

For example: US Currency includes the penny, nickel, dime and quarter or the coins with denominations: [1, 5, 10, 25] If I were to ask you to make 75 cents you would return 3 since 75 cents can be made with 3 quarters.

NOTES:

The coin denominations will contain at least one coin and will be greater than zero. [3] or [1, 100, 19] are both valid.
All amounts given will be solvable.
Be greedy...
*/

import java.util.*;
import java.util.stream.*;

public class CoinFree {
	public static int solve(int amount, int[] coinsValues) {
    int count = 0;
    
    int[] coinsValuesDesc = Arrays
      .stream(coinsValues)
      .boxed()
      .sorted(Collections.reverseOrder())
      .mapToInt(Integer::intValue)
      .toArray();
    
    for (int coinValue : coinsValuesDesc) {
      int coinCount = amount / coinValue;
      count += coinCount;
      amount -= coinValue *  coinCount;
      if (amount == 0)
        break;
    }
    
    return count;
  }
}