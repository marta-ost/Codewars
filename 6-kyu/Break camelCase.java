/*
DESCRIPTION:
Complete the solution so that the function will break up camel casing, using a space between words.

Example
"camelCasing"  =>  "camel Casing"
"identifier"   =>  "identifier"
""             =>  ""
*/

class Solution {
  public static String camelCase(String input) {
    StringBuilder broke = new StringBuilder();
    int previous = 0;
    
    for (int i = 0; i < input.length(); i++) {
      if (i - 1 >= 0 && String.valueOf(input.charAt(i)).matches("[A-Z]")) {
        broke.append(input.substring(previous, i)).append(" ");
        previous = i;
      }
    }
    broke.append(input.substring(previous));
    
    return broke.toString();
  }
}