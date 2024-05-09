/*
DESCRIPTION:
Magpies are my favourite birds
Baby ones even more so...

It is a little known fact^ that the black & white colours of baby magpies differ by at least one place and at most two places from the colours of the mother magpie.

So now you can work out if any two magpies may be related.

...and Quardle oodle ardle wardle doodle the magpies said

Kata Task
Given the colours of two magpies, determine if one is a possible child or grand-child of the other.

Notes
Each pair of birds being compared will have same number of colour areas
B = Black
W = White

Example
Given these three magpies

Magpie 1  BWBWBW
Magpie 2  BWBWBB
Magpie 3  WWWWBB

You can see:

Magpie 2 may be a child of Magpie 1 because there is only one difference
Magpie 3 may be child of Magpie 2 because there are two differences
So Magpie 3 may be a grand-child of Magpie 1
On the other hand, Magpie 3 cannot be a child of Magpie 1 because there are three differences

DM :-)

^ This fact is little known because I just made it up
*/

public class Dinglemouse {
  public static boolean child(final String bird1, final String bird2) {
    int differences = getDifferences(bird1, bird2);
    return differences >= 1 && differences <= 2;
  }
  
  public static boolean grandchild(final String bird1, final String bird2) {
    int differences = getDifferences(bird1, bird2);
    return bird1.length() == 1 ? differences == 0 : differences >= 0 && differences <= 4;
  }
  
  private static int getDifferences(String bird1, String bird2) {
    String[] letters1 = bird1.split("");
    String[] letters2 = bird2.split("");
    
    int differences = 0;
    for (int i = 0; i < letters1.length; i++)
      if (!letters1[i].equals(letters2[i]))
        differences++;
    return differences;
  }
}