/*
DESCRIPTION:

Create the implementation for the interface below. The implementation needs to be called "MysteryColorAnalyzerImpl".

import java.util.List;

public interface MysteryColorAnalyzer {
    /**
     * This method will determine how many distinct colors are in the given list
     *
     * <p>
     * Colors are defined via the {@link Color} enum.
     * </p>
     *
     * @param mysteryColors list of colors from which to determine the number of distinct colors
     * @return number of distinct colors
     
    int numberOfDistinctColors(List<Color> mysteryColors);

    /**
     * This method will count how often a specific color is in the given list
     *
     * <p>
     * Colors are defined via the {@link Color} enum.
     * </p>
     *
     * @param mysteryColors list of colors from which to determine the count of a specific color
     * @param color color to count
     * @return number of occurrence of the color in the list
     
    int colorOccurrence(List<Color> mysteryColors, Color color);
}

Color has the following enum structure, but hey you really don't need to know all these colors if you're implementing the methods properly.

public enum Color {
    RED, GREEN, BLUE
}
*/

import java.util.List;

public class MysteryColorAnalyzerImpl implements MysteryColorAnalyzer {
  public int numberOfDistinctColors(List<Color> mysteryColors) {  
    return (int) mysteryColors
      .stream()
      .distinct()
      .count();
  }
  
  public int colorOccurrence(List<Color> mysteryColors, Color color) {
    return (int) mysteryColors
      .stream()
      .filter(c -> c.equals(color))
      .count();
  }
}