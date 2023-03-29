/*
DESCRIPTION:
Description:
Given a string, you need to write a method that order every letter in this string in ascending order.

Also, you should validate that the given string is not empty or null. If so, the method should return:
"Invalid String!"

Notes
• the given string can be lowercase and uppercase.
• the string could include spaces or other special characters like '# ! or ,'. Sort them based on their ASCII codes

Examples
"hello world" => " dehllloorw"
"bobby"       => "bbboy"
""            => "Invalid String!"
"!Hi You!"    => " !!HYiou"

Good luck! Hope you enjoy it
*/

import java.util.stream.*;

public class Ordering {
  public String orderWord(String s) {
    return s == null || s.isEmpty() ? "Invalid String!" 
      : s.chars()
        .sorted()
        .mapToObj(i -> (char) i)
        .map(String::valueOf)
        .collect(Collectors.joining(""));
  }
}