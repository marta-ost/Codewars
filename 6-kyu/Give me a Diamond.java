/*
DESCRIPTION:
Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a diamond string from James. Since James doesn't know how to make this happen, he needs your help.

Task
You need to return a string that looks like a diamond shape when printed on the screen, using asterisk (*) characters. Trailing spaces should be removed, and every line must be terminated with a newline character (\n).

Return null/nil/None/... if the input is an even number or negative, as it is not possible to print a diamond of even or negative size.

Examples
A size 3 diamond:

 *
***
 *
...which would appear as a string of " *\n***\n *\n"

A size 5 diamond:

  *
 ***
*****
 ***
  *
...that is:

"  *\n ***\n*****\n ***\n  *\n"
*/

class Diamond {
  public static String print(int n) {
    if (n <= 0 || n % 2 == 0) 
      return null;
      
    StringBuilder diamond = new StringBuilder();
    int stars = 1;
    int spaces = n / 2;
    
    for (int i = 0; i <= n / 2; i++) {
      if (spaces > 0)
        diamond.append(" ".repeat(spaces));   
      diamond.append("*".repeat(stars)).append("\n");
      if (i < n / 2) {
        stars += 2;
        spaces--;
      }
    }
    
    for (int i = n / 2 + 1; i < n; i++) {
      stars -= 2;
      spaces++;
      if (spaces > 0)
        diamond.append(" ".repeat(spaces));
      diamond.append("*".repeat(stars)).append("\n");
    }
    return diamond.toString();
	}
}