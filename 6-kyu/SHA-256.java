/*
DESCRIPTION:
Create a function that converts a given ASCII string to its hexadecimal SHA-256 hash.

sha256("Hello World!") => "7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069"
*/

import java.nio.charset.*;
import com.google.common.hash.Hashing;

public class Kata {
  public static String sha256(String s) {
     return Hashing
       .sha256()
       .hashString(s, StandardCharsets.UTF_8)
       .toString();
  }
}