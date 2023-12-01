/*
DESCRIPTION:
Write function describeList which returns "empty" if the list is empty or "singleton" if it contains only one element or "longer"" if more.
*/

import java.util.*;

public class Kata {
  public static String describeList(final List list) {
    return list.isEmpty() ? "empty"
      : list.size() == 1 ? "singleton"
      : "longer";
  }
}