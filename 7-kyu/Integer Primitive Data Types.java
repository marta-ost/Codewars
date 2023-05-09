/*
DESCRIPTION:
Java supports different integer primitive data types. Each type has an individual range:

byte: 8-bit signed two's complement integer
short: 16-bit signed two's complement integer
int: 32-bit signed two's complement integer
long: 64-bit signed two's complement integer

We have got a huge list of integer-strings and we want to categorize all of them. Find the smallest possible data type of the enumeration for a given integer.

To solve it, complete the following method:

determineType(x)

input: string
output: your chosen primitive type
all inputs are valid
return "none" if no type fits
*/

import java.math.*;

public class Primitive {
  public String determineType(String number) {
    String type = "";
    
    try { 
      Long.parseLong(number); 
      type = "long";
    } catch(NumberFormatException e) { 
    }
    
    try { 
      Integer.parseInt(number); 
      type = "int";
    } catch(NumberFormatException e) { 
    } 
    
    try { 
      Short.parseShort(number); 
      type = "short";
    } catch(NumberFormatException e) { 
    } 
    
    try { 
      Byte.parseByte(number); 
      type = "byte";
    } catch(NumberFormatException e) { 
    } 
    
    return type.isEmpty() ? "none" : type;
  }
}