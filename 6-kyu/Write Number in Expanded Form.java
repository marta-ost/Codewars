/*
DESCRIPTION:
Write Number in Expanded Form
You will be given a number and you will need to return it as a string in Expanded Form. For example:

Kata.expandedForm(12); # Should return "10 + 2"
Kata.expandedForm(42); # Should return "40 + 2"
Kata.expandedForm(70304); # Should return "70000 + 300 + 4"

NOTE: All numbers will be whole numbers greater than 0.

If you liked this kata, check out part 2!!
*/

public class Kata {
  public static String expandedForm(int num) {
    String numStr = String.valueOf(num);
    String[] elems = new String[numStr.replace("0", "").length()];
    int elemsIndex = 0;
    
    for (int i = 0; i < numStr.length(); i++)
      if (numStr.charAt(i) != '0')
        elems[elemsIndex++] = numStr.charAt(i) + "0".repeat(numStr.length() - 1 - i);
    
    return String.join(" + ", elems);    
  }
}