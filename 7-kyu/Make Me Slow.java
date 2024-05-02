/*
DESCRIPTION:
Make me slow! Calling makeMeSlow() should take at least 7 seconds.
*/

public class Kata {
  public static void makeMeSlow() {
    try {
      Thread.sleep(8000);
    } catch (InterruptedException e) {
    }
  }
}