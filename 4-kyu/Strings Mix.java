/*
DESCRIPTION:
Given two strings s1 and s2, we want to visualize how different the two strings are. We will only take into account the lowercase letters (a to z). First let us count the frequency of each lowercase letters in s1 and s2.

s1 = "A aaaa bb c"

s2 = "& aaa bbb c d"

s1 has 4 'a', 2 'b', 1 'c'

s2 has 3 'a', 3 'b', 1 'c', 1 'd'

So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3 from s2. In the following we will not consider letters when the maximum of their occurrences is less than or equal to 1.

We can resume the differences between s1 and s2 in the following string: "1:aaaa/2:bbb" where 1 in 1:aaaa stands for string s1 and aaaa because the maximum for a is 4. In the same manner 2:bbb stands for string s2 and bbb because the maximum for b is 3.

The task is to produce a string in which each lowercase letters of s1 or s2 appears as many times as its maximum if this maximum is strictly greater than 1; these letters will be prefixed by the number of the string where they appear with their maximum value and :. If the maximum is in s1 as well as in s2 the prefix is =:.

In the result, substrings (a substring is for example 2:nnnnn or 1:hhh; it contains the prefix) will be in decreasing order of their length and when they have the same length sorted in ascending lexicographic order (letters and digits - more precisely sorted by codepoint); the different groups will be separated by '/'. See examples and "Example Tests".

Hopefully other examples can make this clearer.

s1 = "my&friend&Paul has heavy hats! &"
s2 = "my friend John has many many friends &"
mix(s1, s2) --> "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"

s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
mix(s1, s2) --> "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"

s1="Are the kids at home? aaaaa fffff"
s2="Yes they are here! aaaaa fffff"
mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"
Note for Swift, R, PowerShell
The prefix =: is replaced by E:

s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
mix(s1, s2) --> "1:mmmmmm/E:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/E:ee/E:ss"
*/

import java.util.*;

public class Mixing {
  
    public static String mix(String s1, String s2) {
        String s1onlyLowercase = getOnlyLowercaseLetters(s1);
        String s2onlyLowercase = getOnlyLowercaseLetters(s2);

        SortedSet<Character> s1lettersDistinct = findDistinctLetters(s1onlyLowercase);
        SortedSet<Character> s2lettersDistinct = findDistinctLetters(s2onlyLowercase);

        SortedSet<Character> allComparedLetters = new TreeSet<>();
        allComparedLetters.addAll(s1lettersDistinct);
        allComparedLetters.addAll(s2lettersDistinct);

        TreeMap<Character, Integer> s1lettersWithAmount = getLettersWithAmount(s1onlyLowercase, s1lettersDistinct);
        TreeMap<Character, Integer> s2lettersWithAmount = getLettersWithAmount(s2onlyLowercase, s2lettersDistinct);

        TreeMap<Character, Integer> lettersWithBiggerAmount = getLettersWithBiggerAmount(allComparedLetters,
                s1lettersWithAmount, s2lettersWithAmount);

        TreeMap<String, Integer> substringsWithAmount = getSubstringsWithAmount(allComparedLetters,
                lettersWithBiggerAmount, s1lettersWithAmount, s2lettersWithAmount);

        List<String> sortedSubstrings = sortSubstrings(substringsWithAmount);

        return getTextResult(sortedSubstrings);
    }

    public static String getTextResult(List<String> sortedSubstrings ) {
        StringBuilder result = new StringBuilder();
        for (String substring : sortedSubstrings) {
            result.append(substring);
        }
        if (result.length() > 2) {
            return result.substring(0, result.length() - 1);
        } else {
            return "";
        }
    }

    public static List<String> sortSubstrings(TreeMap<String, Integer> substringsWithAmount) {
        TreeMap<String, Integer> substringsWithAmountCopyToRemove = new TreeMap<>(substringsWithAmount);

        LinkedList<String> sortedSubstrings = new LinkedList<>();
        Set<Map.Entry<String, Integer>> entries = substringsWithAmountCopyToRemove.entrySet();

        while (!substringsWithAmountCopyToRemove.isEmpty()) {
            ArrayList<String> substringsWithCurrentAmount = new ArrayList<>();
            Integer currentMaxValue = substringsWithAmountCopyToRemove.values().stream().max(Integer::compare).get();

            for (Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
                 iterator.hasNext(); ) {
                Map.Entry<String, Integer> next = iterator.next();
                if (next.getValue().equals(currentMaxValue)) {
                    substringsWithCurrentAmount.add(next.getKey());
                    iterator.remove();
                }
            }
            Collections.sort(substringsWithCurrentAmount);

            sortedSubstrings.addAll(substringsWithCurrentAmount);
        }
        return sortedSubstrings;
    }

