/*
DESCRIPTION:
Oh no! Timmy hasn't followed instructions very carefully and forgot how to use the new String Template feature, Help Timmy with his string template so it works as he expects!
*/

public class Kata {
  public static String buildString(String... args) {
    StringBuilder string = new StringBuilder();
    
    string.append("I like ");
    for (int i = 0; i < args.length; i++) {
      if (i == args.length - 1) {
        string.append(args[i]);
      } else {
        string.append(args[i]).append(", ");
      }
    }
    string.append("!");
    return string.toString();
  }
}