/*
DESCRIPTION:
Acknowledgments:
I thank yvonne-liu for the idea and for the example tests :)

Description:
Encrypt this!

You want to create secret messages which can be deciphered by the Decipher this! kata. Here are the conditions:

Your message is a string containing space separated words.
You need to encrypt each word in the message using the following rules:
The first letter must be converted to its ASCII code.
The second letter must be switched with the last letter
Keepin' it simple: There are no special characters in the input.

Examples:
Kata.encryptThis("Hello") => "72olle"
Kata.encryptThis("good") => "103doo"
Kata.encryptThis("hello world") => "104olle 119drlo"
*/

public class Kata {
  public static String encryptThis(String text) {
    System.out.println(text);
    String[] words = text.split(" ");  
    StringBuilder encrypted = new StringBuilder();
    
    for (String word : words) {
      if (word.length() > 0)
        encrypted.append((int) word.charAt(0));
      if (word.length() > 2)
        encrypted.append(word.charAt(word.length() - 1));
      if (word.length() > 3)
        encrypted.append(word.substring(2, word.length() - 1));
      if (word.length() > 1)
        encrypted.append(word.charAt(1));
      encrypted.append(" ");
    }
    return encrypted.toString().trim();
  }
}