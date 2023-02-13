/*
DESCRIPTION:
Assume "#" is like a backspace in string. This means that string "a#bc#d" actually is "bd"

Your task is to process a string with "#" symbols.

Examples
"abc#d##c"      ==>  "ac"
"abc##d######"  ==>  ""
"#######"       ==>  ""
""              ==>  ""
*/

public class BackspacesInString {
  public String cleanString(String s) {
    while (s.matches(".*#.*")) 
      s = s.replaceFirst(".?#", "");
    return s;
  }
}