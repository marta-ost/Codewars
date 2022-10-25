/*
DESCRIPTION:
"7777...8?!??!", exclaimed Bob, "I missed it again! Argh!" Every time there's an interesting number coming up, he notices and then promptly forgets. Who doesn't like catching those one-off interesting mileage numbers?

Let's make it so Bob never misses another interesting number. We've hacked into his car's computer, and we have a box hooked up that reads mileage numbers. We've got a box glued to his dash that lights up yellow or green depending on whether it receives a 1 or a 2 (respectively).

It's up to you, intrepid warrior, to glue the parts together. Write the function that parses the mileage number input, and returns a 2 if the number is "interesting" (see below), a 1 if an interesting number occurs within the next two miles, or a 0 if the number is not interesting.

Note: In Haskell, we use No, Almost and Yes instead of 0, 1 and 2.

"Interesting" Numbers
Interesting numbers are 3-or-more digit numbers that meet one or more of the following criteria:

Any digit followed by all zeros: 100, 90000
Every digit is the same number: 1111
The digits are sequential, incementing†: 1234
The digits are sequential, decrementing‡: 4321
The digits are a palindrome: 1221 or 73837
The digits match one of the values in the awesomePhrases array
† For incrementing sequences, 0 should come after 9, and not before 1, as in 7890.
‡ For decrementing sequences, 0 should come after 1, and not before 9, as in 3210.

So, you should expect these inputs and outputs:

// "boring" numbers
CarMileage.isInteresting(3, new int[]{1337, 256});    // 0
CarMileage.isInteresting(3236, new int[]{1337, 256}); // 0

// progress as we near an "interesting" number
CarMileage.isInteresting(11207, new int[]{}); // 0
CarMileage.isInteresting(11208, new int[]{}); // 0
CarMileage.isInteresting(11209, new int[]{}); // 1
CarMileage.isInteresting(11210, new int[]{}); // 1
CarMileage.isInteresting(11211, new int[]{}); // 2

// nearing a provided "awesome phrase"
CarMileage.isInteresting(1335, new int[]{1337, 256}); // 1
CarMileage.isInteresting(1336, new int[]{1337, 256}); // 1
CarMileage.isInteresting(1337, new int[]{1337, 256}); // 2
Error Checking
A number is only interesting if it is greater than 99!
Input will always be an integer greater than 0, and less than 1,000,000,000.
The awesomePhrases array will always be provided, and will always be an array, but may be empty. (Not everyone thinks numbers spell funny words...)
You should only ever output 0, 1, or 2.
*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarMileage {

  public static int isInteresting(int number, int[] awesomePhrases) {
    if (checkConditions(number) || digitsMatchAwesomePhrases(number, awesomePhrases)) {
      return 2;
    } else if (checkConditions(number + 1) || checkConditions(number + 2) || 
          digitsMatchAwesomePhrases(number + 1, awesomePhrases) || digitsMatchAwesomePhrases(number + 2, awesomePhrases)) {
      return 1;
    } else {
      return 0;
    }
  }

  public static boolean checkConditions(int number) {
    if (number < 100) {
      return false;
    }
    String numberStr = String.valueOf(number);
    return isDigitWithZeros(numberStr) || everyDigitIsTheSame(numberStr) || digitsAreIncrementing(numberStr) || 
           digitsAreDecrementing(numberStr) || digitsArePalindrome(numberStr);
  }

  public static boolean isDigitWithZeros(String numberStr) {
    Boolean[] isFitting = new Boolean[numberStr.length()];
    isFitting[0] = true;

    for (int i = 1; i < numberStr.length(); i++) {
        isFitting[i] = numberStr.charAt(i) == '0';
    }
    List<Boolean> isFittingList = Arrays.stream(isFitting).collect(Collectors.toList());
    return !isFittingList.contains(false);
  }

  public static boolean everyDigitIsTheSame(String numberStr) {
    Boolean[] isFitting = new Boolean[numberStr.length()];
    isFitting[0] = true;

    for (int i = 1; i < numberStr.length(); i++) {
      int firstElem = Integer.parseInt(numberStr.substring(i - 1, i));
      int secondElem = Integer.parseInt(numberStr.substring(i, i + 1));
      isFitting[i] = firstElem == secondElem;
    }
    List<Boolean> isFittingList = Arrays.stream(isFitting).collect(Collectors.toList());
    return !isFittingList.contains(false);
  }

  public static boolean digitsAreDecrementing(String numberStr) {
    Boolean[] isFitting = new Boolean[numberStr.length()];
    isFitting[0] = true;

    for (int i = 1; i < numberStr.length(); i++) {
      int firstElem = Integer.parseInt(numberStr.substring(i - 1, i));
      int secondElem = Integer.parseInt(numberStr.substring(i, i + 1));
      isFitting[i] = (firstElem == 1 && secondElem == 0) || (firstElem == secondElem + 1);
    }
    List<Boolean> isFittingList = Arrays.stream(isFitting).collect(Collectors.toList());
    return !isFittingList.contains(false);
  }

  public static boolean digitsAreIncrementing(String numberStr) {
    Boolean[] isFitting = new Boolean[numberStr.length()];
    isFitting[0] = true;

    for (int i = 1; i < numberStr.length(); i++) {
      int firstElem = Integer.parseInt(numberStr.substring(i - 1, i));
      int secondElem = Integer.parseInt(numberStr.substring(i, i + 1));
      isFitting[i] = (firstElem == 9 && secondElem == 0) || (firstElem == secondElem - 1);
    }
    List<Boolean> isFittingList = Arrays.stream(isFitting).collect(Collectors.toList());
    return !isFittingList.contains(false);
  }

  public static boolean digitsArePalindrome(String numberStr) {
    Boolean[] isFitting = new Boolean[numberStr.length()];
    
    for (int i = 0; i < numberStr.length(); i++) {
      int firstElem = Integer.parseInt(numberStr.substring(i, i + 1));
      int secondElem = Integer.parseInt(numberStr.substring(numberStr.length() - i - 1, numberStr.length() - i));
      isFitting[i] = firstElem == secondElem;
    }

    List<Boolean> isFittingList = Arrays.stream(isFitting).collect(Collectors.toList());
    return !isFittingList.contains(false);
  }

  public static boolean digitsMatchAwesomePhrases(int number, int[] awesomePhrases) {
    List<Integer> awesomePhrasesList = Arrays.stream(awesomePhrases).boxed().collect(Collectors.toList());
    return awesomePhrasesList.contains(number);
  }
}