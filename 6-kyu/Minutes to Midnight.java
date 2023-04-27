/*
DESCRIPTION:
Teemo is not really excited about the new year's eve, but he has to celebrate it with his friends anyway.

He has a really big passion about programming and he wants to be productive till midnight. He wants to know how many minutes he has left to work on his new project.
He doesn't want to look on the clock all the time, so he thought about a function, which returns him the number of minutes.

Can you write him a function, so he can stay productive?

The function minutesToMidnight(d) will take a date object as parameter. Return the number of minutes in the following format:

"x minute(s)"

You will always get a date object with of today with a random timestamp.
You have to round the number of minutes.
Milliseconds doesn't matter!

Some examples:

10.00 am => "840 minutes"

23.59 pm => "1 minute"

This kata is part of the Collection "Date fundamentals":
#1 Count the Days!
#2 Minutes to Midnight
#3 Can Santa save Christmas?
#4 Christmas Present Calculator
*/

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Minute {
  public String countMinutes(Date d) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String date = dateFormat.format(d);
    String time = date.substring(11);
    
    int seconds = Integer.parseInt(time.substring(6));
      
    int minutes = Integer.parseInt(time.substring(3, 5));
    if (seconds > 0)
      minutes++;
    
    int hours = Integer.parseInt(time.substring(0, 2));
    if (minutes == 60) {
      hours++;
      minutes = 0;
    }
    
    int remainingMinutes = 0;
    
    if (hours != 24 && minutes != 0)
      remainingMinutes = (24 - hours - 1) * 60 + 60 - minutes;
    else if (hours != 24 && minutes == 0)
      remainingMinutes = (24 - hours) * 60;
    
    return remainingMinutes == 1 ? remainingMinutes + " minute"
      : remainingMinutes + " minutes";
  }
}