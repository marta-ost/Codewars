/*
DESCRIPTION:
Given a string as input, return a new string with each letter pushed to the right by its respective index in the alphabet.

We all know that A is a slow and Z is a fast letter. This means that Z gets shifted to the right by 25 spaces, A doesn't get shifted at all, and B gets shifted by 1 space.

You can assume the following things about your input:

It will only contain uppercase letters from A to Z, no whitespaces or punctuation;
Input strings will not exceed 100 characters (although your output string might!)

Note that if 2 or more letters fall onto the same space after shifting, the latest character will be used. For example: "BA" -> " A"

Examples
"AZ"   -->  "A                         Z"
"ABC"  -->  "A B C"
"ACE"  -->  "A  C  E"
"CBA"  -->  "  A"
"HELLOWORLD"  -->  "     E H    DLL   OLO   R  W"
*/

public class Kata {
  public static String speedify(final String input) {
    int maxResultingLength = input.length() + 25;
    String[] speedified = new String[maxResultingLength];
    
    for (int letterIndex = 0; letterIndex < input.length(); letterIndex++) {
      char letter = input.charAt(letterIndex);
      int letterValue = (int) Character.toLowerCase(letter) - 97;
      int newIndex = letterValue + letterIndex;
      
      speedified[newIndex] = String.valueOf(letter);
    }
    
    for (int index = 0; index < speedified.length; index++) {
      if (speedified[index] == null)
        speedified[index]= " ";
    }
    
    return String.join("", speedified).stripTrailing();
  }
}