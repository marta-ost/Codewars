/*
DESCRIPTION:
Introduction
There is a war and nobody knows - the alphabet war!
There are two groups of hostile letters. The tension between left side letters and right side letters was too high and the war began.

Task
Write a function that accepts fight string consists of only small letters and return who wins the fight. When the left side wins return Left side wins!, when the right side wins return Right side wins!, in other case return Let's fight again!.

The left side letters and their power:

 w - 4
 p - 3
 b - 2
 s - 1

The right side letters and their power:

 m - 4
 q - 3
 d - 2
 z - 1

The other letters don't have power and are only victims.

Example
AlphabetWar("z");        //=> Right side wins!
AlphabetWar("zdqmwpbs"); //=> Let's fight again!
AlphabetWar("zzzzs");    //=> Right side wins!
AlphabetWar("wwwwwwz");  //=> Left side wins!

Alphabet war Collection
Alphavet war
Alphabet war - airstrike - letters massacre
Alphabet wars - reinforces massacre
Alphabet wars - nuclear strike
Alphabet war - Wo lo loooooo priests join the war
*/

import java.util.Map;
import java.util.HashMap;

public class Kata {
  public static String alphabetWar(String fight) {
    Map<String, Integer> leftLettersWithPower = new HashMap(){{
      put("w", 4);
      put("p", 3);
      put("b", 2);
      put("s", 1);
    }};
    
    Map<String, Integer> rightLettersWithPower = new HashMap(){{
      put("m", 4);
      put("q", 3);
      put("d", 2);
      put("z", 1);
    }};
    
    String[] letters = fight.split("");
    
    int leftPower = 0;
    int rightPower = 0;
    
    for (String letter : letters) {
      if (rightLettersWithPower.containsKey(letter))
        rightPower += rightLettersWithPower.get(letter);
      if (leftLettersWithPower.containsKey(letter))
        leftPower += leftLettersWithPower.get(letter);
    }
    
    return leftPower > rightPower ? "Left side wins!"
      : rightPower > leftPower ? "Right side wins!" 
      : "Let's fight again!";
  }
}