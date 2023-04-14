/*
DESCRIPTION:
Find the number with the most digits.

If two numbers in the argument array have the same number of digits, return the first one in the array.
*/

public class MostDigits {
  public static int findLongest(int[] numbers) {
    int longestNumber = 0;
    
    for (int i = 0; i < numbers.length; i++) {
      int currentLength = findNumberLength(numbers[i]);
      int longestLength = findNumberLength(longestNumber);
      
      if (currentLength > longestLength)
        longestNumber = numbers[i];
    }

    return longestNumber;
  }
  
  public static int findNumberLength(int number) {
    return number >= 0 ? String.valueOf(number).length() 
        : String.valueOf(number).length() - 1;
  }
}