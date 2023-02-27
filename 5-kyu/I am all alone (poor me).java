/*
DESCRIPTION:
Story
POTUS thinks he is all alone in the White House on Christmas Eve.

But is he?

The White House has a wall-penetrating radar security system that sees everything.

Kata Task
Process the radar image.

Return true if POTUS really is home alone.

Legend
# walls
X POTUS
o elves
Notes
The house corners are square only
The radar can also see into nearby buildings
Examples
ex1
   o                o        #######
 ###############             #     #
 #             #        o    #     #
 #  X          ###############     #
 #                                 #
 ###################################
All alone --> true

ex2
#################
#     o         #   o
#          ######        o
####       #                
   #       ###################
   #                         #
   #                  X      #
   ###########################
All alone --> false

ex3
############
#          #
#   o      #      ############
#          #      #          #
############      #     X    #
                  #          #
                  ############
All alone --> true
*/

public class Dinglemouse {

  public static boolean allAlone(char[][] house) {
    final char WALL = '#';
    final char ELF = 'o';
    final char POTUS = 'X';
    
    boolean potusInside = false;
    boolean elfInside = false;
    
    for (int i = 0; i < house.length; i++) {
      boolean inside = false;
      for (int j = 0; j < house[i].length - 1; j++) {
        if (house[i][j] == WALL && inside && (house[i][j + 1] != WALL || j + 1 >= house[i].length))
          inside = false;
        else if (house[i][j] == WALL && !inside && house[i][j + 1] != WALL)
          inside = true;
        else if (inside && house[i][j] == ELF)
          elfInside = true;
        else if (inside && house[i][j] == POTUS)
          potusInside = true;
        if (inside && potusInside && elfInside)
          return false;
      }
    }
    return true;
  }
}