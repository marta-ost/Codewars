/*
DESCRIPTION:
Create function fib that returns n'th element of Fibonacci sequence (classic programming task).
*/

public class Fibonacci {
  public static long fib (int n) {
	return (long) (1 / Math.sqrt(5) * (Math.pow((1 + Math.sqrt(5)) / 2, n) - Math.pow((1 - Math.sqrt(5)) / 2, n)));
  }
}