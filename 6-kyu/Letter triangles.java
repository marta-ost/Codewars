/*
DESCRIPTION:
Letter triangles

Similar to Coloured triangles.

But this one sums indexes of letters in alphabet.

Examples

c o d e w a r s
c is 3
o is 15
15+3=18
18. letter in the alphabet is r
then append r
next is o d
sum is 19
append s
do this until you iterate through whole string
now, string is rsibxsk
repeat whole cycle until you reach 1 character
then return the char
output is l
codewars -> l
triangle -> d
C O D E W A R S
 R S I B X S K
  K B K Z Q D
   M M K Q U
    Z X B L
     X Z N
      X N
       L
A B C D
 C E G
  H L
   T
More examples

youhavechosentotranslatethiskata -> a
cod -> k
yes -> b
hours -> y
circlecipher -> z
lettertriangles -> o
cod -> rs -> k
abcd -> ceg -> hl -> t
codewars -> rsibxsk -> kbkzqd -> mmkqu -> zxbl -> xzn -> xn -> l
Note, if the sum is bigger than 26, then start over

Input will always be lowercase letters. Random tests contains strings up to 30 letters.
*/

public class Kata {
  public static String triangle(final String row) {
    String[] letters = row.toLowerCase().split("");
    
    while(letters.length > 1)
      letters = getNewLetters(letters);
    
    return letters[0]; 
  }
  
  public static String[] getNewLetters(String[] letters) {
    String[] newLetters = new String[letters.length - 1];
    
    for (int i = 0; i < letters.length - 1; i++) {
      int sum = (int) letters[i].charAt(0) - 96 + (int) letters[i + 1].charAt(0) - 96;
      while (sum > 26)
        sum -= 26;
      newLetters[i] = String.valueOf((char) (sum + 96));
    }
    
    return newLetters;
  }
}