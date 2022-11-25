/*
DESCRIPTION:
You are a border guard sitting on the Canadian border. You were given a list of travelers who have arrived at your gate today. You know that American, Mexican, and Canadian citizens don't need visas, so they can just continue their trips. You don't need to check their passports for visas! You only need to check the passports of citizens of all other countries!

Select names, and countries of origin of all the travelers, excluding anyone from Canada, Mexico, or The US.

travelers table schema

name
country
NOTE: The United States is written as 'USA' in the table.

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

SELECT name, country FROM travelers WHERE country != 'USA' AND country != 'Canada' AND country != 'Mexico';