    public static TreeMap<String, Integer> getSubstringsWithAmount(SortedSet<Character> allComparedLetters,
                                                                   TreeMap<Character, Integer> lettersWithBiggerAmount,
                                                                   TreeMap<Character, Integer> s1lettersWithAmount,
                                                                   TreeMap<Character, Integer> s2lettersWithAmount) {        
        SortedSet<Character> allComparedLettersCopyToRemove = new TreeSet<>(allComparedLetters);

        TreeMap<String, Integer> substringsWithAmount = new TreeMap<>();

        for (int i = 0; i < allComparedLetters.size(); i++) {
            StringBuilder substring = new StringBuilder();
            Character currentLetter = allComparedLettersCopyToRemove.first();

            if (lettersWithBiggerAmount.containsKey(currentLetter)) {
                int currentAmount = lettersWithBiggerAmount.get(currentLetter);

                String whichString = " ";
                if (s1lettersWithAmount.containsKey(currentLetter) &&
                        s1lettersWithAmount.get(currentLetter) == currentAmount &&
                        s2lettersWithAmount.containsKey(currentLetter) &&
                        s2lettersWithAmount.get(currentLetter) == currentAmount) {
                    whichString = "=";
                } else if (s1lettersWithAmount.containsKey(currentLetter) &&
                        s1lettersWithAmount.get(currentLetter) == currentAmount) {
                    whichString = "1";
                } else if (s2lettersWithAmount.containsKey(currentLetter) &&
                        s2lettersWithAmount.get(currentLetter) == currentAmount) {
                    whichString = "2";
                }

                substring.append(whichString).append(":");
                substring.append(String.valueOf(currentLetter).repeat(Math.max(0, currentAmount)));
                substring.append("/");

                substringsWithAmount.put(String.valueOf(substring), currentAmount);
            }
            allComparedLettersCopyToRemove.remove(currentLetter);
        }
        return substringsWithAmount;
    }

    public static TreeMap<Character, Integer> getLettersWithBiggerAmount(SortedSet<Character> allComparedLetters,
                                                                         TreeMap<Character, Integer> s1lettersWithAmount,
                                                                         TreeMap<Character, Integer> s2lettersWithAmount) {
        SortedSet<Character> allComparedLettersCopyToRemove = new TreeSet<>(allComparedLetters);
      
        TreeMap<Character, Integer> lettersWithBiggerAmount = new TreeMap<>();

        for (int i = 0; i < allComparedLetters.size(); i++) {
            int s1currentAmount = 0;
            int s2currentAmount = 0;
            Character currentLetter = allComparedLettersCopyToRemove.first();

            if (s1lettersWithAmount.containsKey(currentLetter)) {
                s1currentAmount = s1lettersWithAmount.get(currentLetter);
            }
            if (s2lettersWithAmount.containsKey(currentLetter)) {
                s2currentAmount = s2lettersWithAmount.get(currentLetter);
            }
            int biggerAmount = Math.max(s1currentAmount, s2currentAmount);
            if (biggerAmount > 1) {
                lettersWithBiggerAmount.put(currentLetter, biggerAmount);
            }
            allComparedLettersCopyToRemove.remove(currentLetter);
        }
        return lettersWithBiggerAmount;
    }

    public static SortedSet<Character> findDistinctLetters(String s) {
        char[] letters = s.toCharArray();
        SortedSet<Character> lettersDistinct = new TreeSet<>();

        for (char letter : letters) {
            lettersDistinct.add(letter);
        }
        return lettersDistinct;
    }

    public static String getOnlyLowercaseLetters(String s) {
        StringBuilder onlyLowercase = new StringBuilder();
        while (!s.isEmpty()) {
            if (s.substring(0, 1).matches("[a-z]")) {
                onlyLowercase.append(s.substring(0, 1));
            }
            s = s.substring(1);
        }
        return onlyLowercase.toString();
    }

    public static TreeMap<Character, Integer> getLettersWithAmount(String s, SortedSet<Character> lettersDistinct) {
        SortedSet<Character> lettersDistinctCopyToRemove = new TreeSet<>(lettersDistinct);

        TreeMap<Character, Integer> lettersWithAmount = new TreeMap<>();
        char[] letters = s.toCharArray();
        char currentLetter = ' ';
        int currentAmount = 0;

        while (!lettersDistinctCopyToRemove.isEmpty()) {
            currentLetter = lettersDistinctCopyToRemove.first();
            for (int j = 0; j < letters.length; j++) {
                if (currentLetter == letters[j]) {
                    letters[j] = ' ';
                    currentAmount++;
                }
            }
            lettersWithAmount.put(currentLetter, currentAmount);
            lettersDistinctCopyToRemove.remove(currentLetter);
            currentAmount = 0;
        }
        return lettersWithAmount;
    }
}