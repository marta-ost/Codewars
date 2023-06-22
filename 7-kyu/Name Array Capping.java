/*
DESCRIPTION:
Create a method that accepts an array of names, and returns an array of each name with its first letter capitalized.

example

Kata.capMe(new String[] {"jo", "nelson", "jurie"}) // returns new String[] {"Jo", "Nelson", "Jurie"}
Kata.capMe(new String[] {"KARLY", "DANIEL", "KELSEY"}) // returns new String[] {"Karly", "Daniel", "Kelsey"}
*/

import java.util.Arrays;

public class Kata {
  public static String[] capMe(String[] strings) {
    return Arrays
      .stream(strings)
      .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase())
      .toArray(String[]::new);
  }
}