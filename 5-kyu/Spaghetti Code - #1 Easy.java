/*
DESCRIPTION:

Hooray - It's "Spaghetti Night" !

Spaghetti is my favourite meal, so I always like to save the longest piece for last...

Task

Write some spaghetti code to help me know which piece of spaghetti is the longest.

Try NOT to write spaghetti code that looks like spaghetti code !

NOTES

I eat a special (very hard to find) brand of spaghetii where each piece has a unique uppercase letter ID
If multiple spaghetti pieces are longest, just return any one of them (all spaghetti tastes the same)
If the plate has no spaghetti then return empty string
All of my plates are rectangular
Plates can have any (non alphabetic) background pattern on them

Examples

Ex1

AAAAAAAA____
____________
BBBBBBBBBBB_
____________
CCCCCC______
Answer: B

Ex2

AAAAAAAAA   
________A__CCC_
 B   C  A    C 
_B___C__A____C_
 B   C       C 
_B___CCCCCCCCC_
Answer: C
*/

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class SpaghettiCode {
	public static String spaghetti(String[][] plate) {
    Map<String, Integer> idsWithLengths = Arrays
      .stream(plate)
      .flatMap(array -> Arrays.stream(array))
      .filter(elem -> elem.matches("[A-Za-z]"))
      .collect(Collectors.groupingBy(Function.identity(),
                                    Collectors.summingInt(e -> 1)));
    
    
     return idsWithLengths.size() == 0 ? "" 
       : Collections
         .max(idsWithLengths.entrySet(), Map.Entry.comparingByValue())
         .getKey(); 
  }
}