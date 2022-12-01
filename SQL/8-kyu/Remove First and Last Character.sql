/*
DESCRIPTION:
It's pretty straightforward. Your goal is to create a function that removes the first and last characters of a string. You're given one parameter, the original string. You don't have to worry with strings with less than two characters.
*/

-- # write your SQL statement here: you are given a table 'removechar' with column 's', return a table with column 's' and your result in a column named 'res'.
SELECT 
  s,
  CASE WHEN LENGTH(s) >= 2
       THEN SUBSTR(s, 2, LENGTH(s) - 2)
       ELSE s END AS res
FROM removechar;