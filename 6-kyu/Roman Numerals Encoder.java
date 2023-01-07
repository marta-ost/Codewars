/*
DESCRIPTION:
Create a function taking a positive integer between 1 and 3999 (both included) as its parameter and returning a string containing the Roman Numeral representation of that integer.

Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.

Example:

conversion.solution(1000); //should return "M"
Help:

Symbol    Value
I          1
V          5
X          10
L          50
C          100
D          500
M          1,000
Remember that there can't be more than 3 identical symbols in a row.

More about roman numerals - http://en.wikipedia.org/wiki/Roman_numerals
*/

public class Conversion {
  public String solution(int n) {
    StringBuilder roman = new StringBuilder();
    check(n, roman);
    return roman.toString();
  }
  
  public static int check(int n, StringBuilder roman) {
    if (n == 0) {
      return n;
    } else {
      if (n >= 1000) {
        roman.append("M");
        n = n - 1000;
      } else if (n >= 900) {
        roman.append("CM");
        n = n - 900;
      } else if (n >= 500) {
        roman.append("D");
        n = n - 500;
      } else if (n >= 400) {
        roman.append("CD");
        n = n - 400;
      } else if (n >= 100) {
        roman.append("C");
        n = n - 100;
      } else if (n >= 90) {
        roman.append("XC");
        n = n - 90;
      } else if (n >= 50) {
        roman.append("L");
        n = n - 50;
      } else if (n >= 40) {
        roman.append("XL");
        n = n - 40;
      } else if (n >= 10) {
        roman.append("X");
        n = n - 10;
      } else if (n >= 9) {
        roman.append("IX");
        n = n - 9;
      } else if (n >= 5) {
        roman.append("V");
        n = n - 5;
      } else if (n >= 4) {
        roman.append("IV");
        n = n - 4;
      } else if (n >= 1) {
        roman.append("I");
        n = n - 1;
      }
    return check(n, roman);
    }
  }
}