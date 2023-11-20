/*
DESCRIPTION:
You are given a node that is the beginning of a linked list. This list contains a dangling piece and a loop. Your objective is to determine the length of the loop.

For example in the following picture the size of the dangling piece is 3 and the loop size is 12:

image

// Use the `getNext()` method to get the following node.
node.getNext()

Notes:

do NOT mutate the nodes!
in some cases there may be only a loop, with no dangling piece

Thanks to shadchnev, I broke all of the methods from the Hash class.

Don't miss dmitry's article in the discussion after you pass the Kata !! 
*/

import java.util.*;

public class LoopInspector {
  public int loopSize(Node node) {
    List<Node> nodes = new ArrayList<>();
    Node currentNode = node;
    
    while (!nodes.contains(currentNode)) {
      nodes.add(currentNode);
      currentNode = currentNode.getNext();
    }
    
    return nodes.size() - nodes.indexOf(currentNode);
  }
}