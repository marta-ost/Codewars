/*
DESCRIPTION:
Given a string made of digits [0-9], return a string where each digit is repeated a number of times equals to its value.

Examples
explode("312")
should return :
"333122"

explode("102269")
should return :
"12222666666999999999"
*/

import java.util.Arrays;
import java.util.stream.*;

public class Solution {
  public static String explode(String digits) {
    return Arrays.stream(digits.split(""))
      .map(digit -> digit.repeat(Integer.parseInt(digit)))
      .collect(Collectors.joining());
  }
}