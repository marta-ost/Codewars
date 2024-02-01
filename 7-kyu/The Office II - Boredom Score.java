/*
DESCRIPTION:

Every now and then people in the office moves teams or departments. Depending what people are doing with their time they can become more or less boring. Time to assess the current team.

You will be provided with an array of Person objects with each instance containing the name and department for a staff member.

public class Person {
  public final String name;        // name of the staff member
  public final String department;  // department they work in
}

Each department has a different boredom assessment score, as follows:

accounts = 1
finance = 2
canteen = 10
regulation = 3
trading = 6
change = 6
IS = 8
retail = 5
cleaning = 4
pissing about = 25

Depending on the cumulative score of the team, return the appropriate sentiment:

<=80: 'kill me now'
< 100 & > 80: 'i can handle this'
100 or over: 'party time!!'

The Office I - Outed
The Office III - Broken Photocopier
The Office IV - Find a Meeting Room
The Office V - Find a Chair
*/

import java.util.*;

public class TheOffice {
  private static String SENTIMENT_BELOW_EQUAL_80 = "kill me now";
  private static String SENTIMENT_ABOVE_80_BELOW_100 = "i can handle this";
  private static String SENTIMENT_ABOVE_EQUAL_100 = "party time!!";
  
  private static Map<String, Integer> departmentsWithScores = new HashMap<>(){{
    put("accounts", 1);
    put("finance", 2);
    put("canteen", 10);
    put("regulation", 3);
    put("trading", 6);
    put("change", 6);
    put("IS", 8);
    put("retail", 5);
    put("cleaning", 4);
    put("pissing about", 25);
  }};
  
  public static String boredom(Person[] team) {
    int teamScore = calculateTeamScore(team);
    
    return teamScore <= 80 ? SENTIMENT_BELOW_EQUAL_80
      : teamScore < 100 ? SENTIMENT_ABOVE_80_BELOW_100
      : SENTIMENT_ABOVE_EQUAL_100;
  }
  
  private static int calculateTeamScore(Person[] team) {
    return Arrays
      .stream(team)
      .mapToInt(person -> departmentsWithScores.get(person.department))
      .sum();
  }
}