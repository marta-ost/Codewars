/*
DESCRIPTION:
An isogram is a word that has no repeating letters, consecutive or non-consecutive. Implement a function that determines whether a string that contains only letters is an isogram. Assume the empty string is an isogram. Ignore letter case.

Example: (Input --> Output)

"Dermatoglyphics" --> true "aba" --> false "moOse" --> false (ignore letter case)

isIsogram "Dermatoglyphics" = true
isIsogram "moose" = false
isIsogram "aba" = false
*/

public class isogram {
  public static boolean isIsogram(String str) {
    char[] letters = str.toLowerCase().toCharArray();
    for (int i = 0; i < letters.length; i++) {
      for (int j = 0; j < letters.length; j++) {
        if (i != j && letters[j] == letters[i]) {
          return false;
        }
      }
    }
    return true;
  } 
}