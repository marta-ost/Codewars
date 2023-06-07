/*
DESCRIPTION:
Description
You are required to implement a function find_nth_occurrence that returns the index of the nth occurrence of a substring within a string (considering that those substring could overlap each others). If there are less than n occurrences of the substring, return -1.

Example

String string = "This is an example. Return the nth occurrence of example in this example string.";
findNthOccurrence("example", string, 1) == 11
findNthOccurrence("example", string, 2) == 49
findNthOccurrence("example", string, 3) == 65
findNthOccurrence("example", string, 4) == -1

Multiple occurrences of a substring are allowed to overlap, e.g.

findNthOccurrence("TestTest", "TestTestTestTest", 1) == 0
findNthOccurrence("TestTest", "TestTestTestTest", 2) == 4
findNthOccurrence("TestTest", "TestTestTestTest", 3) == 8
findNthOccurrence("TestTest", "TestTestTestTest", 4) == -1
*/

public class FindOccurrence {
  public static int findNthOccurrence(String subStr, String str, int occurrence) { 
    int index = 0;
    
    for (int i = 0; i < occurrence; i++) {
      index = str.indexOf(subStr, i == 0 ? index : index + 1);
      if (index == -1)
        return -1;
    }

    return index;
  }
}
