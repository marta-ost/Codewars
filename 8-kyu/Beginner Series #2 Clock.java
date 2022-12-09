/*
DESCRIPTION:
Clock shows h hours, m minutes and s seconds after midnight.

Your task is to write a function which returns the time since midnight in milliseconds.

Example:
h = 0
m = 1
s = 1

result = 61000
Input constraints:

0 <= h <= 23
0 <= m <= 59
0 <= s <= 59
*/

public class Clock {
  public static int Past(int h, int m, int s) {
    final int MSECS_IN_SEC = 1000;
    final int SECS_IN_MIN = 60;
    final int MINS_IN_HOUR = 60;
    return MSECS_IN_SEC * (h * MINS_IN_HOUR * SECS_IN_MIN + m * SECS_IN_MIN + s);
  }
}