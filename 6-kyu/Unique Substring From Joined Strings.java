/*
DESCRIPTION:
Write a function that takes two strings, A and B, and returns the length of the longest possible substring that can be formed from the concatenation of either A + B or B + A containing only characters that do not appear in both A and B.

Example:

Given the strings "piquancy" and "refocusing":
A = "piquancy"
B = "refocusing"
A + B = "piquancyrefocusing"
B + A = "refocusingpiquancy"

Since 'i', 'n', 'u', and 'c' appear in both A and B, all acceptable substrings without those characters are:
"p", "q", "a", "yrefo", "s", "g" (from A + B)
"refo", "s", "gp", "q", "a", "y" (from B + A)

Therefore, it would be correct to return 5: the length of "yrefo".
*/

public class FindSubstring {
  final static int ASCII_CHARS_START = 32;
  final static int ASCII_CHARS_END = 126;
  
  static int longestSubstring(String a, String b) {
    String delimiter = findDelimiter(a, b);
    
    String aUnique = replaceCharsFromFirstThatAreInSecond(a, b, delimiter);
    String bUnique = replaceCharsFromFirstThatAreInSecond(b, a, delimiter);
    
    int lengthAB = findLengthOfLongestSubstring(aUnique + bUnique, delimiter);
    int lengthBA = findLengthOfLongestSubstring(bUnique + aUnique, delimiter);
    
    return (int) Math.max(lengthAB, lengthBA);
  }
  
  public static String findDelimiter(String a, String b) {
    String delimiter = "";
    
    for (int i = ASCII_CHARS_START; i <= ASCII_CHARS_END; i++) {
      String sign = String.valueOf((char) i);
      if (!a.contains(sign) && !b.contains(sign) || 
          (a.contains(sign) && b.contains(sign))) {
        delimiter = sign;
        break;
      }
    }
    // delimiter can be:
    // - a character that neither a nor b contains
    // - a character that both a and b contain
    // if there's no character that both a and b contain - there's no need for delimiter
    
    return delimiter;
  }
  
  public static int findLengthOfLongestSubstring(String string, String delimiter) {
    String[] stringArr = string.split("");
    
    int longestLength = 0;
    int length = 0;
    
    for (int i = 0; i < stringArr.length; i++) {
      if (!stringArr[i].equals(delimiter)) {
        length++;
      } else {
        if (length > longestLength) 
          longestLength = length;
        length = 0;
      }
      
      if (length > longestLength) 
        longestLength = length;
    }

    return longestLength;
  }
  
  public static String replaceCharsFromFirstThatAreInSecond(String first, String second, String delimiter) {
    String[] firstArr = first.split("");
    
    for (int i = 0; i < firstArr.length; i++)
      if (second.contains(firstArr[i]))
        firstArr[i] = delimiter;
    
    return String.join("", firstArr);
  }
}