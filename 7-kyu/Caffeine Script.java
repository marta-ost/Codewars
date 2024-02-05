/*
DESCRIPTION:

Complete the function which takes a non-zero integer as its argument.

If the integer is divisible by 3, return the string "Java".

If the integer is divisible by 3 and divisible by 4, return the string "Coffee"

If one of the condition above is true and the integer is even, add "Script" to the end of the string.

If none of the condition is true, return the string "mocha_missing!"

Examples

1   -->  "mocha_missing!"
3   -->  "Java"
6   -->  "JavaScript"
12  -->  "CoffeeScript"
*/

public class CaffeineBuzz {
  public static String caffeineBuzz(int n) {
    boolean isDivisibleBy3 = isFirstDivisibleBySecond(n, 3);
    boolean isDivisibleBy4 = isFirstDivisibleBySecond(n, 4);
    boolean isEven = isFirstDivisibleBySecond(n, 2);
    
    return isDivisibleBy3 
      ? ((isDivisibleBy4 ? "Coffee" : "Java") + (isEven ? "Script" : "")) 
      : "mocha_missing!";
  }
  
  private static boolean isFirstDivisibleBySecond(int first, int second) {
    return first % second == 0;
  }
}