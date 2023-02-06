/*
DESCRIPTION:
Given a string made up of letters a, b, and/or c, switch the position of letters a and b (change a to b and vice versa). Leave any incidence of c untouched.

Example:

'acb' --> 'bca'
'aabacbaa' --> 'bbabcabb'
*/

public class Switch {
  public static String switcheroo(String x) {
    return x.replace("a", "t").replace("b", "a").replace("t", "b");
  }
}