/*
DESCRIPTION:
(see Part 3

Java 8 has introduced a sexy new Stream API which makes it possible to solve some data related problems in just a few lines of code. Let's try it out!

You have a Student class (see the class declaration below).

You have an array of students and you want to get some aggregate data.

THE TASK: get the number of students by a gender for each department. (i.e. "CS" department has 2 males, 3 females, "Economics" department has 4 males, 5 females, etc.)

Implement the method using Java 8 Stream API.

Have Fun!

Student class declaration:

public class Student {
    private String name;
    private double grade;
    private String department;
    private Gender gender;

    public static final double PASSING_GRADE = 70.0;

    public enum Gender {
        MALE, FEMALE
    }

    public Student(String name, double grade, String department, Gender gender) {
        this.name = name;
        this.grade = grade;
        this.department = department;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
*/

import java.util.stream.*;
import java.util.*;

public class AggregationKata {
  public static Map<String, Map<Student.Gender, Long>> getTheNumberOfStudentsByGenderForEachDepartment(Stream<Student> students) {
    return students
      .collect(Collectors.groupingBy(Student::getDepartment,
                                     Collectors.groupingBy(Student::getGender,
                                                           Collectors.counting())));
  }
}