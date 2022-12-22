/*
DESCRIPTION:
Given a string of numbers, you must perform a method in which you will translate this string into text, based on the below image:


For example if you get "22" return "b", if you get "222" you will return "c". If you get "2222" return "ca".

Further details:

0 is a space in the string.
1 is used to separate letters with the same number.
always transform the number to the letter with the maximum value, as long as it does not have a 1 in the middle. So, "777777" -->  "sq" and "7717777" --> "qs".
you cannot return digits.
Given a empty string, return empty string.
Return a lowercase string.
Examples:
"443355555566604466690277733099966688"  -->  "hello how are you"
"55282"                 -->  "kata"
"22266631339277717777"  -->  "codewars"
"66885551555"           -->  "null"
"833998"                -->  "text"
"000"                   -->  "   "
*/

public class PhoneWords {
  public static String phoneWords(String str) {
    return str == "" || str == null ? "" 
      : str
      .replaceAll("7777", "s")
      .replaceAll("9999", "z")
        
      .replaceAll("222", "c")
      .replaceAll("333", "f")
      .replaceAll("444", "i")
      .replaceAll("555", "l")
      .replaceAll("666", "o")
      .replaceAll("777", "r")
      .replaceAll("888", "v")
      .replaceAll("999", "y")
      
      .replaceAll("22", "b")
      .replaceAll("33", "e")
      .replaceAll("44", "h")
      .replaceAll("55", "k")
      .replaceAll("66", "n")
      .replaceAll("77", "q")
      .replaceAll("88", "u")
      .replaceAll("99", "x")
      
      .replaceAll("2", "a")
      .replaceAll("3", "d")
      .replaceAll("4", "g")
      .replaceAll("5", "j")
      .replaceAll("6", "m")
      .replaceAll("7", "p")
      .replaceAll("8", "t")
      .replaceAll("9", "w")
      
      .replaceAll("0", " ")
      .replaceAll("1", "");
  } 
}