/*
DESCRIPTION:
Write simple .camelCase method (camel_case function in PHP, CamelCase in C# or camelCase in Java) for strings. All words must have their first letter capitalized without spaces.

For instance:

camelCase("hello case"); // => "HelloCase"
camelCase("camel case word"); // => "CamelCaseWord"
Don't forget to rate this kata! Thanks :)
*/

public class Solution {
  public static String camelCase(String str) {
    String[] words = str.split(" ");
    StringBuilder camelCased = new StringBuilder();
    
    for (int i = 0; i < words.length; i++) {
      if (words[i].isEmpty())
        continue;
      words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
      camelCased.append(words[i]);
    }
    return camelCased.toString();
  }
}