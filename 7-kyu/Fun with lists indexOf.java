/*
DESCRIPTION:
Implement the method indexOf (index_of in PHP), which accepts a linked list (head) and a value, and returns the index (zero based) of the first occurrence of that value if exists, or -1 otherwise.

For example: Given the list: 1 -> 2 -> 3 -> 3, and the value 3, indexOf / index_of should return 2.

The linked list is defined as follows:

class Node {
  public Object data;
  public Node next;

  Node(T data, Node next) {
    this.data = data;
    this.next = next;
  }
  
  Node(T data) {
    this(data, null);
  }
}

Note: the list may be null and can hold any type of value.

Good luck!

This kata is part of fun with lists series:

Fun with lists: length
Fun with lists: indexOf
Fun with lists: lastIndexOf
Fun with lists: countIf
Fun with lists: anyMatch + allMatch
Fun with lists: filter
Fun with lists: map
Fun with lists: reduce
*/

class Solution {
  static int indexOf(Node head, Object value) {
    int index = 0;
    while (head != null) {
      if (head.data == value)
        return index;
      head = head.next;
      index++;
    }
    return -1;
  }
}