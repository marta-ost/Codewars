/*
DESCRIPTION:
Task:
Your task is to write a function which returns the sum of following series upto nth term(parameter).

Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +...
Rules:
You need to round the answer to 2 decimal places and return it as String.

If the given value is 0 then it should return 0.00

You will only be given Natural Numbers as arguments.

Examples:(Input --> Output)
1 --> 1 --> "1.00"
2 --> 1 + 1/4 --> "1.25"
5 --> 1 + 1/4 + 1/7 + 1/10 + 1/13 --> "1.57"
*/

import java.util.stream.*;

public class NthSeries {
	public static String seriesSum(int n) {
		return String.format("%.2f", (float) IntStream
                         .rangeClosed(0, n * 3 - 1)
                         .filter(i -> i == 0 || i % 3 == 0)
                         .map(i -> i + 1)
                         .mapToDouble(i -> i)
                         .map(i -> 1 / i)
                         .sum());
	}
}