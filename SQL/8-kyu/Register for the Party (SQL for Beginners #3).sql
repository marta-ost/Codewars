/*
DESCRIPTION:
You received an invitation to an amazing party. Now you need to write an insert statement to add yourself to the table of participants.

participants table schema

name (string)
age (integer)
attending (boolean)
NOTES:

Since alcohol will be served, you can only attend if you are 21 or older
You can't attend if the attending column returns anything but true
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

INSERT INTO participants (name, age, attending) VALUES ('Marta', 27, true);

SELECT * FROM participants;