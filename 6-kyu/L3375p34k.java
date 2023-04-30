/*
DESCRIPTION:
General Objective
The objective of this Kata is to provide some way to encode a string into its leetspeak version.

Specific Instructions
The code must contain a Leetspeak class inherited from an Encoder abstract class and containing an encode(String) method returning itself the encoded String.

The encode method should return an empty String if a null parameter is passed.

If any uppercase character is given, it should be compared also with the dictionary, 'a' gives '4' but 'A' gives also '4'.

If any character outside the dictionary is given, it should be output as is.

Dictionary to reproduce
The following dictionary has to be used :

a -> 4
e -> 3
l -> 1
m -> /^^\
o -> 0
u -> (_)
*/

public class Leetspeak extends Encoder{
  public String encode(String source) {
    return source == null ? "" 
      : source
      .replaceAll("[Aa]", "4")
      .replaceAll("[Ee]", "3")
      .replaceAll("[Ll]", "1")
      .replaceAll("[Mm]", "/^^\\\\")
      .replaceAll("[Oo]", "0")
      .replaceAll("[Uu]", "(_)");
  }
}

abstract class Encoder {
  public abstract String encode(String source);
}