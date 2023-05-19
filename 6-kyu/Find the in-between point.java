/*
DESCRIPTION:
For this kata, you are given three points (x1,y1,z1), (x2,y2,z2), and (x3,y3,z3) that lie on a straight line in 3-dimensional space. You have to figure out which point lies in between the other two.

Your function should return 1, 2, or 3 to indicate which point is the in-between one.
*/

public class Points_On_A_Line {
 public static int middle_point(double x1, double y1, double z1,
                                double x2, double y2, double z2,
                                double x3, double y3, double z3) {
   return checkIfLastIsInTheMiddle(x1, y1, z1, x2, y2, z2, x3, y3, z3) ? 3 
        : checkIfLastIsInTheMiddle(x1, y1, z1, x3, y3, z3, x2, y2, z2) ? 2 
        : 1;
 }
  
  public static boolean checkIfLastIsInTheMiddle (double x1, double y1, double z1,
                                                  double x2, double y2, double z2,
                                                  double x3, double y3, double z3) {
    return ((x3 >= x1 && x3 <= x2) || (x3 >= x2 && x3 <= x1)) &&
           ((y3 >= y1 && y3 <= y2) || (y3 >= y2 && y3 <= y1)) &&
           ((z3 >= z1 && z3 <= z2) || (z3 >= z2 && z3 <= z1));
  }
}