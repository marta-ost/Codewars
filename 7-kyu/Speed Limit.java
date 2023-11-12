/*
DESCRIPTION:
The police have placed radars that will detect those vehicles that exceed the speed limit on that road. If the driver's speed is 10km/h to 19km/h above the speed limit, the fine will be 100 dollars, if it is exceeded by 20km/h to 29km/h the fine will be 250 dollars and if it is exceeded by more than 30km/h the fine will be 500 dollars.

You will be provided with the speed limits of those roads with radar as a collection of speedlimits [90,100,110,120,....] and the speed of the driver will be the same on all roads and can never be negative and the amount of the fine will be accumulated example 95km/h.

Example (Speed=100, Signals=[110,100,80]-> 250)
*/

import java.util.*;

public class Kata {
  public static int speedLimit(final int speed, final int[] signals) {
    return Arrays
      .stream(signals)
      .map(speedlimit -> speed - speedlimit)
      .map(difference -> difference >= 30 ? 500 
          : difference >= 20 && difference <= 29 ? 250
          : difference >= 10 && difference <= 19 ? 100
          : 0)
      .sum();
  }
}