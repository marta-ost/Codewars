/*
DESCRIPTION:
Run-length encoding (RLE) is a very simple form of lossless data compression in which runs of data are stored as a single data value and count.

A simple form of RLE would encode the string "AAABBBCCCD" as "3A3B3C1D" meaning, first there are 3 A, then 3 B, then 3 C and last there is 1 D.

Your task is to write a RLE encoder and decoder using this technique. The texts to encode will always consist of only uppercase characters, no numbers.
*/

public class RunLengthEncoding {
  public static String encode(String input) {
    StringBuilder encoded = new StringBuilder();
    String[] chars = input.split("");    
    int count = 1;
    
    for (int i = 1; i < chars.length; i++) {
      if (chars[i].equals(chars[i - 1]))
        count++;
      else {
        encoded.append(count).append(chars[i - 1]);
        count = 1;
      }
    }
    encoded.append(count).append(chars[chars.length - 1]);
    
    return encoded.toString();
  }

  public static String decode(String input) {
    StringBuilder decoded = new StringBuilder();
    String[] chars = input.split("");
    StringBuilder count = new StringBuilder();
    
    for (String elem : chars) {
      if (elem.matches("[0-9]"))
        count.append(elem);
      if (elem.matches("[a-zA-Z]")) {
        decoded.append(elem.repeat(Integer.parseInt(count.toString())));
        count = new StringBuilder();
      }
    }
    
    return decoded.toString();
  }
}