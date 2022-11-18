/*
DESCRIPTION:
Your task, is to create a NxN spiral with a given size.

For example, spiral with size 5 should look like this:

00000
....0
000.0
0...0
00000
and with the size 10:

0000000000
.........0
00000000.0
0......0.0
0.0000.0.0
0.0..0.0.0
0.0....0.0
0.000000.0
0........0
0000000000
Return value should contain array of arrays, of 0 and 1, with the first row being composed of 1s. For example for given size 5 result should be:

[[1,1,1,1,1],[0,0,0,0,1],[1,1,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Because of the edge-cases for tiny spirals, the size will be at least 5.

General rule-of-a-thumb is, that the snake made with '1' cannot touch to itself.
*/

public class Spiralizor {

    public static int[][] spiralize(int size) {
        final int ZERO = 0;
        final int ONE = 1;

        int[][] s = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                s[i][j] = ZERO;
            }
        }
        int k = 0;
        int currentI = 0;
        int currentJ = 0;

        while (k <= size / 2) {
            if (k == 0) {
                for (int j = k; j < size - k; j++) {
                    s[k][j] = ONE;
                    currentI = k;
                    currentJ = j;
                }
            }
            if (k > 0) {
                for (int j = k - 2; j < size - k; j++) {
                    s[k][j] = ONE;
                    currentI = k;
                    currentJ = j;
                }
            }
            for (int i = k; i < size - k; i++) {
                s[i][size - 1 - k] = ONE;
                currentI = i;
                currentJ = size - 1 - k;
            }
            for (int j = size - 1 - k; j >= k; j--) {
                s[size - 1 - k][j] = ONE;
                currentI = size - 1 - k;
                currentJ = j;
            }
            for (int i = size - 1 - k; i >= k + 2; i--) {
                s[i][k] = ONE;
                currentI = i;
                currentJ = k;
            }
            k += 2;
        }

        if (size % 2 == 0) {
            s[currentI][currentJ] = ZERO;
        }
        return s;
    }
}