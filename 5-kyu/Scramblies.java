/*
DESCRIPTION:
Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.

Notes:

Only lower case letters will be used (a-z). No punctuation or digits will be included.
Performance needs to be considered.
Examples
scramble('rkqodlw', 'world') ==> True
scramble('cedewaraaossoqqyt', 'codewars') ==> True
scramble('katas', 'steak') ==> False
*/

import java.util.stream.Collectors;
import java.util.*;
import java.util.function.Function;

public class Scramblies {
    
    public static boolean scramble(String str1, String str2) {  
        Map<Character, Long> filteredWithCount = str1
                .chars()
                .mapToObj(x -> (char) x)
                .filter(x -> str2.contains(x.toString()))
                .sorted()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> expectedWithCount = str2
                .chars()
                .mapToObj(x -> (char) x)
                .sorted()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Integer> letterWithComparisonResult = filteredWithCount
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey(),
                        e -> e.getValue()
                                .compareTo(expectedWithCount.get(e.getKey()))));

        return !letterWithComparisonResult.containsValue(-1) && //too small amount of some expected letters in str1
                expectedWithCount.size() == filteredWithCount.size(); //some expected letters does not exist at all in str1
    }
}