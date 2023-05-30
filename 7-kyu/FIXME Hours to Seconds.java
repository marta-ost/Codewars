/*
DESCRIPTION:
The code provided is meant to return how many seconds there are in a given number of hours.

But it's not working properly.

Task
Fix the bug so we can all go home early.

Notes
The hours passed will be in the range 0 - 1000000
*/

public class Dinglemouse {
  public static long hoursToSeconds(final int hours) {
    final long MINUTES_IN_HOUR = 60;
    final long SECONDS_IN_MINUTE = 60;
    return hours * MINUTES_IN_HOUR * SECONDS_IN_MINUTE;
  }
}