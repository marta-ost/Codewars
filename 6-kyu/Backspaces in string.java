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
    StringBuilder sb = new StringBuilder(s);
    int index = 0;
    while(sb.toString().contains("#")) {
      if (sb.charAt(index) == '#'){
        sb.deleteCharAt(index);
        if (index - 1 >= 0) {
          sb.deleteCharAt(index - 1);
          index--;
        }
      } else {
        index++;
      }
    }
    return sb.toString();
  }
}