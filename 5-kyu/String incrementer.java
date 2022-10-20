/*
DESCRIPTION:
Your job is to write a function which increments a string, to create a new string.

If the string already ends with a number, the number should be incremented by 1.
If the string does not end with a number. the number 1 should be appended to the new string.
Examples:

foo -> foo1

foobar23 -> foobar24

foo0042 -> foo0043

foo9 -> foo10

foo099 -> foo100

Attention: If the number has leading zeros the amount of digits should be considered.
*/

import java.math.BigInteger;
import java.util.regex.*;

public class Kata {
    public static String incrementString(String str) {
        StringBuilder newString = new StringBuilder();

        Pattern numbersPattern = Pattern.compile("[0-9]");
        Pattern lettersPattern = Pattern.compile("[^0-9]");

        if (str.equals("")) { //if string is empty
            newString.append("1");

        } else if (numbersPattern.matcher(str.substring(str.length() - 1)).find()) { //if last sign is a number
            int lastDigitIndex = str.length() - 1;
            int firstDigitIndex = findFirstDigitIndex(lettersPattern, str, lastDigitIndex); //starting from the last digit

            String lettersPart = str.substring(0, firstDigitIndex);
            String numbersPart = str.substring(firstDigitIndex);

            int numberOfDigits = numbersPart.length();

            BigInteger number = new BigInteger(numbersPart);
            BigInteger incremented = number.add(BigInteger.valueOf(1));
          
            String incrementedWithZeros = String.format("%0" + numberOfDigits + "d", incremented);

            newString.append(lettersPart).append(incrementedWithZeros);

        } else { //if last sign is not a number
            newString.append(str).append("1");
        }
        return newString.toString();
    }

    public static int findFirstDigitIndex(Pattern lettersPattern, String str, int currentIndex) {
        if (currentIndex >= 1 && !lettersPattern.matcher(str.substring(currentIndex - 1, currentIndex)).find()) { //if previous isn't a letter
            currentIndex = findFirstDigitIndex(lettersPattern, str, currentIndex - 1);
        }
        return currentIndex;
    }
}