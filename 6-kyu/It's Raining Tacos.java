/*
DESCRIPTION:
It's Raining Tacos!
A line of tacos is falling out of the sky onto the landscape.

Your task is to predict what the landscape will look like when the tacos fall on it.

                   
INPUT:             
           *********

                   
OUTPUT:    TACOTACOT
           *********

The landscape is represented as any ASCII character, with the air being represented as whitespaces. The rows are separated by newline characters.

Tacos fall from left to right, distributing the word TACO repeadetly over the landscape. Each letter falls on the topmost part of the landscape in that area.

If there are no characters in that location, the taco falls all the way to the bottom.

                   
INPUT:       *  ** 
           *** **** 

             C  AC 
OUTPUT:    TA* T**O
           ***O****T

If there is no space for tacos to fall, then that space is skipped. The next letter still continues forward in the TACO sequence.

           **      
INPUT:     ****    
           ******  

           **CO    
OUTPUT:    ****TA  
           ******COT

Tacos cannot fall through solid material. If there is a floating island, TACO should be placed on the island, not below it.

                   
INPUT:      *****  
                    

            COTAC 
OUTPUT:     ***** 
          TA     OT

The width and height of the landscape can be anywhere from 1 to 100.

In the case of an empty string, return an empty string.

Good Luck!
*/

import java.util.*;
import java.util.stream.*;

public class RainTacos {
  static final String SPACE = " ";
  static final String NEW_LINE = "\n";
  static final String[] TACO = {"T", "A", "C", "O"};
  
  public static String rainTacos(String landscape) {
    if (landscape.isEmpty())
      return "";
    
    String[][] landscapeArray = Arrays
      .stream(landscape.split(NEW_LINE))
      .map(line -> line.split(""))
      .toArray(String[][]::new);
  
    String[][] tacosArray = addTacos(landscapeArray);

    return convertArrayToString(tacosArray);
  }
  
  private static String convertArrayToString(String[][] array) {
    StringBuilder converted = new StringBuilder();
    
    for (int i = 0; i < array.length; i++) {
      if (i != 0) 
        converted.append(NEW_LINE);
      for (int j = 0; j < array[i].length; j++)
        converted.append(array[i][j]);
    } 
    return converted.toString();
  }
  
  private static String[][] addTacos(String[][] array) {
    for (int j = 0; j < array[0].length; j++) {
      boolean underTaco = false;
      
      for (int i = 0; i < array.length; i++) {
        if (i == 0 && !array[i][j].equals(SPACE)) {
          underTaco = true;
          break;
        } else if (array[i][j].equals(SPACE) && i + 1 < array.length && !array[i + 1][j].equals(SPACE)) {
          array[i][j] = getTacoLetter(j);
          underTaco = true;
          break;
        } else if (i == array.length - 1 && !underTaco && array[i][j].equals(SPACE)) {
          array[i][j] = getTacoLetter(j);
        }
      }
    }
    return array;
  }
  
  private static String getTacoLetter(int index) {
    return TACO[index % TACO.length];
  }
}