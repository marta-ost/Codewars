/*
DESCRIPTION:

Description:

Move all exclamation marks to the end of the sentence

Examples

"Hi!"          ---> "Hi!"
"Hi! Hi!"      ---> "Hi Hi!!"
"Hi! Hi! Hi!"  ---> "Hi Hi Hi!!!"
"Hi! !Hi Hi!"  ---> "Hi Hi Hi!!!"
"Hi! Hi!! Hi!" ---> "Hi Hi Hi!!!!"
*/

public class Kata {
  public static String remove(String s) {
    return s.replace("!", "") + s.replaceAll("[^!]", "");
  }
}