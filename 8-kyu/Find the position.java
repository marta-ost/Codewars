/*
DESCRIPTION:
When provided with a letter, return its position in the alphabet.

Input :: "a"

Ouput :: "Position of alphabet: 1"
*/

public class Kata {
  public static String position(char alphabet) {
    return Character.toUpperCase(alphabet) == alphabet 
      ? "Position of alphabet: " + String.valueOf((int) alphabet - 64)
      : "Position of alphabet: " + String.valueOf((int) alphabet - 96);
  }
}