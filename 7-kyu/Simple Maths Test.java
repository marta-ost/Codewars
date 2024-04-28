/*
DESCRIPTION:
Create a function which checks a number for three different properties.

is the number prime?
is the number even?
is the number a multiple of 10?

Each should return either true or false, which should be given as an array. Remark: The Haskell variant uses data Property.

Examples

SimpleMath.numberProperty(7)  => new boolean[] {true, false, false}
SimpleMath.numberProperty(10) => new boolean[] {false, true, true}

The number will always be an integer, either positive or negative. Note that negative numbers cannot be primes, but they can be multiples of 10:

SimpleMath.numberProperty(-7)  => new boolean[] {false, false, false}
SimpleMath.numberProperty(-10) => new boolean[] {false, true, true}
*/

public class SimpleMath {
  public static boolean[] numberProperty(int n) {
    boolean isPrime = checkIfNumberIsPrime(n);
    boolean isEven = n % 2 == 0;
    boolean isMultipleOf10 = n % 10 == 0;
    
    return new boolean[]{isPrime, isEven, isMultipleOf10};
  }
  
  private static boolean checkIfNumberIsPrime(int n) {
    if (n == 2 || n == 3)
      return true;
    if (n <= 1 || n % 2 == 0 || n % 3 == 0)
      return false;
    for (int i = 5; i <= Math.sqrt(n); i += 6) {
      if (n % i == 0 || n % (i + 2) == 0)
        return false;
    } 
    return true;
  }
}