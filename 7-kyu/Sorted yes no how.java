/*
DESCRIPTION:
Complete the method which accepts an array of integers, and returns one of the following:

"yes, ascending" - if the numbers in the array are sorted in an ascending order
"yes, descending" - if the numbers in the array are sorted in a descending order
"no" - otherwise
You can assume the array will always be valid, and there will always be one correct answer.
*/

class Solution {
  public static String isSortedAndHow(int[] array) {
    boolean ascending = true;
    boolean descending = true;
    
    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1])
        ascending = false;
      if (array[i] > array[i - 1])
        descending = false;
    }
    
    return ascending ? "yes, ascending" :
    descending ? "yes, descending" : "no";
  }
}