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

import java.util.Arrays;

public class Bud {
  public static String computerToPhone(String number){
    if (number.isEmpty())
      return "";
    
    int[] digits = Arrays.stream(number.split(""))
      .mapToInt(digit -> Integer.parseInt(digit))
      .toArray();
    
    StringBuilder converted = new StringBuilder();
    
    for (int i = 0; i < digits.length; i++) {
      if (digits[i] >= 7 && digits[i] <= 9)
        converted.append(digits[i] - 6);
      else if (digits[i] >= 1 && digits[i] <= 3)
        converted.append(digits[i] + 6);
      else 
        converted.append(digits[i]);
    }
    
    return converted.toString();
  }
}