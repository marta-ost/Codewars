/*
DESCRIPTION:

Mount the Bowling Pins!

Task:

Did you ever play Bowling? Short: You have to throw a bowl into 10 Pins arranged like this:

I I I I  # each Pin has a Number:    7 8 9 10
 I I I                                4 5 6
  I I                                  2 3
   I                                    1

You will get an Array with Numbers, e.g.: [3,5,9] and remove them from the field like this:

I I   I
 I   I
  I   
   I   

Return a string with the current field.

Note that:

You begin a new line with \n
Each Line must be 7 chars long
Fill the missing pins with a whitespace

Have fun!
*/

public class Bowling {
  public String bowlingPins(int[] arr) {
    String pins = "7 8 9 0\n" + 
                  " 4 5 6 \n" + 
                  "  2 3  \n" + 
                  "   1   ";
    
    for (int pin : arr) {
      int index = pins.indexOf(String.valueOf(pin % 10));
      pins = pins.substring(0, index) + " " + pins.substring(index + 1);
    }

   return pins.replaceAll("[0-9]", "I");
  }
}