/*
DESCRIPTION:
Your task is to Combine two Strings. But consider the rule...

By the way you don't have to check errors or incorrect input values, everything is ok without bad tricks, only two input strings and as result one output string;-)...

And here's the rule:
Input Strings a and b: For every character in string a swap the casing of every occurrence of the same character in string b. Then do the same casing swap with the inputs reversed. Return a single string consisting of the changed version of a followed by the changed version of b. A char of a is in b regardless if it's in upper or lower case - see the testcases too.
I think that's all;-)...

Some easy examples:

Input: "abc" and "cde"      => Output: "abCCde" 
Input: "ab" and "aba"       => Output: "aBABA"
Input: "abab" and "bababa"  => Output: "ABABbababa"

Once again for the last example - description from KenKamau, see discourse;-):

a) swap the case of characters in string b for every occurrence of that character in string a
char 'a' occurs twice in string a, so we swap all 'a' in string b twice. This means we start with "bababa" then "bAbAbA" => "bababa"
char 'b' occurs twice in string a and so string b moves as follows: start with "bababa" then "BaBaBa" => "bababa"

b) then, swap the case of characters in string a for every occurrence in string b
char 'a' occurs 3 times in string b. So string a swaps cases as follows: start with "abab" then => "AbAb" => "abab" => "AbAb"
char 'b' occurs 3 times in string b. So string a swaps as follow: start with "AbAb" then => "ABAB" => "AbAb" => "ABAB".

c) merge new strings a and b
return "ABABbababa"

There are some static tests at the beginning and many random tests if you submit your solution.

Hope you have fun:-)!
*/

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Map.*;

class Kata {
  public static String workOnStrings(String a, String b) {
    return swapLettersInS1BasedOnS2(a, b) + swapLettersInS1BasedOnS2(b, a);
  }
  
  private static String swapLettersInS1BasedOnS2(String s1, String s2) {
    Map<String, Integer> lettersWithCountsS2 = Arrays
      .stream(s2.split(""))
      .collect(Collectors.groupingBy(Function.identity(),
                                     Collectors.summingInt(e -> 1)));
    
    for (Entry<String, Integer> letterWithCountS2 : lettersWithCountsS2.entrySet())
      if (letterWithCountS2.getValue() % 2 != 0) 
        s1 = swapLetter(s1, letterWithCountS2.getKey()); 
    
    return s1;
  }
  
  private static String swapLetter(String s, String letter) {
    return Arrays
      .stream(s.split(""))
      .map(l -> l.equalsIgnoreCase(letter) 
                ? l.toLowerCase().equals(l) ? l.toUpperCase() : l.toLowerCase() 
                : l)
      .collect(Collectors.joining(""));
  }
}