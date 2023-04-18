/*
DESCRIPTION:
In this kata you will be given a random string of letters and tasked with returning them as a string of comma-separated sequences sorted alphabetically, with each sequence starting with an uppercase character followed by n-1 lowercase characters, where n is the letter's alphabet position 1-26.

Example
alphaSeq("ZpglnRxqenU") -> "Eeeee,Ggggggg,Llllllllllll,Nnnnnnnnnnnnnn,Nnnnnnnnnnnnnn,Pppppppppppppppp,Qqqqqqqqqqqqqqqqq,Rrrrrrrrrrrrrrrrrr,Uuuuuuuuuuuuuuuuuuuuu,Xxxxxxxxxxxxxxxxxxxxxxxx,Zzzzzzzzzzzzzzzzzzzzzzzzzz"

Technical Details
The string will include only letters.
The first letter of each sequence is uppercase followed by n-1 lowercase.
Each sequence is separated with a comma.
Return value needs to be a string.
*/

import java.util.Arrays;
import java.util.stream.*;

public class Solution {
  public static String alphaSeq(String s) {
    return Arrays
      .stream(s.toLowerCase().split(""))
      .map(letter -> letter.repeat((int) letter.charAt(0) - 96))
      .map(string -> string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase())
      .sorted()
      .collect(Collectors.joining(","));
  }
}