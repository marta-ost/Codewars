/*
DESCRIPTION:
Two players draw a pair of numbered cards so that both players can form a 2 digit number. A winner can be decided if one player's number is larger than the other.

However, there is a rule where a player can swap any one of their cards with any one of the other player's cards in a gamble to get a higher number! Note that it is illegal to swap the order of your own cards. That means if you draw a 1 then a 9, you cannot swap them to get 91.

Paul's strategy is to always swap his lowest number with the opponent's ten's digit. Return whether this results in Paul winning the round.

n1 is Paul's number
n2 is his opponent's number

Worked Example

(41, 79) ➞ true
# Paul's lowest number is 1
# The opponent's ten's digit is 7
# After the swap: 47 > 19
# Paul wins the round

Examples
(41, 98) ➞ true
(12, 28) ➞ true
(67, 53) ➞ false
(77, 54) ➞ false

Notes
If both of Paul's digits are the same, swap the ten's digit with the opponent's (paul likes to live riskily).
The cards don't include the number 0.
11 <= All numbers <= 99 (excluding numbers containing 0)
*/

import java.util.stream.*;
import java.util.*;

public class Solution {
  public static boolean swapCards(int n1, int n2) {
    int[] n1Digits = getDigits(n1);
    int[] n2Digits = getDigits(n2);
    
    int n1SwapIndex = findSwapIndex(n1Digits);
    int n2SwapIndex = 0;
    
    int temp = n2Digits[n2SwapIndex];
    n2Digits[n2SwapIndex] = n1Digits[n1SwapIndex];
    n1Digits[n1SwapIndex] = temp;
    
    return joinDigits(n1Digits) > joinDigits(n2Digits);
  }
  
  private static int[] getDigits(int number) {
    return Arrays
      .stream(String.valueOf(number).split(""))
      .mapToInt(Integer::parseInt)
      .toArray();
  }
  
  private static int findSwapIndex(int[] digits) {
    return digits[0] == digits[1] ? 0 :
      IntStream
      .range(0, digits.length)
      .filter(i -> digits[i] == Math.min(digits[0], digits[1]))
      .findFirst()
      .getAsInt();
  }
  
  private static int joinDigits(int[] array) {
    return Integer.parseInt(Arrays
      .stream(array)
      .mapToObj(String::valueOf)
      .collect(Collectors.joining("")));
  }
}