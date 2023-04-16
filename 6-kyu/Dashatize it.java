/*
DESCRIPTION:
Given a variable n,

If n is an integer, Return a string with dash'-'marks before and after each odd integer, but do not begin or end the string with a dash mark. If n is negative, then the negative sign should be removed.

If n is not an integer, return an empty value.

Ex:

dashatize(274) -> '2-7-4'
dashatize(6815) -> '68-1-5'
*/

public class Solution {
  public static String dashatize(int n) {
    String number = String.valueOf(n);
    number = number
      .replace("1", "-1-")
      .replace("3", "-3-")
      .replace("5", "-5-")
      .replace("7", "-7-")
      .replace("9", "-9-")
      .replace("--", "-");
    
    if (number.charAt(0) == '-')
      number = number.substring(1);
    if (number.charAt(number.length() - 1) == '-')
      number = number.substring(0, number.length() - 1);
    
    return number;
  }
}