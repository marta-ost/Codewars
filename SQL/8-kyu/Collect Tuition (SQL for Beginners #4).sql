/*
DESCRIPTION:
You are working for a local school, and you are responsible for collecting tuition from students. You have a list of all students, some of them have already paid tution and some haven't. Write a select statement to get a list of all students who haven't paid their tuition yet. The list should include all the data available about these students.

students table schema

name (string)
age (integer)
semester (integer)
mentor (string)
tuition_received (Boolean)
NOTE: Your solution should use pure SQL. Ruby is used within the test cases just to validate your answer.

SQL for Beginners Series

This kata is part of a collection of SQL challenges for beginners. You can take the rest of the challenges here:

Adults only (SQL for Beginners #1)
On the Canadian Border (SQL for Beginners #2)
Register for the Party (SQL for Beginners #3)
Collect Tuition (SQL for Beginners #4)
Best-Selling Books (SQL for Beginners #5)
Countries Capitals for Trivia Night (SQL for Beginners #6)
*/

SELECT * 
FROM students 
WHERE tuition_received = false;