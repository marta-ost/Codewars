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
    String number = Integer.toString(n);
    String[] digits = number.split("");
    
    List<Integer> squares = Arrays.stream(digits)
      .map(d -> (int) Math.pow(Integer.parseInt(d), 2))
      .collect(Collectors.toList());
    
    StringBuilder squared = new StringBuilder();
    for (Integer square : squares) {
      squared.append(square);
    }
    return Integer.parseInt(squared.toString());
  }
}