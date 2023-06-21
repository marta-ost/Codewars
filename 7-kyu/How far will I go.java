/*
DESCRIPTION:
You have recently discovered that horses travel in a unique pattern - they're either running (at top speed) or resting (standing still).

Here's an example of how one particular horse might travel:

The horse Blaze can run at 14 metres/second for 60 seconds, but must then rest for 45 seconds.

After 500 seconds Blaze will have traveled 4200 metres.

Your job is to write a function that returns how far a horse will have traveled after a given time.

####Input:

totalTime - How long the horse will be traveling (in seconds)

runTime - How long the horse can run for before having to rest (in seconds)

restTime - How long the horse have to rest for after running (in seconds)

speed - The max speed of the horse (in metres/second)
*/

public class Kata {
  public static int travel(int totalTime, int runTime, int restTime, int speed) {
    int fullRounds = totalTime / (runTime + restTime);
    int remainingTime = totalTime % (runTime + restTime);
    
    if (remainingTime >= runTime) 
      remainingTime = runTime;

    return fullRounds * calculateDistanceAfterGivenTime(speed, runTime) 
      + calculateDistanceAfterGivenTime(speed, remainingTime);
  }
  
  private static int calculateDistanceAfterGivenTime(int speed, int seconds) {
    return speed * seconds;
  }
}