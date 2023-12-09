/*
DESCRIPTION:
You are developing an image hosting website.

You have to create a function for generating random and unique image filenames.

Create a function for generating a random 6 character string which will be used to access the photo URL.

To make sure the name is not already in use, you are given access to an PhotoManager object.

You can call it like so to make sure the name is unique

// at this point, the website has only one photo, hosted on the 'ABCDEF' url
photoManager.nameExists("ABCDEF"); // returns true
photoManager.nameExists("BBCDEF"); // returns false

Note: We consider two names with same letters but different cases to be unique.
*/

import java.util.*;

public class Solution {
  static final int ALPHABET_LENGTH = 26;
  static final int UPPERCASE_ALPHABET_ASCII_START = 65;
  static final int LOWERCASE_ALPHABET_ASCII_START = 97;
  static final Random random = new Random();
  
  public static String generateName(PhotoManager photoManager) {
    StringBuilder filename = new StringBuilder();
    
    for (int i = 0; i < 6; i++) {
      filename.append(
        random.nextInt(2) == 1 
        ? generateLetter(UPPERCASE_ALPHABET_ASCII_START)
        : generateLetter(LOWERCASE_ALPHABET_ASCII_START));
    }
    
    return photoManager.nameExists(filename.toString()) 
      ? generateName(photoManager) 
      : filename.toString();
  }
  
  private static String generateLetter(int asciiStart) {
    return String.valueOf((char) (random.nextInt(ALPHABET_LENGTH) + asciiStart));
  }
}