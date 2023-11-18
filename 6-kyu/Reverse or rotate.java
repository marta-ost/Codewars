/*
DESCRIPTION:
The input is a string str of digits. Cut the string into chunks (a chunk here is a substring of the initial string) of size sz (ignore the last chunk if its size is less than sz).

If a chunk represents an integer such as the sum of the cubes of its digits is divisible by 2, reverse that chunk; otherwise rotate it to the left by one position. Put together these modified chunks and return the result as a string.

If

sz is <= 0 or if str is empty return ""
sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return "".

Examples:

revrot("123456987654", 6) --> "234561876549"
revrot("123456987653", 6) --> "234561356789"
revrot("66443875", 4) --> "44668753"
revrot("66443875", 8) --> "64438756"
revrot("664438769", 8) --> "67834466"
revrot("123456779", 8) --> "23456771"
revrot("", 8) --> ""
revrot("123456779", 0) --> "" 
revrot("563000655734469485", 4) --> "0365065073456944"

Example of a string rotated to the left by one position:
s = "123456" gives "234561".
*/

import java.util.stream.*;
import java.util.*;

class RevRot {     
  public static String revRot(String str, int sz) { 
    if (sz <= 0 || str.isEmpty() || sz > str.length())
      return "";
    
    String[] allChunks = splitStrToChunks(str, sz);
    String[] chunks = discardLastChunkIfNotFull(allChunks, sz);
    
    return Arrays
      .stream(chunks)
      .map(chunk -> Arrays
           .stream(chunk.split(""))
           .mapToInt(Integer::parseInt)
           .sum() % 2 == 0 ? reverse(chunk) : rotate(chunk))
      .collect(Collectors.joining("")); 
  }
  
  private static String reverse(String chunk) {
    StringBuilder sb = new StringBuilder(chunk);
    sb.reverse();
    return sb.toString();
  }
  
  private static String rotate(String chunk) {
    return chunk.substring(1) + chunk.substring(0, 1);
  }
  
  private static String[] discardLastChunkIfNotFull(String[] chunks, int sz) {
    String fullChunksStr = Arrays
      .stream(chunks)
      .map(chunk -> chunk.length() < sz ? "" : chunk)
      .collect(Collectors.joining(" "));
    
    return fullChunksStr.split(" ");
  }
  
  private static String[] splitStrToChunks(String str, int sz) {
    String[] strArray = str.split("");
    
    String chunksStr = IntStream
      .rangeClosed(1, str.length())
      .mapToObj(i -> i % sz == 0 ? strArray[i - 1] + " " : strArray[i - 1])
      .collect(Collectors.joining(""));
    
    return chunksStr.split(" ");
  }
} 