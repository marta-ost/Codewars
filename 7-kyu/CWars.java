/*
DESCRIPTION:
Normally we have firstname, middle and the last name but there may be more than one word in a name like a South Indian one.

Similar to those kinda names we need to initialize the names.

See the pattern below:

initials('code wars') => returns C.Wars 
initials('Barack Hussain obama') => returns B.H.Obama 

Complete the function initials.

Names are separated by exactly one space in the input, without leading or trailing spaces. Names will always be lowercase, except optionally their first letter.
*/

import java.lang.*;
import java.util.stream.*;

class CWars {
  public static String initials(String name) {  
    String[] parts = name.split(" ");
    
    String lastName = parts[parts.length - 1];
    lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
    
    String firstAndMiddleNamesInitials = IntStream
      .rangeClosed(0, parts.length - 2)
      .mapToObj(i -> parts[i].substring(0, 1).toUpperCase() + ".")
      .collect(Collectors.joining(""));
    
    return firstAndMiddleNamesInitials + lastName;
  }
}