/*
DESCRIPTION:
Given 2 strings, a and b, return a string of the form: shorter+reverse(longer)+shorter.

In other words, the shortest string has to be put as prefix and as suffix of the reverse of the longest.

Strings a and b may be empty, but not null (In C# strings may also be null. Treat them as if they are empty.).
If a and b have the same length treat a as the longer producing b+reverse(a)+b
*/

public class ReverseLonger {
  public static String shorterReverseLonger(String a, String b) {
    String longer = "";
    String shorter = "";
    
    if (a.length() >= b.length()) {
      longer = a;
      shorter = b;
    } else {
      longer = b;
      shorter = a;
    }
    
    String reversedLonger = new StringBuilder(longer).reverse().toString();
    
    StringBuilder result = new StringBuilder();
    result.append(shorter).append(reversedLonger).append(shorter);
    return result.toString();
  }
}