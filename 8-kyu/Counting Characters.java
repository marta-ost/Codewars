/*
DESCRIPTION:
Define a method named countCharOccurrences that accepts a string and a char as inputs and returns the number of times the char occurs in the string as an int.
*/

interface Count {
  static int countCharOccurrences(String s, char c) {
    return (int) s.chars().filter(letter -> letter == c).count();
  }
}