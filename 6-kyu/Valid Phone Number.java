/*
DESCRIPTION:
Write a function that accepts a string, and returns true if it is in the form of a phone number.
Assume that any integer from 0-9 in any of the spots will produce a valid phone number.

Only worry about the following format:
(123) 456-7890 (don't forget the space after the close parentheses)

Examples:

"(123) 456-7890"  => true
"(1111)555 2345"  => false
"(098) 123 4567"  => false
*/

public class Kata {
  public static boolean validPhoneNumber(String phoneNumber) {
    return 
      phoneNumber.length() == 14 &&
      phoneNumber.charAt(0) == '(' &&
      phoneNumber.substring(1, 4).matches("\\d+") &&
      phoneNumber.charAt(4) == ')' &&
      phoneNumber.charAt(5) == ' ' &&
      phoneNumber.substring(6, 9).matches("\\d+") &&
      phoneNumber.charAt(9) == '-' &&
      phoneNumber.substring(10).matches("\\d+");
  }
}