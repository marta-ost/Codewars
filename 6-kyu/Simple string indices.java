/*
DESCRIPTION:
In this Kata, you will be given a string with brackets and an index of an opening bracket and your task will be to return the index of the matching closing bracket. Both the input and returned index are 0-based except in Fortran where it is 1-based. An opening brace will always have a closing brace. Return -1 if there is no answer (in Haskell, return Nothing; in Fortran, return 0; in Go, return an error)

Examples
solve("((1)23(45))(aB)", 0) = 10 // the opening brace at index 0 matches the closing brace at index 10
solve("((1)23(45))(aB)", 1) = 3 
solve("((1)23(45))(aB)", 2) = -1 // there is no opening bracket at index 2, so return -1
solve("((1)23(45))(aB)", 6) = 9
solve("((1)23(45))(aB)", 11) = 14
solve("((>)|?(*'))(yZ)", 11) = 14

Input will consist of letters, numbers and special characters, but no spaces. The only brackets will be ( and ).

More examples in the test cases.

Good luck!
*/

public class Indice {
  public static int solve(String str, int index) {
    if (str.charAt(index) != '(')
      return -1;
    
    String[] elems = str.split("");
    int count = 0;
    int countBeforeIndex = -1;
    
    for (int i = 0; i < elems.length; i++) {
      if (i == index)
        countBeforeIndex = count;
      if (elems[i].equals("("))
        count++;
      if (elems[i].equals(")")) {
        count--;
        if (i != index && count == countBeforeIndex)
          return i;
      }
    }
    
    return -1;
  }
}