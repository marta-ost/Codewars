/*
DESCRIPTION:
The main idea is to count all the occurring characters in a string. If you have a string like aba, then the result should be {'a': 2, 'b': 1}.

What if the string is empty? Then the result should be empty object literal, {}.
*/

import java.util.Map;
import java.util.stream.*;

public class Kata {
  public static Map<Character, Integer> count(String str) {
    return str
      .chars()
      .mapToObj(ch -> (char) ch)
      .collect(Collectors.groupingBy(Character::charValue,
                                Collectors.summingInt(x -> 1)));
  }
}