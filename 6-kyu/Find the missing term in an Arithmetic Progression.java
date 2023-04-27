/*
DESCRIPTION:
An Arithmetic Progression is defined as one in which there is a constant difference between the consecutive terms of a given series of numbers. You are provided with consecutive elements of an Arithmetic Progression. There is however one hitch: exactly one term from the original series is missing from the set of numbers which have been given to you. The rest of the given series is the same as the original AP. Find the missing term.

You have to write a function that receives a list, list size will always be at least 3 numbers. The missing term will never be the first or last one.

Example
findMissing([1, 3, 5, 9, 11]) == 7

PS: This is a sample question of the facebook engineer challenge on interviewstreet. I found it quite fun to solve on paper using math, derive the algo that way. Have fun!
*/

import java.util.Arrays;

public class Solution {
	public static int findMissing(int[] numbers) {
    int[] differences = new int[numbers.length - 1];
    
    for (int i = 1; i < numbers.length; i++)
      differences[i - 1] = numbers[i] - numbers[i - 1];
    
    int maxDifference = 0;
    boolean increasingOrConstant = numbers[1] - numbers[0] >= 0;
    
    if (increasingOrConstant)
      maxDifference = Arrays.stream(differences)
        .max()
        .getAsInt();
    else
      maxDifference = Arrays.stream(differences)
        .min()
        .getAsInt();
    
    int indexBeforeMissing = 0;
    
    for (int i = 0; i < differences.length; i++)
      if (differences[i] == maxDifference)
        indexBeforeMissing = i;
      
    return (numbers[indexBeforeMissing] + numbers[indexBeforeMissing + 1]) / 2;
  }
}