/*
DESCRIPTION:
You are a robot.

As a robot, you are programmed to take walks following a path.

The path is input to you as a string of the following characters where:

"^" -> step up
"v" -> step down
">" -> step right
"<" -> step left
For example, a valid path would look like:

"^^vv>><<^v>"
However, you are a robot that cannot understand this string of characters just by looking at it. You need detailed instructions on how to follow the path.

Your objective is to write a program to translate the input path to a set of detailed and readable instructions that even a robot like you could understand.

To do this, you must translate the previous example

"^^vvvv>><<^v>"
to a "line feed separated string" equivalent to:

Take 2 steps up
Take 4 steps down
Take 2 steps right
Take 2 steps left
Take 1 step up
Take 1 step down
Take 1 step right
Notice that groups of the same characters translate to one instruction only, telling you to take multiple steps.

Notes:

The input path will NEVER contain invalid characters, only the four characters for the directions.

The instruction lines are separated only by a newline ("\n") character. This character is not present at the beginning of the first instruction line nor at the end of the last instruction line.

An empty path with no characters should output a "Paused" string meaning that you, the robot, are not supposed to move anywhere and are in a paused state.
*/

public class Solution {
  static final String UP = "^";
  static final String DOWN = "v";
  static final String RIGHT = ">";
  static final String LEFT = "<";
  
  public static String walk(String path) {
    if (path.isEmpty())
      return "Paused";
    
    StringBuilder groupedSteps = new StringBuilder();
    int currentOccurences = 1;
    
    for (int i = 0; i < path.length(); i++) {
      char currentDirection = path.charAt(i);
      if (i + 1 < path.length() && path.charAt(i) == path.charAt(i + 1)) {
        currentOccurences++;
      } else {
        groupedSteps.append(currentOccurences);
        groupedSteps.append(currentDirection);
        groupedSteps.append(" ");
        currentOccurences = 1;
        if (i + 1 < path.length())
          currentDirection = path.charAt(i + 1);
      }
    }
    String[] groups = groupedSteps.toString().trim().split(" ");
    
    StringBuilder translated = new StringBuilder();
    
    for (int i = 0; i < groups.length; i++) {
      String currentGroup = groups[i];
      
      String occurences = currentGroup.substring(0, currentGroup.length() - 1);
      translated.append("Take ").append(occurences);
      if (occurences.equals("1"))
        translated.append(" step ");
      else
        translated.append(" steps ");
      
      String direction = currentGroup.substring(currentGroup.length() - 1);
      if (direction.equals(UP))
        translated.append("up").append("\n");
      else if (direction.equals(DOWN))
        translated.append("down").append("\n");
      else if (direction.equals(LEFT))
        translated.append("left").append("\n");
      else if (direction.equals(RIGHT))
        translated.append("right").append("\n");
    }
    return translated.toString().trim();
  }
}