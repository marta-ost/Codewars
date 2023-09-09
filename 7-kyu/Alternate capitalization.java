/*
DESCRIPTION:
Given a string, capitalize the letters that occupy even indexes and odd indexes separately, and return as shown below. Index 0 will be considered even.

For example, capitalize("abcdef") = ['AbCdEf', 'aBcDeF']. See test cases for more examples.

The input will be a lowercase string with no spaces.

Good luck!

If you like this Kata, please try:
Indexed capitalization
Even-odd disparity
*/

class Solution {
  public static String[] capitalize(String s) {
    s = s.toLowerCase(); 
    
    String lower = s;
    String upper = s;
    
    for (int i = 0; i < s.length(); i++)
      if (i % 2 == 0)
        upper = capitalizeLetterAtIndex(upper, i);
      else
        lower = capitalizeLetterAtIndex(lower, i);
    
    return new String[]{upper, lower};
  }
  
  public static String capitalizeLetterAtIndex(String s, int i) {
    return s.substring(0, i) + s.substring(i, i + 1).toUpperCase() + s.substring(i + 1);
  }
}