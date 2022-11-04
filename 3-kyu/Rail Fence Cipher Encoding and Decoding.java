/*
DESCRIPTION:
Create two functions to encode and then decode a string using the Rail Fence Cipher. This cipher is used to encode a string by placing each character successively in a diagonal along a set of "rails". First start off moving diagonally and down. When you reach the bottom, reverse direction and move diagonally and up until you reach the top rail. Continue until you reach the end of the string. Each "rail" is then read left to right to derive the encoded string.

For example, the string "WEAREDISCOVEREDFLEEATONCE" could be represented in a three rail system as follows:

W       E       C       R       L       T       E
  E   R   D   S   O   E   E   F   E   A   O   C  
    A       I       V       D       E       N    
The encoded string would be:

WECRLTEERDSOEEFEAOCAIVDEN
Write a function/method that takes 2 arguments, a string and the number of rails, and returns the ENCODED string.

Write a second function/method that takes 2 arguments, an encoded string and the number of rails, and returns the DECODED string.

For both encoding and decoding, assume number of rails >= 2 and that passing an empty string will return an empty string.

Note that the example above excludes the punctuation and spaces just for simplicity. There are, however, tests that include punctuation. Don't filter out punctuation as they are a part of the string.
*/

public class RailFenceCipher {
  
    static String decode(String s, int rails) {
      if (s.isEmpty()) {
        return s;
      }
      s = s.replace(" ", "0");
      String[][] a = new String[rails][2 * s.length() - 1];
      int initialLength = s.length();

      while (!s.isEmpty()) {
        for (int i = 0; i < rails; i++) {
          int j = i * 2; //spaces before the first letter in line
          int letterCount = 0;
          while (j < initialLength * 2) {
            if (s.isEmpty()) {
              break;
            }
            String currentLetter = String.valueOf(s.charAt(0));
            a[i][j] = currentLetter;

            if (i == 0) { //first line
              j = j + (rails - i - 1) * 4;
            } else if (i == rails - 1) { //last line
              j = j + i * 4;
            } else if (i < rails - 1 && letterCount % 2 == 0) { //middle lines - top triangle spaces
              j = j + (rails - i - 1) * 4;
            } else if (i < rails - 1 && letterCount % 2 != 0) { //middle lines - bottom triangle spaces
              j = j + i * 4;
            }
              s = s.substring(1); //remaining letters without the current letter
              letterCount++;
            }
          }
        }
        StringBuilder decoded = new StringBuilder();
        for (int k = 0; k < initialLength * 2 - 1; k++) {
          for (int l = 0; l < rails; l++) {
            if (a[l][k] != null) {
              decoded.append(a[l][k]);
            } else {
              a[l][k] = " ";
            }
          }
        }
        return decoded.toString().replace("0", " ");
    }
    
    static String encode(String s, int rails) {
      if (s.isEmpty()) {
        return s;
      }
      s = s.replace(" ", "0");
      String[][] a = new String[rails][2 * s.length() - 1];
      int j = 0;

      while (!s.isEmpty()) {
        for (int i = 0; i < rails; i++) {
          if (s.isEmpty()) {
            break;
          }
          String currentLetter = String.valueOf(s.charAt(0));
          a[i][j] = currentLetter;
          j += 2;
          s = s.substring(1); //remaining letters without the current letter
        }

        for (int i = rails - 2; i > 0; i--) {
          if (s.isEmpty()) {
            break;
          }
          String currentLetter = String.valueOf(s.charAt(0));
          a[i][j] = currentLetter;
          j += 2;
          s = s.substring(1); //remaining letters without the current letter
        }
      }
      StringBuilder encoded = new StringBuilder();
      for (int k = 0; k < a.length; k++) {
        for (int l = 0; l < a[0].length; l++) {
          if (a[k][l] == null) {
            a[k][l] = " ";
          } else {
            encoded.append(a[k][l]);
          }
        }
      }
      return encoded.toString().replace("0", " ");
    }
}