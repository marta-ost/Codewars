/*
DESCRIPTION:
Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case).

Examples
"the-stealth-warrior" gets converted to "theStealthWarrior"
"The_Stealth_Warrior" gets converted to "TheStealthWarrior"
*/

class Solution{

  static String toCamelCase(String s){
    final String DASH = "-";
    final String UNDERSCORE = "_";
    
    if (s.contains(DASH)) {
      return convertToCamelCase(s, DASH);
    }
    if (s.contains(UNDERSCORE)) {
      return convertToCamelCase(s, UNDERSCORE);
    }
    return s;
  }
  
  public static String convertToCamelCase(String s, String delimiter) {  
    int delimiterIndex = s.indexOf(delimiter);
    String firstPart = s.substring(0, delimiterIndex);
    String firstLetter = s.substring(delimiterIndex + 1, delimiterIndex + 2).toUpperCase();
    String otherPart = s.substring(delimiterIndex + 2);
    
    String camelCased = firstPart + firstLetter + otherPart;
    if (camelCased.contains(delimiter)) {
      camelCased = convertToCamelCase(camelCased, delimiter);
    }
    return camelCased;
  }
}