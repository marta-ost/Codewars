/*
DESCRIPTION:

Given time in seconds, return formatted string, as shown in following example:

Example:

Input: 90061 sec

Output: 1 1 1 1

e.g

90061 sec: 1 1 1 1 (1 day, 1 hour, 1 min and 1 seconds)
93784 sec: 1 2 3 4 (1 day, 2 hours, 3 mins, 4 seconds)

Useful conversions:

60 sec = 1 min
60 min = 1 hour
24 hour = 1 day

Please see included test case for an example.
*/

class TimeUtils {
  public static String convertTime(int timeDiff) {
    final int HOUR_IN_DAY = 24;
    final int MIN_IN_HOUR = 60;
    final int SEC_IN_MIN = 60; 
    final int SEC_IN_HOUR = SEC_IN_MIN * MIN_IN_HOUR;
    final int SEC_IN_DAY = SEC_IN_MIN * MIN_IN_HOUR * HOUR_IN_DAY;
    
    int days = timeDiff / SEC_IN_DAY;
    int hours = (timeDiff % SEC_IN_DAY) / SEC_IN_HOUR;
    int mins = ((timeDiff % SEC_IN_DAY) % SEC_IN_HOUR) / SEC_IN_MIN;
    int secs = ((timeDiff % SEC_IN_DAY) % SEC_IN_HOUR) % SEC_IN_MIN;
    
    return days + " " + hours + " " + mins + " " + secs;
  } 
}