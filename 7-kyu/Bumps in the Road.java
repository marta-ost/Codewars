/*
DESCRIPTION:

Your car is old, it breaks easily. The shock absorbers are gone and you think it can handle about 15 more bumps before it dies totally.

Unfortunately for you, your drive is very bumpy! Given a string showing either flat road (_) or bumps (n). If you are able to reach home safely by encountering 15 bumps or less, return Woohoo!, otherwise return Car Dead
*/

public class BumpsTheRoad {
  static final String FLAT_ROAD = "_";
  static final int SAFE_NUMBER_OF_BUMPS = 15;
  static final String SUCCESS = "Woohoo!";
  static final String FAILURE = "Car Dead";
  
  public static String bumps(final String road) {
    return findNumberOfBumps(road) <= SAFE_NUMBER_OF_BUMPS ? SUCCESS : FAILURE;
  }
  
  private static int findNumberOfBumps(String road) {
    return road.replace(FLAT_ROAD, "").length();
  }
}