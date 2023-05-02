/*
DESCRIPTION:
First, You will write a very basic compression algorithm

It gets a string:
string="aaaaaaaabaaaa"
And generates an array that sums all the repeating characters like so:
compressed=[[8,"a"],[1,"b"],[4,"a"]]
The compressed version is turned into a string:
compressed='[[8,"a"],[1,"b"],[4,"a"]]'

Finally,
If the compressed version is shorter than the original string, the function will return the compressed version.
Otherwise it will return the original string.

Example1:
string1="aaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaa"
output1='[[26,"a"],[1,"b"],[18,"a"]]'

Example2:
string2="abcde"
output2="abcde"

After you created the compression algorithm, create a decompression algorithm:

It gets a string (output1, output2, etc.).
If the string is comrpessed, it returns the uncompressed version,
If it is uncompressed, it returns the original string unchanged.

//output1='[[26,"a"],[1,"b"],[18,"a"]]'
uncompress(output1)
//returns
"aaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaa"

//output2="abcde"
uncompress(output2)
//returns
"abcde"

Note: The original string may not contain "[]" for obvious reasons.
*/

public class Solution {
  public static String compress(String s) {
    StringBuilder compressedSB = new StringBuilder();
    compressedSB.append("[");
    
    String letter = "";
    int count = 0;
    
    for (int i = 0; i < s.length(); i++) {
      if (letter != "" && String.valueOf(s.charAt(i)).equals(letter))
        count++;
      else if (letter != "") {
        count++;
        compressedSB.append("[" + count + ",\"" + letter + "\"],");
        count = 0;
      }
      if (count == 0) 
        letter = String.valueOf(s.charAt(i));
    }
    count++;
    compressedSB.append("[" + count + ",\"" + letter + "\"],");
    compressedSB.deleteCharAt(compressedSB.length() - 1);
    compressedSB.append("]");
    
    String compressed = compressedSB.toString();
    return compressed.length() < s.length() ? compressed : s;
  }

  public static String decompress(String s) {
    if (!s.contains("\""))
      return s;
    
    s = s.replace("[", "").replace("]", "");
    
    StringBuilder decompressedSB = new StringBuilder();
    StringBuilder countSB = new StringBuilder();
    String letter = "";
    boolean isLetter = false;
    
    for (int i = 0; i < s.length(); i++) {
      String elem = String.valueOf(s.charAt(i));
      
      if (!isLetter && elem.equals(","))
        continue;
      else if (elem.equals("\""))
        isLetter = !isLetter;
      else if (isLetter) {
        int count = Integer.parseInt(countSB.toString());
        letter = String.valueOf(s.charAt(i));
        decompressedSB.append(letter.repeat(count));
        countSB = new StringBuilder();
      } else
        countSB.append(elem);
    }
    
    return decompressedSB.toString();
  }
}