/*
DESCRIPTION:
When provided with a String, capitalize all vowels

For example:

Input : "Hello World!"

Output : "HEllO WOrld!"

Note: Y is not a vowel in this kata.
*/

public class Kata {
  public static String swap(String st) {
    return st.replace("a", "A").replace("e", "E").replace("i", "I").replace("o", "O").replace("u", "U");
  }
}