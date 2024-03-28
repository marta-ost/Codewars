/*
DESCRIPTION:

Description:

Remove n exclamation marks in the sentence from left to right. n is positive integer.

Examples

remove("Hi!",1) === "Hi"
remove("Hi!",100) === "Hi"
remove("Hi!!!",1) === "Hi!!"
remove("Hi!!!",100) === "Hi"
remove("!Hi",1) === "Hi"
remove("!Hi!",1) === "Hi!"
remove("!Hi!",100) === "Hi"
remove("!!!Hi !!hi!!! !hi",1) === "!!Hi !!hi!!! !hi"
remove("!!!Hi !!hi!!! !hi",3) === "Hi !!hi!!! !hi"
remove("!!!Hi !!hi!!! !hi",5) === "Hi hi!!! !hi"
remove("!!!Hi !!hi!!! !hi",100) === "Hi hi hi"
*/

public class Kata {
  public static String remove(String string, int n) {
    if (n == 0)
      return string;
    
    int firstOccurenceIndex = string.indexOf("!");
    if (firstOccurenceIndex == -1)
      return string;
    
    string = string.substring(0, firstOccurenceIndex) + string.substring(firstOccurenceIndex + 1);
    
    return remove(string, n - 1);
  }
}