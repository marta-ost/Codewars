/*
DESCRIPTION:
No Story

No Description

Only by Thinking and Testing

Look at result of testcase, guess the code!
*/

import java.util.*;
import java.util.stream.*;

public class Kata {
  public static int[] testit(int[] a, int[] b){
    return IntStream
      .concat(Arrays.stream(a).distinct(), 
              Arrays.stream(b).distinct())
      .sorted()
      .toArray();
  }
}