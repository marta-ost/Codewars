/*
DESCRIPTION:
Emotional Sort ( ︶︿︶)
You'll have a function called "sortEmotions" that will return an array of emotions sorted. It has two parameters, the first parameter called "arr" will expect an array of emotions where an emotion will be one of the following:

:D -> Super Happy
:) -> Happy
:| -> Normal
:( -> Sad
T_T -> Super Sad

Example of the array:[ 'T_T', ':D', ':|', ':)', ':(' ]

And the second parameter is called "order", if this parameter is true then the order of the emotions will be descending (from Super Happy to Super Sad) if it's false then it will be ascending (from Super Sad to Super Happy)

Example if order is true with the above array: [ ':D', ':)', ':|', ':(', 'T_T' ]

Super Happy -> Happy -> Normal -> Sad -> Super Sad

If order is false: [ 'T_T', ':(', ':|', ':)', ':D' ]

Super Sad -> Sad -> Normal -> Happy -> Super Happy

Example:

arr = [':D', ':|', ':)', ':(', ':D']
sortEmotions(arr, true) // [ ':D', ':D', ':)', ':|', ':(' ]
sortEmotions(arr, false) // [ ':(', ':|', ':)', ':D', ':D' ]

More in test cases!

Notes:

The array could be empty, in that case return the same empty array ¯\_( ツ )_/¯
All emotions will be valid
Enjoy! (づ｡◕‿‿◕｡)づ
*/

import java.util.stream.*;
import java.util.Arrays;
import java.util.function.*;
import java.util.Map;

public class Solution {
  public static String[] sortEmotions(boolean order, String[] emotions) {  
    String[] emotionsRanking = getEmotionsRanking(order);
    
    Map<String, Long> emotionsWithOccurences = Arrays
      .stream(emotions)
      .collect(Collectors.groupingBy(Function.identity(),
                                    Collectors.counting()));
                                    
    String[] emotionsSorted = new String[emotions.length];
    int index = 0;
      
    for (int i = 0; i < emotionsRanking.length; i++) {
    String emotion = emotionsRanking[i];
    
      while (emotionsWithOccurences.containsKey(emotion)) {
        emotionsSorted[index++] = emotion;
        
        long newOccurences = emotionsWithOccurences.get(emotion) - 1;
        
        if (newOccurences == 0)
          emotionsWithOccurences.remove(emotion);
        else 
          emotionsWithOccurences.put(emotion, newOccurences);
      }
    }
  
    return emotionsSorted;
  }
  
  public static String[] getEmotionsRanking(boolean order) {
    return order ? new String[]{":D", ":)", ":|", ":(", "T_T"}
      : new String[]{"T_T", ":(", ":|", ":)", ":D"};
  }
}