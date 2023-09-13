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
    String pins = "7s8s9s0\n" + 
                  "s4s5s6s\n" + 
                  "ss2s3ss\n" + 
                  "sss1sss";
    
    for (int pin : arr) {
      if (pin == 10)
        pin = 0;
      
      int index = pins.indexOf(String.valueOf(pin));
      pins = pins.substring(0, index) + "s" + pins.substring(index + 1);
    }

   return pins.replaceAll("[0-9]", "I").replace("s", " ");
  }
}