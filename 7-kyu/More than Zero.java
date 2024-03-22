/*
DESCRIPTION:
Correct this code so that it takes one argument, x, and returns "x is more than zero" if x is positive (and nonzero), and otherwise, returns "x is equal to or less than zero." In both cases, replace x with the actual value of x.
*/

class MoreThanZero {
  public static String corrections(int x) {
    return x + (x > 0 ? " is more than zero." : " is equal to or less than zero.");
  }
}