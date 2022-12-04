/*
DESCRIPTION:
Given a string of digits, you should replace any digit below 5 with '0' and any digit 5 and above with '1'. Return the resulting string.

Note: input will never be an empty string
*/

-- # write your SQL statement here: you are given a table 'fakebin' with column 'x', return a table with column 'x' and your result in a column named 'res'.
SELECT 
  x,
  REGEXP_REPLACE(REGEXP_REPLACE(x, '[0-4]', '0', 'g'), '[5-9]', '1', 'g') AS res
FROM fakebin;