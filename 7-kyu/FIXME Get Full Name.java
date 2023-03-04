/*
DESCRIPTION:
The code provided is supposed return a person's Full Name given their first and last names.

But it's not working properly.

Notes
The first and/or last names are never null, but may be empty.

Task
Fix the bug so we can all go home early.
*/

public class Dinglemouse {
  private String firstName;
  private String lastName;
  
  public Dinglemouse(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  public String getFullName() { 
    return firstName.isEmpty() && lastName.isEmpty() ? "" :
    firstName.isEmpty() ? lastName : 
    lastName.isEmpty() ? firstName : 
    firstName + " " + lastName;
  }
}