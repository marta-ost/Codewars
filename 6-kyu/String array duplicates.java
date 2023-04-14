/*
DESCRIPTION:
In this Kata, you will be given an array of strings and your task is to remove all consecutive duplicate letters from each string in the array.

For example:

dup(["abracadabra","allottee","assessee"]) = ["abracadabra","alote","asese"].

dup(["kelless","keenness"]) = ["keles","kenes"].

Strings will be lowercase only, no spaces. See test cases for more examples.

Good luck!
*/

class Solution {    
  public static String[] dup(String[] arr) {
    String[] wordsWithoutDuplicates = new String[arr.length];
      
    for (int i = 0; i < arr.length; i++) {
      StringBuilder wordWithoutDuplicates = new StringBuilder();
      String wordWithDuplicates = arr[i];
      
      if (wordWithDuplicates.length() > 0) {
        char firstLetter = wordWithDuplicates.charAt(0);
        wordWithoutDuplicates.append(firstLetter);
      }
      
      for (int j = 1; j < wordWithDuplicates.length(); j++) {
        char currentLetter = wordWithDuplicates.charAt(j);
        char previousLetter = wordWithDuplicates.charAt(j - 1);
          
        if (currentLetter != previousLetter)
          wordWithoutDuplicates.append(currentLetter);
      }   
      
      wordsWithoutDuplicates[i] = wordWithoutDuplicates.toString();
    }
      
    return wordsWithoutDuplicates;
  }
}