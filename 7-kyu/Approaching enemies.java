/*
DESCRIPTION:
You are in a military mission in the middle of the jungle where your enemies are really hard to spot because of their camouflage. Luckily you have a device that shows the position of your enemies!

Your device is a radar that computes the x and y coordinates of an enemy in meters every 5 seconds. You are always at the point (0, 0) and your enemies are always heading towards you.

Your task
The radar will give you two consecutive points P1(x, y) and P2(x, y) of an enemy and you should write a function that will return the estimated time in seconds that the enemy will take to reach you, so you can defend! Python results should be rounded to 3 decimal places.

Hints
Distance between two points. Remember that you are working with only 2 dimensions!

Tests will have a precision of 3 decimal points. Good luck!
*/

public class Radar {
  public static double calculateTime(double[] p1, double[] p2) {
    final double[] P0 = {0, 0};
    final int SECONDS_BETWEEN_P1_AND_P2 = 5;
    
    double distanceBetweenP1andP2 = calculateDistance(p1, p2);
    double distanceBetweenP0andP2 = calculateDistance(P0, p2);
  
    return distanceBetweenP0andP2 / distanceBetweenP1andP2 * SECONDS_BETWEEN_P1_AND_P2;
  }
  
  private static double calculateDistance(double[] a, double[] b) {
    return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
  }
}