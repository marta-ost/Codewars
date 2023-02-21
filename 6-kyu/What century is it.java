/*
DESCRIPTION:
Return the century of the input year. The input will always be a 4 digit string, so there is no need for validation.

Examples
"1999" --> "20th"
"2011" --> "21st"
"2154" --> "22nd"
"2259" --> "23rd"
"1124" --> "12th"
"2000" --> "20th"
*/

public class Solution{
  public static String whatCentury(int year) {
    int century = year % 100 == 0 ? year / 100 : year / 100 + 1;
    String centuryStr = String.valueOf(century);
    char lastDigit = centuryStr.charAt(centuryStr.length() - 1);
    return centuryStr.equals("11") ? centuryStr + "th" :
    centuryStr.equals("12") ? centuryStr + "th" :
    centuryStr.equals("13") ? centuryStr + "th" :
    lastDigit == '1' ? centuryStr + "st" :
    lastDigit == '2' ? centuryStr + "nd" :
    lastDigit == '3' ? centuryStr + "rd" :
    centuryStr + "th";
  }
}