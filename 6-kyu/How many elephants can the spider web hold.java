/*
DESCRIPTION:
How many elephants can the spider web hold?

Imagine a spider web that is defined by two variables:

strength, measured as the weight in kilograms that surely breaks the web
length, measured as the number of elephants that fit one after the other on the web :)

Paraphrasing the song "One elephant went out to play", how many elephants will the web hold if we put them one after the other, without breaking?

You must take into account two things:

elephants like to create super high pyramids, so, on each level of the structure fits one elephant less than in the previous one.
elephants sitting on the first row weight 1000 kg, the ones sitting on the second row weight 2000 kg, and so on. When rows are full of elephants, next elephants go up one level, and weight 1000 kg more than the previous ones.

Have fun!

Notes:

check all the possible values for the input parameters, even absurd ones :D
*/

public class SpiderWeb {
  private int strength;
  private int width;
  
  public SpiderWeb (int strength, int width) {
    this.strength = strength;
    this.width = width;
  }
  
  public int getElephantToleranceNumber() {
    int strengthInRow = 1000;
    int finalStrength = 0;
    int numberOfElephants = 0;
    
    for (int rowWidth = width; rowWidth > 0; rowWidth--) {
      for (int elephantsInRow = 1; elephantsInRow <= rowWidth; elephantsInRow++) {
        finalStrength += strengthInRow;
        numberOfElephants++;
        
        if (finalStrength > strength)
          return numberOfElephants - 1;
      }
      strengthInRow += 1000;
    }
    
    return numberOfElephants;
  }
} 