/*
DESCRIPTION:
Your function takes two arguments:

current father's age (years)
current age of his son (years)
Сalculate how many years ago the father was twice as old as his son (or in how many years he will be twice as old). The answer is always greater or equal to 0, no matter if it was in the past or it is in the future.
*/

public class TwiceAsOld {
  public static int TwiceAsOld(int dadYears, int sonYears) {
    int searchedDadYears = dadYears - sonYears;
    int searchedSonYears = 0;
    
    for (int i = 0; i <= 130; i++) {
      if (searchedDadYears == 2 * searchedSonYears) {
        return Math.abs(dadYears - searchedDadYears);
      }
      searchedDadYears++;
      searchedSonYears++;
    }
    return 0;
  }
}