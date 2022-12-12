/*
DESCRIPTION:
The cockroach is one of the fastest insects. Write a function which takes its speed in km per hour and returns it in cm per second, rounded down to the integer (= floored).

For example:

1.08 --> 30
Note! The input is a Real number (actual type is language dependent) and is >= 0. The result should be an Integer.
*/

public class Cockroach {
  public int cockroachSpeed(double x) {
    final int SEC_IN_MIN = 60;
    final int MIN_IN_H = 60;
    final int CM_IN_M = 100;
    final int M_IN_KM = 1000;
    
    return (int) Math.floor(x * (CM_IN_M * M_IN_KM) / (SEC_IN_MIN * MIN_IN_H));
  }
}