/*
DESCRIPTION:

Kata Task
A bird flying high above a mountain range is able to estimate the height of the highest peak.

Can you?

Example

The birds-eye view

^^^^^^
 ^^^^^^^^
  ^^^^^^^
  ^^^^^
  ^^^^^^^^^^^
  ^^^^^^
  ^^^^

The bird-brain calculations

111111
 1^^^^111
  1^^^^11
  1^^^1
  1^^^^111111
  1^^^11
  1111

111111
 12222111
  12^^211
  12^21
  12^^2111111
  122211
  1111

111111
 12222111
  1233211
  12321
  12332111111
  122211
  1111

Height = 3

Series
Bird Mountain
Bird Mountain - the river
*/

import java.util.Arrays;
import java.util.stream.*;

public class Dinglemouse {
  public static int peakHeight(char[][] mountain) {
    if (!Arrays
        .stream(mountain)
        .map(Arrays::toString) 
        .collect(Collectors.joining())
        .contains("^"))
      return 0;
    
    for (int i = 0; i < mountain.length; i++) {
      for (int j = 0; j < mountain[0].length; j++) {
        if (mountain[i][j] == ' ')
          mountain[i][j] = '0';
        if (mountain[i][j] == '^' && (i == 0 || i == mountain.length - 1 || j == 0 || j == mountain[0].length - 1))
          mountain[i][j] = '1';
      }
    }
    int height = 0;
    String fullHeight = "";
    return findAnotherLayer(mountain, height, fullHeight);
  }

  public static int findAnotherLayer(char[][] mountain, int height, String fullHeight) {
    char heightCh = String.valueOf(height).charAt(0);
    for (int i = 0; i < mountain.length; i++) {
      for (int j = 0; j < mountain[0].length; j++) {
        if (mountain[i][j] == '^') {
          if (i - 1 >= 0 && mountain[i - 1][j] == heightCh || i + 1 < mountain.length && mountain[i + 1][j] == heightCh ||
              j - 1 >= 0 && mountain[i][j - 1] == heightCh || j + 1 < mountain[0].length && mountain[i][j + 1] == heightCh)
            mountain[i][j] = String.valueOf(height + 1).charAt(0);
        }
      }
    }
    height++;
    if (!fullHeight.isEmpty())
      fullHeight = String.valueOf(Integer.parseInt(fullHeight) + 1);
    
    if (height > 9) {
      if (fullHeight.isEmpty())
        fullHeight = String.valueOf(height);
      else 
        fullHeight = String.valueOf(Integer.parseInt(fullHeight));
      if (height % 10 == 0)
        height = 1;
      else 
        height = height / 10;
    }
    
    if (Arrays
        .stream(mountain)
        .map(Arrays::toString) 
        .collect(Collectors.joining())
        .contains("^"))
      return findAnotherLayer(mountain, height, fullHeight);
    else
      return fullHeight.isEmpty() ? height : Integer.parseInt(fullHeight);
  }
}