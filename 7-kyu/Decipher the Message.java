/*
DESCRIPTION:
Amy and May aren't allowed by their parents to have cell phones, so they still communitcate in class the good old fashioned way, by writing notes.

So that no snoopy teachers can read any found notes, the girls communicate in code.

May is having a hard time deciphering Amy's latest messages, can you help her figure it out?

Input: String written in Amy's code 
Output: String decoded to English so May can read it
*/

public class NotePassing {  
  static final int LOWERCASE_LOWER_BOUND = 65;
  static final int LOWERCASE_UPPER_BOUND = 90;
  static final int UPPERCASE_LOWER_BOUND = 97;
  static final int UPPERCASE_UPPER_BOUND = 122;
  
  static final int CHANGE_VALUE = 19;
  
  public static String decipher(String codedMessage) {  
    StringBuilder decodedMessage = new StringBuilder();
    
    for (int i = 0; i < codedMessage.length(); i++) {
      int letterValue = codedMessage.charAt(i);
      
      if (letterValue >= LOWERCASE_LOWER_BOUND && letterValue <= LOWERCASE_UPPER_BOUND)
        letterValue = changeLetterValue(letterValue, LOWERCASE_LOWER_BOUND, LOWERCASE_UPPER_BOUND);
      else if (letterValue >= UPPERCASE_LOWER_BOUND && letterValue <= UPPERCASE_UPPER_BOUND)
        letterValue = changeLetterValue(letterValue, UPPERCASE_LOWER_BOUND, UPPERCASE_UPPER_BOUND);
      
      decodedMessage.append((char) letterValue);
    }
    
    return decodedMessage.toString();
  }
  
  public static int changeLetterValue(int letterValue, int lowerBound, int upperBound) {
    letterValue = letterValue - CHANGE_VALUE;
        
    if (letterValue < lowerBound) {
      int difference = lowerBound - letterValue - 1;
      letterValue = upperBound - difference;
    }
    
    return letterValue; 
  }
}