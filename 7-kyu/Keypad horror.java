/*
DESCRIPTION:
Having two standards for a keypad layout is inconvenient!
Computer keypad's layout:
7 8 9  \n
4 5 6  \n
1 2 3  \n
  0 \n

Cell phone keypad's layout:
1 2 3\n 
4 5 6\n  
7 8 9\n  
  0\n

Solve the horror of unstandardized keypads by providing a function that converts computer input to a number as if it was typed on a phone.

Example:
"789" -> "123"

Notes:
You get a string with numbers only
*/

import java.util.stream.*;

public class Bud {
  public static String computerToPhone(String number){
    return number
      .chars()
      .mapToObj(c -> String.valueOf("0789456123".indexOf(c)))
      .collect(Collectors.joining());
  }
}