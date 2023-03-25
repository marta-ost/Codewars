/*
DESCRIPTION:
Write a function insert_dash(num) / insertDash(num) / InsertDash(int num) that will insert dashes ('-') between each two odd digits in num. For example: if num is 454793 the output should be 4547-9-3. Don't count zero as an odd digit.

Note that the number will always be non-negative (>= 0).
*/

public class Solution {
  public static String insertDash(int num) {
    String numStr = String.valueOf(num);
    
    StringBuilder numWithDashes = new StringBuilder();
    numWithDashes.append(numStr.charAt(0));
    
    for (int i = 1; i < numStr.length(); i++) {
      int currentDigit = Integer.parseInt(String.valueOf(numStr.charAt(i)));
      int previousDigit = Integer.parseInt(String.valueOf(numStr.charAt(i - 1)));
      
      if (currentDigit % 2 != 0 && previousDigit % 2 != 0)
        numWithDashes.append("-");
      numWithDashes.append(currentDigit);
    }
    
    return numWithDashes.toString();
  }
}