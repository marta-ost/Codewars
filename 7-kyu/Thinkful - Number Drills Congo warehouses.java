/*
DESCRIPTION:
Your company, Congo Pizza, is the second-largest online frozen pizza retailer. You own a number of international warehouses that you use to store your frozen pizzas, and you need to figure out how many crates of pizzas you can store at each location.

Congo recently standardized its storage containers: all pizzas fit inside a cubic crate, 16-inches on a side. The crates are super tough so you can stack them as high as you want.

Write a function box_capacity() that figures out how many crates you can store in a given warehouse. The function should take three arguments: the length, width, and height of your warehouse (in feet) and should return an integer representing the number of boxes you can store in that space.

For example: a warehouse 32 feet long, 64 feet wide, and 16 feet high can hold 13,824 boxes because you can fit 24 boxes across, 48 boxes deep, and 12 boxes high, so box_capacity(32, 64, 16) should return 13824.
*/

import java.util.Arrays;

public class Kata {
  public static int boxCapacity(int l, int w, int h) {
    final int INCHES_IN_FEET = 12;
    final int CUBE_SIDE_IN_INCHES = 16;
    
    return Arrays
      .stream(new int[]{l, w, h})
      .map(i -> i * INCHES_IN_FEET / CUBE_SIDE_IN_INCHES)
      .reduce((i1, i2) -> i1 * i2)
      .getAsInt();
  }
}