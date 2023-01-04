/*
DESCRIPTION:
Your colleagues have been looking over you shoulder. When you should have been doing your boring real job, you've been using the work computers to smash in endless hours of codewars.

In a team meeting, a terrible, awful person declares to the group that you aren't working. You're in trouble. You quickly have to gauge the feeling in the room to decide whether or not you should gather your things and leave.

Given a Person array (meet) containing team members, you need to assess the overall happiness rating of the group. If <= 5, return "Get Out Now!". Else return "Nice Work Champ!".

The Person class looks like:

class Person {
  final String name;    // team memnber's name
  final int happiness;  // happiness rating out of 10
}
Happiness rating will be total score / number of people in the room.

Note that your boss is in the room (boss), their score is worth double it's face value (but they are still just one person!).

The Office II - Boredom Score
The Office III - Broken Photocopier
The Office IV - Find a Meeting Room
The Office V - Find a Chair
*/

public class TheOffice {
  public static String outed(Person[] meet, String boss) {
    double happinessTotal = 0;
    for (int i = 0; i < meet.length; i++) {
      happinessTotal += meet[i].name.equals(boss)
        ? 2 * meet[i].happiness
        : meet[i].happiness;
    }
    double score = happinessTotal / meet.length;
    return score <= 5.0
      ? "Get Out Now!"
      : "Nice Work Champ!";
  }
}