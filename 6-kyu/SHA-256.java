/*
DESCRIPTION:
Create a function that converts a given ASCII string to its hexadecimal SHA-256 hash.

sha256("Hello World!") => "7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069"
*/

import java.security.MessageDigest;

public class Kata {
  public static String sha256(String s) {
    StringBuilder hexString = new StringBuilder();
    
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hash = digest.digest(s.getBytes("UTF-8"));
      
      for (int i = 0; i < hash.length; i++) {
        String hex = Integer.toHexString(0xff & hash[i]);
        if (hex.length() == 1) 
          hexString.append('0');
        hexString.append(hex);
      }
      return hexString.toString();
    } catch(Exception ex){
      throw new RuntimeException(ex);
    }
  }
}