/*
DESCRIPTION:

This Kata is intended as a small challenge for my students

All Star Code Challenge #22

Create a function that takes an integer argument of seconds and converts the value into a string describing how many hours and minutes comprise that many seconds.

Any remaining seconds left over are ignored.

Note:
The string output needs to be in the specific form - "X hour(s) and X minute(s)"

For example:

3600 --> "1 hour(s) and 0 minute(s)"
3601 --> "1 hour(s) and 0 minute(s)"
3500 --> "0 hour(s) and 58 minute(s)"
323500 --> "89 hour(s) and 51 minute(s)"
*/

public class timeConverter {
  static final int SEC_IN_MIN = 60;
  static final int MIN_IN_HOUR = 60;
  
  public static String toTime(int seconds) {
    int hours = seconds / (SEC_IN_MIN * MIN_IN_HOUR);
    int minutes = seconds % (SEC_IN_MIN * MIN_IN_HOUR) / SEC_IN_MIN;
    
    return String.format("%d hour(s) and %d minute(s)", hours, minutes);
  }
}