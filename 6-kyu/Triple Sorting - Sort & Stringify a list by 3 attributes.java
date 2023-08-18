/*
DESCRIPTION:
Tale University is a bit messy, and can't maintain an ordered list of their student. Tale's dean wants to print a sortet list of his students by the gpa, last name and age and post it on the walls so everybody can be impressed of his great students.

Given a list of students, sort them by (from most important to least important):

GPA (descending)
First letter of last name (ascending)
Age (ascending)

And the class Student:

class Student {
    ...
  int getGpa()
  int getAge();
  String getFullName();
}

Return the sorted result as full names string, comma separated.

For Example, given the list (name, age, gpa):

David Goodman, 23, 88
Mark Rose, 25, 82
Jane Doe, 22, 90
Jane Dane, 25, 90

sort(students) should return "Jane Doe,Jane Dane,David Goodman,Mark Rose"
*/

import java.util.*;
import java.util.stream.*;

public class TripleSorter {
  public static String sort(List<Student> students) {  
    Comparator<Student> studentsComparator = Comparator
      .comparing(Student::getGpa, 
                 (g1, g2) -> g2.compareTo(g1))
      .thenComparing(Student::getFullName, 
                 (n1, n2) -> findLastNameInitial(n1)
                    .compareTo(findLastNameInitial(n2)))
      .thenComparing(Student::getAge);
    
    return students
      .stream()
      .sorted(studentsComparator)
      .map(Student::getFullName)
      .collect(Collectors.joining(","));
  }
  
  public static String findLastNameInitial(String fullName) {
    int spaceIndex = fullName.indexOf(" ");   
    return String.valueOf(fullName.charAt(spaceIndex + 1));
  }
}
