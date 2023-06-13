/*
DESCRIPTION:
Implement String#to_cents, which should parse prices expressed as $1.23 and return number of cents, or in case of bad format return nil.
*/

public class CentParser {
  public static Integer toCents(String price) {
    return price.matches("[$]+[0-9+]+[.]+[0-9]{2}") 
      ? Integer.valueOf(price.replaceAll("[^0-9]", "")) : null;
  } 
}