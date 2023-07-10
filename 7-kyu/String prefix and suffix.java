/*
DESCRIPTION:
In this Kata, you will be given a string and your task will be to return the length of the longest prefix that is also a suffix. A prefix is the start of a string while the suffix is the end of a string. For instance, the prefixes of the string "abcd" are ["a","ab","abc"]. The suffixes are ["bcd", "cd", "d"]. You should not overlap the prefix and suffix.

for example:
solve("abcd") = 0, because no prefix == suffix. 
solve("abcda") = 1, because the longest prefix which == suffix is "a".
solve("abcdabc") = 3. Longest prefix which == suffix is "abc".
solve("aaaa") = 2. Longest prefix which == suffix is "aa". You should not overlap the prefix and suffix
solve("aa") = 1. You should not overlap the prefix and suffix.
solve("a") = 0. You should not overlap the prefix and suffix.

All strings will be lowercase and string lengths are 1 <= length <= 500

More examples in test cases. Good luck!
*/

class SuffPref {
  public static int solve(String s){ 
    int sLength = s.length();
    int prefSufLength = s.length() / 2;
    
    while (prefSufLength > 0) {
      String prefix = s.substring(0, prefSufLength);
      String suffix = s.substring(sLength - prefSufLength);
      
      if (prefix.equals(suffix))
        return prefSufLength;
      
      prefSufLength--;
    }
    
    return 0;
  }
}