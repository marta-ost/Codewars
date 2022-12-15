/*
DESCRIPTION:
Write a simple regex to validate a username. Allowed characters are:

lowercase letters,
numbers,
underscore
Length should be between 4 and 16 characters (both included).
*/

public class ZywOo {
  public static boolean validateUsr(String s) {
    return s.matches("[a-z0-9_]+") 
      && s.length() >= 4 
      && s.length() <= 16;
  }
}