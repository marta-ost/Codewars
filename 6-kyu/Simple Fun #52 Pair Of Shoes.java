/*
DESCRIPTION:
Task
Yesterday you found some shoes in your room. Each shoe is described by two values:

type indicates if it's a left or a right shoe;
size is the size of the shoe.
Your task is to check whether it is possible to pair the shoes you found in such a way that each pair consists of a right and a left shoe of an equal size.

Example
For:

shoes = [[0, 21], 
         [1, 23], 
         [1, 21], 
         [0, 23]]
the output should be true;

For:

shoes = [[0, 21], 
         [1, 23], 
         [1, 21], 
         [1, 23]]
the output should be false.

Input/Output
[input] 2D integer array shoes
Array of shoes. Each shoe is given in the format [type, size], where type is either 0 or 1 for left and right respectively, and size is a positive integer.

Constraints: 2 ≤ shoes.length ≤ 50,  1 ≤ shoes[i][1] ≤ 100.

[output] a boolean value

true if it is possible to pair the shoes, false otherwise.
*/

import java.util.ArrayList;
import java.util.Arrays;

enum Foot {LEFT, RIGHT};
record Shoe(Foot foot, int size) { }

class Solution {
  public static boolean pairOfShoes(Shoe[] shoes) {
    ArrayList<Shoe> shoesList = new ArrayList(Arrays.asList(shoes));
    
    for (int size = 1; size <= 50; size++) {
      Shoe leftShoe = new Shoe(Foot.LEFT, size);
      Shoe rightShoe = new Shoe(Foot.RIGHT, size);
      
      while (shoesList.contains(leftShoe) && shoesList.contains(rightShoe)) {
        shoesList.remove(leftShoe);
        shoesList.remove(rightShoe);
      }
      
    }
    return shoesList.size() == 0;
  }
}