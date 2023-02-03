/*
DESCRIPTION:
Imagine a circle. To encode the word codewars, we could split the circle into 8 parts (as codewars has 8 letters):

Then add the letters in a clockwise direction:

Then remove the circle:

If we read the result from left to right, we get csordaew.

Decoding is the same process in reverse. If we decode csordaew, we get codewars.

Examples:
encode "codewars" -> "csordaew"
decode "csordaew" -> "codewars"
encode "white" -> "wehti"
decode "wehti" -> "white"
*/

public class Kata {
  public static String encode(String s) {
    StringBuilder encoded = new StringBuilder();
    for (int i = 0; i < s.length() / 2; i++) {
      encoded.append(s.charAt(i));
      encoded.append(s.charAt(s.length() - 1 - i));
    }
    if (s.length() % 2 == 1)
      encoded.append(s.charAt(s.length() / 2));
    return encoded.toString();
  }
  public static String decode(String s) {
    StringBuilder decoded = new StringBuilder();
    for (int i = 0; i < s.length(); i += 2)
      decoded.append(s.charAt(i));
    if (s.length() % 2 == 0) {
      for (int i = s.length() - 1; i >= 0; i -= 2)
        decoded.append(s.charAt(i));
    } else {
      for (int i = s.length() - 2; i >= 0; i -= 2)
        decoded.append(s.charAt(i));
    }
    return decoded.toString();
  }
}