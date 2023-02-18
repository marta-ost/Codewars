/*
DESCRIPTION:
You have to build a pyramid.

This pyramid should be built from characters from a given string.

You have to create the code for these four methods:

public static String watchPyramidFromTheSide(String characters)

public static String watchPyramidFromAbove(String characters)

public static int countVisibleCharactersOfThePyramid(String characters)

public static int countAllCharactersOfThePyramid(String characters)
The first method ("FromTheSide") shows the pyramid as you would see from the side.
The second method ("FromAbove") shows the pyramid as you would see from above.
The third method ("CountVisibleCharacters") should return the count of all characters, that are visible from outside the pyramid.
The forth method ("CountAllCharacters") should count all characters of the pyramid. Consider that the pyramid is completely solid and has no holes or rooms in it.

Every character will be used for building one layer of the pyramid. So the length of the given string will be the height of the pyramid. Every layer will be built with stones from the given character. There is no limit of stones.
The pyramid should have perfect angles of 45 degrees.


Example: Given string: "abc"

Pyramid from the side:

  c
 bbb
aaaaa
Pyramid from above:

aaaaa
abbba
abcba
abbba
aaaaa
Count of visible stones/characters:

25
Count of all used stones/characters:

35

There is no meaning in the order or the choice of the characters. It should work the same for example "aaaaa" or "54321".
Hint: Your output for the side must always be a rectangle! So spaces at the end of a line must not be deleted or trimmed!
If the string is null or empty, you should exactly return this value for the watch-methods and -1 for the count-methods.

Have fun coding it and please don't forget to vote and rank this kata! :-)
I have created other katas. Have a look if you like coding and challenges.
*/

public class Pyramid {
  public static String watchPyramidFromTheSide(String characters) {
    if (characters == null)
      return null;
    if (characters.isEmpty())
      return "";
    
    String[] letters = characters.split("");
    int spacesCount = letters.length - 1;
    int lettersCount = 1;
    StringBuilder pyramid = new StringBuilder();
    
    for (int index = letters.length - 1; index >= 0; index--) {
      pyramid.append(" ".repeat(spacesCount))
        .append(letters[index].repeat(lettersCount))
        .append(" ".repeat(spacesCount))
        .append("\n");
      lettersCount += 2;
      spacesCount--;
    }
    return pyramid.substring(0, pyramid.length() - 1);
  }

  public static String watchPyramidFromAbove(String characters) {
    if (characters == null)
      return null;
    if (characters.isEmpty())
      return "";
    
    String[] letters = characters.split("");
    int lettersLength = characters.length();
    int height = 2 * lettersLength - 1;
    String[][] view = new String[height][height];
    int margin = 0;
    
    for (int i = 0; i < view.length; i++) {
      for (int j = 0 + margin; j < view[i].length - margin; j++) {
        view[i][j] = letters[margin];
        view[j][i] = letters[margin];
      }
      margin++;
      if (margin == height / 2 + 1)
        break;
    }
    margin = 0;
    for (int i = view.length - 1; i >= 0; i--) {
      for (int j = 0 + margin; j < view[i].length - margin; j++) {
        view[i][j] = letters[margin];
        view[j][i] = letters[margin];
      }
      margin++;
      if (margin == height / 2 + 1)
        break;
    }
    
    StringBuilder pyramid = new StringBuilder();
    for (int i = 0; i < view.length; i++) {
      pyramid.append("\n");
      for (int j = 0; j < view[i].length; j++) {
        pyramid.append(view[i][j]);
      }
    }
    return pyramid.toString().substring(1);
  }
  
  public static int countVisibleCharactersOfThePyramid(String characters) {
    if (characters == null || characters.isEmpty())
      return -1;

    return (int) Math.pow(2 * characters.length() - 1, 2);
  }

  public static int countAllCharactersOfThePyramid(String characters){
    if (characters == null || characters.isEmpty())
      return -1;
    
    int sum = 0;
    int lettersLength = characters.length();
    for (int i = lettersLength; i >= 1; i--) {
      sum += (int) Math.pow(2 * lettersLength - 1, 2);
      lettersLength--;
    }
    return sum;
  }
}