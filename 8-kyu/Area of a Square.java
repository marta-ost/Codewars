/*
DESCRIPTION:
Complete the function that calculates the area of the red square, when the length of the circular arc A is given as the input. Return the result rounded to two decimals.

Graph

Note: use the π value provided in your language (Math::PI, M_PI, math.pi, etc)
*/

import java.text.DecimalFormat;

public class Geometry {
  public static double squareArea(double arcLength) {
    double r = 2 * arcLength / Math.PI;
    double area = r * r;
    DecimalFormat df = new DecimalFormat("##.00");
    return Double.parseDouble(df.format(area));
  }
}