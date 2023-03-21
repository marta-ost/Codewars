/*
DESCRIPTION:
Filter the number
Oh, no! The number has been mixed up with the text. Your goal is to retrieve the number from the text, can you return the number back to its original state?

Task
Your task is to return a number from a string.

Details
You will be given a string of numbers and letters mixed up, you have to return all the numbers in that string in the order they occur.
*/

import java.util.stream.*;
import java.util.Arrays;

public class Kata {
  public static long filterString(final String value) {
    return Long.parseLong(Arrays.stream(value.split(""))
      .filter(i -> i.matches("[0-9]"))
      .collect(Collectors.joining("")));
  }
}