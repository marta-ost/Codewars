/*
DESCRIPTION:
Given a month as an integer from 1 to 12, return to which quarter of the year it belongs as an integer number.

For example: month 2 (February), is part of the first quarter; month 6 (June), is part of the second quarter; and month 11 (November), is part of the fourth quarter.
*/

public class Kata {
  public static int quarterOf(int month) {
    return switch((month - 1) / 3) {
        case 0 -> 1;
        case 1 -> 2;
        case 2 -> 3;
        case 3 -> 4;
        default -> 0;
    };
  }
}