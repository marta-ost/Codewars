/*
DESCRIPTION:
In one city, bus tickets use numbers from 100000 to 999999. Your task is to find the number of lucky tickets between two input tickets' values.

The ticket is considered to be lucky if the sum of first 3 digits equals to the sum of last 3 digits:
123321 is lucky, i.e. 1+2+3 equals to 3+2+1
123444 is not lucky, i.e. 1+2+3 doesn't equal to 4+4+4
*/

import java.util.*;
import java.util.stream.*;

public class LuckyTicket { 
  public int numberOfTickets(int from, int to) {
    return (int) IntStream
      .rangeClosed(from, to)
      .filter(i -> sumDigits(i, true) == sumDigits(i, false))
      .count();
  }
  
  private static int sumDigits(int number, boolean first) {
    String string = String.valueOf(number);
    String substring = first ? string.substring(0, 3) : string.substring(string.length() - 3);
    
    return Arrays
      .stream(substring.split(""))
      .map(Integer::parseInt)
      .mapToInt(Integer::intValue)
      .sum();
  }
}