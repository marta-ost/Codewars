/*
DESCRIPTION:
Welcome. In this kata, you are asked to square every digit of a number and concatenate them.

For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1.

Note: The function accepts an integer and returns an integer
*/

import java.util.*;
import java.util.stream.*;

public class SquareDigit {

  public int squareDigits(int n) {
    return Integer.parseInt(String.valueOf(n)
          .chars()
          .map(d -> Integer.parseInt(String.valueOf((char) d)))
          .map(d -> d * d)
          .mapToObj(String::valueOf)
          .collect(Collectors.joining("")));
  }
}