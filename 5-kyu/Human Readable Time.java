/*
DESCRIPTION:
Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)

HH = hours, padded to 2 digits, range: 00 - 99
MM = minutes, padded to 2 digits, range: 00 - 59
SS = seconds, padded to 2 digits, range: 00 - 59
The maximum time never exceeds 359999 (99:59:59)

You can find some examples in the test fixtures.
*/

import java.text.DecimalFormat;

public class HumanReadableTime {
  public static String makeReadable(int seconds) {
    final int SECS_IN_MIN = 60;
    final int MINS_IN_HOUR = 60;
    
    int timeInMins = seconds / SECS_IN_MIN;
    
    int secs = seconds % SECS_IN_MIN;
    int mins = timeInMins % MINS_IN_HOUR;
    int hours = timeInMins / MINS_IN_HOUR;
    
    DecimalFormat watchFormat = new DecimalFormat("00");
    StringBuilder madeReadable = new StringBuilder();
    
    madeReadable.append(watchFormat.format(hours)).append(":")
      .append(watchFormat.format(mins)).append(":")
      .append(watchFormat.format(secs));
  
    return madeReadable.toString();
  }
}