/*
DESCRIPTION:
A non-empty array a of length n is called an array of all possibilities if it contains all numbers between [0,a.length-1].Write a method named isAllPossibilities that accepts an integer array and returns true if the array is an array of all possibilities, else false.

Example:

a=[1,2,0,3]
a.length-1=3 
a includes [0,3] ,hence the function should return true
*/

import java.util.Arrays;

public class Solution {
	public static boolean isAllPossibilities(int[] arg) {
    if (arg.length == 0) return false;
		Arrays.sort(arg);
    for (int i = 0; i < arg.length; i++) {
      if (arg[i] != i) 
        return false;
    }
    return true;
	}
}