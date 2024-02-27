/*
DESCRIPTION:

In this kata, your job is to create a class Dictionary which you can add words to and their entries. Example:

>>> Dictionary d = new Dictionary();

>>> d.newEntry("Apple", "A fruit that grows on trees");

>>> System.out.println(d.look("Apple"));
A fruit that grows on trees

>>> System.out.println(d.look("Banana"));
Cant find entry for Banana

Good luck and happy coding!
*/

import java.util.*;

public class Dictionary {
  private Map<String, String> dictionary = new HashMap<>();
  
  public Dictionary() {
  }

  public void newEntry(String key, String value) {
    dictionary.put(key, value);
  }

  public String look(String key) {
    return dictionary.getOrDefault(key, "Cant find entry for " + key);
  }
}