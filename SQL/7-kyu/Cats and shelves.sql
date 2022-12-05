/*
DESCRIPTION:
Description
An infinite number of shelves are arranged one above the other in a staggered fashion.
The cat can jump up to 3 shelves at the same time: from shelf 1 to shelf 2 or 4 (the cat cannot climb on the shelf directly above its head), according to the illustration:

                 ┌────────┐
                 │-6------│
                 └────────┘
┌────────┐       
│------5-│        
└────────┘  ┌─────► OK!
            │    ┌────────┐
            │    │-4------│
            │    └────────┘
┌────────┐  │
│------3-│  │     
BANG!────┘  ├─────► OK! 
  ▲  |\_/|  │    ┌────────┐
  │ ("^-^)  │    │-2------│
  │ )   (   │    └────────┘
┌─┴─┴───┴┬──┘
│------1-│
└────────┘
Input
Start and finish shelf numbers (always positive integers, finish no smaller than start)

Task
Find the minimum number of jumps to go from start to finish

Example
Start 1, finish 5, then answer is 2 (1 => 4 => 5 or 1 => 2 => 5)

Inspirers
*/

--# write your SQL statement here: 
-- you are given a table 'jumps' with columns 'a' (start) and 'b' (finish).
-- return a table with:
--   these columns and your result in a column named 'res'

SELECT
  a,
  b,
  CASE WHEN (b - a) % 3 = 0 
       THEN (b - a) / 3
       WHEN (b - a) % 3 = 1 
       THEN (b - a) / 3 + 1
       WHEN (b - a) % 3 = 2 
       THEN (b - a) / 3 + 2
       ELSE 0 END AS res
FROM jumps;