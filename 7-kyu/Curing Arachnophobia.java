/*
DESCRIPTION:

There is no single treatment that works for every phobia, but some people cure it by being gradually exposed to the phobic situation or object. In this kata we will try curing arachnophobia by drawing primitive spiders.

Our spiders will have legs, body, eyes and a mouth. Here are some examples:

/\((OOwOO))/\

/╲(((0000w0000)))╱\

^(oWo)^

You will be given four values:

leg size where each value stands for its own leg type: 1 for "^ ^", 2 for "/\ /\", 3 for "/╲ ╱\", 4 for "╱╲ ╱╲"
body size where each value stands for its own body type: 1 for "( )", 2 for "(( ))", 3 for "((( )))"
mouth representing the spider's mouth
eye representing the spider's eye

Note: the eyes are symmetric, and their total amount is 2 to the power of body size.

You will also be given only valid data. That's it for the instructions, you can start coding!
*/

import java.util.*;

public class Spiders {
  static Map<Integer, String> legs = Map.of(
    1, "^",
    2, "/\\",
    3, "/╲",
    4, "╱╲",
    5, "^",
    6, "/\\",
    7, "╱\\",
    8, "╱╲"
  );
  
  static Map<Integer, String> bodies = Map.of(
    1, "(",
    2, "((",
    3, "(((",
    4, ")",
    5, "))",
    6, ")))"
  );
  
  public static String drawSpider(int legSize, int bodySize, char mouth, char eye) {
    StringBuilder spider = new StringBuilder();
    String eyes = String.valueOf(eye).repeat((int) (Math.pow(2, bodySize) / 2));
    spider
      .append(legs.get(legSize))
      .append(bodies.get(bodySize))
      .append(eyes)
      .append(mouth)
      .append(eyes)
      .append(bodies.get(bodySize + 3))
      .append(legs.get(legSize + 4));
    return spider.toString();
  }
}