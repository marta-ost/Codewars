/*
DESCRIPTION:
Kevin is noticing his space run out! Write a function that removes the spaces from the values and returns an array showing the space decreasing.
For example, running this function on the array ['i', 'have','no','space'] would produce ['i','ihave','ihaveno','ihavenospace']
*/

public class OutOfSpace {
  public static String[] spacey(String[] array) {
    String[] withoutSpaces = new String[array.length];
    
    for (int i = 0; i < withoutSpaces.length; i++) {
      StringBuilder currentString = new StringBuilder();
      
      for (int j = 0; j <= i; j++)
        currentString.append(array[j]);
      
      withoutSpaces[i] = currentString.toString();
    }
    
    return withoutSpaces;
  }
}