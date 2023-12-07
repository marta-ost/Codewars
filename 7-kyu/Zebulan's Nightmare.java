/*
DESCRIPTION:
Zebulan has worked hard to write all his python code in strict compliance to PEP8 rules. In this kata, you are a mischievous hacker that has set out to sabotage all his good code.

Your job is to take PEP8 compatible function names and convert them to camelCase. For example:

zebulansNightmare('camel_case') == 'camelCase'
zebulansNightmare('zebulans_nightmare') == 'zebulansNightmare'
zebulansNightmare('get_string') == 'getString'
zebulansNightmare('convert_to_uppercase') == 'convertToUppercase'
zebulansNightmare('main') == 'main'
*/

import java.util.stream.*;
import java.util.*;

public class ZebulansNightmare {
  public static String zebulansNightmare(final String functionName) {
    String[] functionWords = functionName.split("_");
    
    return IntStream
      .range(0, functionWords.length)
      .mapToObj(i -> i == 0 ? functionWords[i]
                : functionWords[i].substring(0, 1).toUpperCase() + functionWords[i].substring(1).toLowerCase())
      .collect(Collectors.joining(""));
  }
}