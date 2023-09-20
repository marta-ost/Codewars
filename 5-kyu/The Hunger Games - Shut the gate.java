/*
DESCRIPTION:
Story
Old MacDingle had a farm...

...and on that farm he had

horses
chickens
rabbits
some apple trees
a vegetable patch

Everything is idylic in the MacDingle farmyard unless somebody leaves the gates open

Depending which gate was left open then...

horses might run away
horses might eat the apples
horses might eat the vegetables
chickens might run away
rabbits might run away
rabbits might eat the vegetables

Kata Task
Given the state of the farm gates in the evening, your code must return what the farm looks like the next morning when daylight reveals what the animals got up to.

Legend
H horse
C chicken
R rabbit
A apple tree
V vegetables
| gate (closed),
\ or / gate (open)
. everything else

Example
Before	```|..HH....\AAAA\CC..|AAA/VVV/RRRR|CCC```

After	```|..HH....\....\CC..|AAA/.../RRRR|...``` Because:
The horses ate whatever apples they could get to
The rabbits ate the vegetables
The chickens ran away

Notes
If the animals can eat things and also run away then they do BOTH - it is best not to run away when you are hungry!
An animal cannot "go around" a closed gate...
...but it is possible to run away from the farm and then RUN BACK and re-enter though more open gates on the other side!
*/

import java.util.*;
import java.util.stream.*;

public class Dinglemouse {
  static final String CLOSED = "|";
  static final String HORSE = "H";
  static final String CHICKEN = "C";
  static final String RABBIT = "R";
  static final String APPLES = "A";
  static final String VEGETABLES = "V";
  static final String ELSE = ".";
    
  public static String shutTheGate(final String farm) {
    String[] farmArray = farm.split("");
    String[] enclosures = divideToEnclosures(farmArray);
    String[] enclosuresReplaced = replaceAllEnclosures(enclosures);
    
    return String.join(CLOSED, enclosuresReplaced);
  }
  
  private static String[] replaceAllEnclosures(String[] enclosures) {
    String[] enclosuresReplaced = new String[enclosures.length];
    
    for (int i = 1; i < enclosures.length - 1; i++) 
      enclosuresReplaced[i] = replaceClosedEnclosure(enclosures[i]);
    
    String[] firstAndLastEnclosures = replaceOpenEnclosures(enclosures[0], enclosures[enclosures.length - 1]);
    enclosuresReplaced[0] = firstAndLastEnclosures[0];
    enclosuresReplaced[enclosuresReplaced.length - 1] = firstAndLastEnclosures[1];
    
    return enclosuresReplaced;
  }
  
  private static String replaceIfHasHorse(String enclosure, boolean closed) {
    enclosure = enclosure.replace(APPLES, ELSE).replace(VEGETABLES, ELSE);  
    if (!closed) 
      enclosure = enclosure.replace(HORSE, ELSE);
    return enclosure;
  }
  
  private static String replaceIfHasChicken(String enclosure, boolean closed) {
    if (!closed) 
      enclosure = enclosure.replace(CHICKEN, ELSE);
    return enclosure;
  }
  
  private static String replaceIfHasRabbit(String enclosure, boolean closed) {
    enclosure = enclosure.replace(VEGETABLES, ELSE);
    if (!closed) 
      enclosure = enclosure.replace(RABBIT, ELSE);
    return enclosure;
  }
  
  private static String[] replaceOpenEnclosures(String enclosure1, String enclosure2) {
    if (enclosure1.contains(HORSE) || enclosure2.contains(HORSE)) {
      enclosure1 = replaceIfHasHorse(enclosure1, false);
      enclosure2 = replaceIfHasHorse(enclosure2, false);
    } 
    
    if (enclosure1.contains(CHICKEN) || enclosure2.contains(CHICKEN)) {
      enclosure1 = replaceIfHasChicken(enclosure1, false);
      enclosure2 = replaceIfHasChicken(enclosure2, false);
    }
    
    if (enclosure1.contains(RABBIT) || enclosure2.contains(RABBIT)) {
      enclosure1 = replaceIfHasRabbit(enclosure1, false);
      enclosure2 = replaceIfHasRabbit(enclosure2, false);
    }
    
    return new String[]{enclosure1, enclosure2};
  }
  
  private static String replaceClosedEnclosure(String enclosure) {
    if (enclosure.contains(HORSE))
      enclosure = replaceIfHasHorse(enclosure, true);
    if (enclosure.contains(RABBIT))
      enclosure = replaceIfHasRabbit(enclosure, true);
    
    return enclosure;
  }
  
  private static String[] divideToEnclosures(String[] farmArray) {
    int length = (int) Arrays
      .stream(farmArray)
      .filter(c -> c.equals(CLOSED))
      .count();
    String[] enclosures = new String[length + 1];
    
    StringBuilder enclosure = new StringBuilder();
    int index = 0;
              
    if (farmArray[0].equals(CLOSED))
      enclosures[index++] = "";
    else
      enclosure.append(farmArray[0]);
    
    for (int i = 1; i < farmArray.length; i++) {
      if (farmArray[i].equals(CLOSED)) {
        enclosures[index++] = enclosure.toString();
        enclosure = new StringBuilder();
      } else {
        enclosure.append(farmArray[i]);
      }
    }
    enclosures[index++] = enclosure.toString();
    
    return enclosures;
  }
}