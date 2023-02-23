/*
DESCRIPTION:
An orderly trail of ants is marching across the park picnic area.

It looks something like this:

..ant..ant.ant...ant.ant..ant.ant....ant..ant.ant.ant...ant..
But suddenly there is a rumour that a dropped chicken sandwich has been spotted on the ground ahead. The ants surge forward! Oh No, it's an ant stampede!!

Some of the slower ants are trampled, and their poor little ant bodies are broken up into scattered bits.

The resulting carnage looks like this:

...ant...ant..nat.ant.t..ant...ant..ant..ant.anant..t
Can you find how many ants have died?

Notes
When in doubt, assume that the scattered bits are from the same ant. e.g. 2 heads and 1 body = 2 dead ants, not 3
*/

import java.util.stream.*;
import java.util.function.Function;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class Dinglemouse {
  public static int deadAntCount(final String ants) {
    if (ants == null || ants.isEmpty())
      return 0;
    String deadAnts = ants.replace("ant", "").replaceAll("[^a^n^t]", "");
    return deadAnts.isEmpty() ? 0 : 
    Arrays.stream(deadAnts.split(""))
      .collect(Collectors.groupingBy(Function.identity(), 
                                     Collectors.counting()))
      .entrySet()
      .stream()
      .max(Comparator.comparing(Map.Entry::getValue))
      .get()
      .getValue()
      .intValue();
  }
}