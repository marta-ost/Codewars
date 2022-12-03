/*
DESCRIPTION:
You work at a book store. It's the end of the month, and you need to find out the 5 bestselling books at your store. Use a select statement to list names, authors, and number of copies sold of the 5 books which were sold most.

books table schema

name
author
copies_sold
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
FROM books 
ORDER BY copies_sold DESC 
LIMIT 5;