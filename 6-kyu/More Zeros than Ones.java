/*
DESCRIPTION:
Create a moreZeros function which will receive a string for input, and return an array (or null terminated string in C) containing only the characters from that string whose binary representation of its ASCII value consists of more zeros than ones.

You should remove any duplicate characters, keeping the first occurrence of any such duplicates, so they are in the same order in the final array as they first appeared in the input string.

Examples

'abcde' === ["1100001", "1100010", "1100011", "1100100", "1100101"]
               True       True       False      True       False
                   
        --> ['a','b','d']
    
'DIGEST'--> ['D','I','E','T']
All input will be valid strings of length > 0. Leading zeros in binary should not be counted.
*/

import java.nio.charset.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Kata {
  public static char[] moreZeros(String s) {
    byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
    
    int[] ints = new int[bytes.length];
    for (int i = 0; i < bytes.length; i++) {
      ints[i] = bytes[i];
    }

    int[] binary = Arrays.stream(ints)
      .map(b -> Integer.parseInt(Integer.toBinaryString(b)))
      .toArray();
    
    String[] binaryStr = Arrays.stream(binary)
      .boxed()
      .map(b -> String.valueOf(b))
      .toArray(String[]::new);
    
    LinkedList<String> withMoreZerosBinaryStr = new LinkedList<>();
    for (String binaryNum : binaryStr) {
      int zeros = 0;
      int ones = 0;
      for (int i = 0; i < binaryNum.length(); i++) {
        if (binaryNum.charAt(i) == '0')
          zeros++;
        else if (binaryNum.charAt(i) == '1')
          ones++;
      }
      if (zeros > ones)
        withMoreZerosBinaryStr.add(binaryNum);
    }
    
    LinkedList<Integer> withMoreZerosInt = new LinkedList<>();
    for (String binaryNum : withMoreZerosBinaryStr) {
      int num = Integer.parseInt(binaryNum, 2);
      withMoreZerosInt.add(num);
    }
    
    LinkedList<Integer> withMoreZerosIntDistinct = new LinkedList<>();
    for (Integer num : withMoreZerosInt) {
      if (!withMoreZerosIntDistinct.contains(num))
        withMoreZerosIntDistinct.add(num);
    }
      
    char[] withMoreZerosCharDistinct = new char[withMoreZerosIntDistinct.size()];
    int index = 0;
    for (int num : withMoreZerosIntDistinct) {
      withMoreZerosCharDistinct[index] = (char) num;
      index++;
    }
    
    return withMoreZerosCharDistinct;
  }
}