/*
DESCRIPTION:

Introduction

There is a war and nobody knows - the alphabet war!
The letters hide in their nuclear shelters. The nuclear strikes hit the battlefield and killed a lot of them.

Task

Write a function that accepts battlefield string and returns letters that survived the nuclear strike.

The battlefield string consists of only small letters, #,[ and ].
The nuclear shelter is represented by square brackets []. The letters inside the square brackets represent letters inside the shelter.
The # means a place where nuclear strike hit the battlefield. If there is at least one # on the battlefield, all letters outside of shelter die. When there is no any # on the battlefield, all letters survive (but do not expect such scenario too often ;-P ).
The shelters have some durability. When 2 or more # hit close to the shelter, the shelter is destroyed and all letters inside evaporate. The 'close to the shelter' means on the ground between the shelter and the next shelter (or beginning/end of battlefield). The below samples make it clear for you.

Example

abde[fgh]ijk     => "abdefghijk"  (all letters survive because there is no # )
ab#de[fgh]ijk    => "fgh" (all letters outside die because there is a # )
ab#de[fgh]ij#k   => ""  (all letters dies, there are 2 # close to the shellter )
##abde[fgh]ijk   => ""  (all letters dies, there are 2 # close to the shellter )
##abde[fgh]ijk[mn]op => "mn" (letters from the second shelter survive, there is no # close)
#ab#de[fgh]ijk[mn]op => "mn" (letters from the second shelter survive, there is no # close)
#abde[fgh]i#jk[mn]op => "mn" (letters from the second shelter survive, there is only 1 # close)
[a]#[b]#[c]  => "ac"
[a]#b#[c][d] => "d"
[a][b][c]    => "abc"
##a[a]b[c]#  => "c"

Alphabet war Collection

Alphavet war
Alphabet war - airstrike - letters massacre
Alphabet wars - reinforces massacre
Alphabet wars - nuclear strike
Alphabet war - Wo lo loooooo priests join the war
*/

import java.util.*;
import java.util.stream.*;

public class AlphabetNuclearWar {
  static String STRIKE = "#";
  
  public static String alphabetWar(String battlefield) {
    String[] parts = convertBattlefieldToArray(battlefield);
    
    if (battlefield.contains(STRIKE)) {
      parts = killAllOutside(parts);
      parts = killInShelters(parts);
    }
    
    return formatResult(parts);
  }
  
  private static String formatResult(String[] parts) {
    return Arrays.stream(parts)
      .map(string -> string.replace("[", "").replace("]", "").replace(STRIKE, ""))
      .collect(Collectors.joining(""));
  }
  
  private static String[] killInShelters(String[] parts) {
    String[] partsAfter = new String[parts.length];
    
    for (int i = 0; i < parts.length; i++) {
      StringBuilder partsCloseSB = new StringBuilder();
      if (i - 1 >= 0) partsCloseSB.append(parts[i - 1]);
      partsCloseSB.append(parts[i]);
      if (i + 1 < parts.length) partsCloseSB.append(parts[i + 1]);
      String partsClose = partsCloseSB.toString();
      
      int strikes = partsClose.length() - partsClose.replace(STRIKE, "").length();
      partsAfter[i] = strikes >= 2 ? parts[i].replaceAll("[a-z]", "") : parts[i];
    }

    return partsAfter;
  }
  
  private static String[] killAllOutside(String[] parts) {
    return Arrays.stream(parts)
      .map(part -> !part.contains("[") ? part.replaceAll("[a-z]", "") : part)
      .toArray(String[]::new);
  }
  
  private static String[] convertBattlefieldToArray(String battlefield) {
    return battlefield.replace("[", " [").replace("]", "] ").trim().split(" ");
  }
}