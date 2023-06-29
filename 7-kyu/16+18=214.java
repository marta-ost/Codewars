/*
DESCRIPTION:
For this kata you will have to forget how to add two numbers.

It can be best explained using the following meme:

image

In simple terms, our method does not like the principle of carrying over numbers and just writes down every number it calculates :-)

You may assume both integers are positive integers.

Examples
  1 6
+ 1 8
  2 14

  2 6
+ 3 9
  5 15

  1 2 2
+   8 1
  1 103
​
You may assume both integers are positive integers and the result will not be bigger than Integer.MAX_VALUE
*/

public class SillyAdditon {
  public static int add(int num1, int num2) {
    String[] paddedNumbers = padWithZeroes(String.valueOf(num1), String.valueOf(num2));
    int paddedNumberLength = paddedNumbers[0].length();
    String[] digitsAfterAddition = new String[paddedNumberLength];
    
    for (int index = 0; index < paddedNumberLength; index++)
      digitsAfterAddition[index] = String.valueOf(
          Integer.parseInt(String.valueOf(paddedNumbers[0].charAt(index)))
        + Integer.parseInt(String.valueOf(paddedNumbers[1].charAt(index))));
    
    return Integer.parseInt(String.join("", digitsAfterAddition));
  }
  
  public static String[] padWithZeroes(String number1, String number2) {
    while (number1.length() > number2.length())
      number2 = "0" + number2;
    while (number2.length() > number1.length())
      number1 = "0" + number1;
    return new String[]{number1, number2};
  }
}