/*
DESCRIPTION:
Everyone knows passphrases. One can choose passphrases from poems, songs, movies names and so on but frequently they can be guessed due to common cultural references. You can get your passphrases stronger by different means. One is the following:

choose a text in capital letters including or not digits and non alphabetic characters,

shift each letter by a given number but the transformed letter must be a letter (circular shift),
replace each digit by its complement to 9,
keep such as non alphabetic and non digit characters,
downcase each letter in odd position, upcase each letter in even position (the first character is in position 0),
reverse the whole result.

Example:
your text: "BORN IN 2015!", shift 1

1 + 2 + 3 -> "CPSO JO 7984!"

4 "CpSo jO 7984!"

5 "!4897 Oj oSpC"

With longer passphrases it's better to have a small and easy program. Would you write it?

https://en.wikipedia.org/wiki/Passphrase
*/

import java.util.*;
import java.util.stream.*;

public class PlayPass {
  private static final int LOWERCASE_ASCII_START = 96;
  private static final int LOWERCASE_ASCII_END = 122;
  private static final int UPPERCASE_ASCII_START = 64;
  private static final int UPPERCASE_ASCII_END = 90;
  
	public static String playPass(String string, int shift) {
    String[] replaced = Arrays
      .stream(string.split(""))
      .map(elem -> elem.matches("[a-zA-Z]") ? replaceLetter(elem, shift) 
                 : elem.matches("[0-9]") ? replaceDigit(elem)
                 : elem)
      .toArray(String[]::new);
    
    String cased = IntStream
      .range(0, replaced.length)
      .mapToObj(index -> index % 2 == 0 ? replaced[index].toUpperCase() 
                       : replaced[index].toLowerCase())
      .collect(Collectors.joining(""));
    
    StringBuilder reversed = new StringBuilder(cased);
    reversed.reverse();
    
    return reversed.toString();
	}
  
  private static String replaceLetter(String letter, int shift) {
    return letter.matches("[a-z]") ? 
      shiftLetter(letter, shift, LOWERCASE_ASCII_START, LOWERCASE_ASCII_END)
      : shiftLetter(letter, shift, UPPERCASE_ASCII_START, UPPERCASE_ASCII_END); 
  }
  
  private static String shiftLetter(String letter, int shift, int ASCII_START, int ASCII_END) {
    char letterChar = letter.charAt(0);
    int letterInt = (int) letterChar;
    
    if (letterInt + shift > ASCII_END) {
      int toEndPart = ASCII_END - letterInt;
      int fromStartPart = shift - toEndPart;
      letterInt = ASCII_START + fromStartPart;
    } else {
      letterInt += shift;
    }
    
    letterChar = (char) letterInt;
    
    return String.valueOf(letterChar);
  }
  
  private static String replaceDigit(String digitStr) {
    int digit = Integer.parseInt(digitStr);
    int shifted = 9 - digit;
    
    return String.valueOf(shifted);
  }
}