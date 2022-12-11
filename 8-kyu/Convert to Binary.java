/*
DESCRIPTION:
Task Overview
Given a non-negative integer n, write a function to_binary/ToBinary which returns that number in a binary format.

to_binary(1)  / should return 1 /
to_binary(5)  / should return 101 /
to_binary(11) / should return 1011 /
*/

public class Kata {
  public static int toBinary(int n) {
    StringBuilder binary = new StringBuilder();
    return getBinary(n, binary);
  }
  
  private static int getBinary(int n, StringBuilder binary) {
    int currentRemainder = n % 2;
    int newN = n / 2;
    binary.append(String.valueOf(currentRemainder));
  
    return newN == 0 
      ? Integer.parseInt(binary.reverse().toString()) 
      : getBinary(newN, binary);
  }
}