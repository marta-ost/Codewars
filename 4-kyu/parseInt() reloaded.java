/*
DESCRIPTION:
In this kata we want to convert a string into an integer. The strings simply represent the numbers in words.

Examples:

"one" => 1
"twenty" => 20
"two hundred forty-six" => 246
"seven hundred eighty-three thousand nine hundred and nineteen" => 783919
Additional Notes:

The minimum number is "zero" (inclusively)
The maximum number, which must be supported is 1 million (inclusively)
The "and" in e.g. "one hundred and twenty-four" is optional, in some cases it's present and in others it's not
All tested numbers are valid, you don't need to validate them
*/

public class Parser {
    
    public static int parseInt(String numStr) {
      String[] words = numStr.replace("-", " ").replace(" and ", " ").split(" ");
      int temp = 0;
      int result = 0;

      for (String word : words) {
        if (word.equals("zero")) {
          temp += 0;
        } else if (word.equals("one")) {
          temp += 1;
        } else if (word.equals("two")) {
          temp += 2;
        } else if (word.equals("three")) {
          temp += 3;
        } else if (word.equals("four")) {
          temp += 4;
        } else if (word.equals("five")) {
          temp += 5;
        } else if (word.equals("six")) {
          temp += 6;
        } else if (word.equals("seven")) {
          temp += 7;
        } else if (word.equals("eight")) {
          temp += 8;
        } else if (word.equals("nine")) {
          temp += 9;
        } else if (word.equals("ten")) {
          temp += 10;
        } else if (word.equals("eleven")) {
          temp += 11;
        } else if (word.equals("twelve")) {
          temp += 12;
        } else if (word.equals("thirteen")) {
          temp += 13;
        } else if (word.equals("fourteen")) {
          temp += 14;
        } else if (word.equals("fifteen")) {
          temp += 15;
        } else if (word.equals("sixteen")) {
          temp += 16;
        } else if (word.equals("seventeen")) {
          temp += 17;
        } else if (word.equals("eighteen")) {
          temp += 18;
        } else if (word.equals("nineteen")) {
          temp += 19;
        } else if (word.equals("twenty")) {
          temp += 20;
        } else if (word.equals("thirty")) {
          temp += 30;
        } else if (word.equals("forty")) {
          temp += 40;
        } else if (word.equals("fifty")) {
          temp += 50;
        } else if (word.equals("sixty")) {
          temp += 60;
        } else if (word.equals("seventy")) {
          temp += 70;
        } else if (word.equals("eighty")) {
          temp += 80;
        } else if (word.equals("ninety")) {
          temp += 90;
        } else if (word.equals("hundred")) {
          temp *= 100;
        } else if (word.equals("thousand")) {
          temp *= 1000;
          result += temp;
          temp = 0;
        } else if (word.equals("million")) {
          temp *= 1000000;
          result += temp;
          temp = 0;
        }
      }
      result += temp;
      return result;
    }
}