/*
DESCRIPTION:
It's your best friend's birthday! You already bought a box for the present. Now you want to pack the present in the box. You want to decorate the box with a ribbon and a bow.

But how much cm of ribbon do you need?

Write the method wrap that calculates that!

A box has a height, a width and a length (in cm). The ribbon is crossed on the side with the largest area. Opposite this side (also the side with the largest area) the loop is bound, calculate with 20 cm more tape.

  wrap(17,32,11) => 162
  wrap(13,13,13) => 124
  wrap(1,3,1) => 32

Notes:
height, width and length will always be >0

The ribbon and the bow on the present looks like this:
image
*/

public class WrapPresent {

	public static int wrap(int height, int width, int length) {
    int heightWidth = height * width;
    int widthLength = width * length;
    int lengthHeight = length * height;
    
    return heightWidth >= widthLength && heightWidth >= lengthHeight ? getRibbonLength(length, height, width) :
           widthLength >= heightWidth && widthLength >= lengthHeight ? getRibbonLength(height, length, width) :
           getRibbonLength(width, height, length);
  }
  
  private static int getRibbonLength(int height, int a, int b) {
    return 4 * height + 2 * (a + b) + 20;
  }
}