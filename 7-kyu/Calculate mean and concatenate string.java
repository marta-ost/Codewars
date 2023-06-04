/*
DESCRIPTION:
You will be given an array which will include both integers and characters.

Return an array of length 2 with a[0] representing the mean of the ten integers as a floating point number. There will always be 10 integers and 10 characters. Create a single string with the characters and return it as a[1] while maintaining the original order.

lst = ['u', '6', 'd', '1', 'i', 'w', '6', 's', 't', '4', 'a', '6', 'g', '1', '2', 'w', '8', 'o', '2', '0']

Here is an example of your return

[3.6, "udiwstagwo"]

In C# and Java the mean return is a double.
*/

import java.util.Arrays;
import java.util.stream.*;

public class Kata {
  public static Object[] mean(char[] lst) {
    final double INTEGERS_COUNT = 10.0;
      
    int sum = getStream(lst)
      .filter(s -> s.matches("[0-9]"))
      .map(Integer::parseInt)
      .mapToInt(Integer::valueOf)
      .sum();
    
    String concatenated = getStream(lst)
      .filter(s -> s.matches("[A-Za-z]"))
      .collect(Collectors.joining(""));
    
    return new Object[]{sum / INTEGERS_COUNT, concatenated};
  }
  
  public static Stream<String> getStream(char[] lst) { 
    return IntStream
      .range(0, lst.length)
      .mapToObj(i -> lst[i])
      .map(String::valueOf);
  }
}