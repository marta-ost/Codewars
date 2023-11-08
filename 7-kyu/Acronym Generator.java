/*
DESCRIPTION:
In nearly every company each employee has a certain acronym containing the first characters of his first and last name(s).

Your task is to write an acronym generator which generates an acronym for a given name. You don't have to care about duplicate acronyms (someone else will do this for you). Note that names can be given in upper or in lower case. The acronym shall always be upper case.

Normally the acronym is always the first letter of your first and the first letter of the last name in upper case.

For example:

Thomas Meyer => TM

martin schmidt => MS

In your company there work only people with a maximum of two first names. If a person has two first names, they might be joined with a dash.

Jan-Erich Schmidt => JES Jan Erich Mueller => JEM

Last names may also be joined with a dash. No one can have more than two last names.

Paul Meyer-Schmidt

In Germany, there are last names which have the leading word "von". This shall be abbreviated with a lower case "v":

Paul von Lahnstein => PvL

Martin von Lahnstein-Meyer => MvLM

Happy coding!
*/

import java.util.Arrays;
import java.util.stream.Collectors;

public class AcronymGenerator {
  public static String createAcronym(String lastName, String firstName) {
    String names = (firstName + " " + lastName).replace("-", " ");

    return Arrays
      .stream(names.split(" "))
      .map(part -> part.equalsIgnoreCase("von") ? part.toLowerCase() : part.toUpperCase())
      .map(part -> part.substring(0, 1))
      .collect(Collectors.joining(""));
  }
}