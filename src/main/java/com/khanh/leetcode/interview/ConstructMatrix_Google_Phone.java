package com.khanh.leetcode.interview;

import java.util.Arrays;

/***
 * https://leetcode.com/discuss/interview-question/668450/Google-or-Phone-or-Construct-Matrix
 * Given total numer of rows, columns, starting position and direction, construct a matrix of the given size and fill it while moving in the given direction.
 * m -> row
 * n -> column
 * start position -> enumeration
 * moving direction -> enumeration
 *
 * m = 4, n = 4
 * start positions: TL, TR, BL, BR
 * moving direction: H, V
 * TL  .  .  TR
 * .   .  .   .
 * .   .  .   .
 * BL  .  .  BR
 *
 * Example 1:
 * Input: m = 3, n = 3, startposition = TL, moving_direction = H
 *
 * Output: return matrix[3][3]
 * 		1 -> 2 -> 3
 * 		          |
 * 		6 <- 5 <- 4
 * 		|
 * 		7 -> 8 -> 9
 *
 * Example 2:
 * Input: m = 3, n = 3, startposition = TL, moving_direction = V
 *
 * Output: return matrix[3][3]
 * 		1  6  7
 * 		2  5  8
 * 		3  4  9
 */
public class ConstructMatrix_Google_Phone{
    public static void main(String[] args) {
        StartPosition start = StartPosition.TR;
        Direction d = Direction.H;
        ConstructMatrix_Google_Phone cm = new ConstructMatrix_Google_Phone();
        cm.constructMatrix(3, 3, start, d);
        for (int[] row : cm.result)
            System.out.println(Arrays.toString(row));
    }

    enum Direction {
        H, V;
    }
    enum StartPosition {
        TL, TR, BL, BR;
    }

    int[][] result;
    int count;

    public int[][] constructMatrix(int m, int n, StartPosition start, Direction d) {
        result = new int[m][n];
        count = 1;
        int row;
        int col;
        if (d == Direction.H) {
            //move horizontally
            if (start == StartPosition.TR || start == StartPosition.TL) {
                col = start == StartPosition.TR ? n:0;
                for (int r = 0; r < m; r++)
                    col = fillHorizontally(r, col, n);
            } else {
                col = start == StartPosition.BR ? n:0;
                for (int r = m - 1; r >= 0; r--)
                    col = fillHorizontally(r, col, n);
            }
        } else {
            //move vertically
            int c = 0;
            if (start == StartPosition.TL || start == StartPosition.TR) {
                if (start == StartPosition.TR) c = n-1;
                row = 0;
                for (; c < n; c++)
                    row = fillVertically(row, c, m);
            } else {
                if (start == StartPosition.BR) c = n-1;
                row = m;
                for (; c < n; c++)
                    row = fillVertically(row, c, m);
            }
        }
        return result;
    }
    private int fillHorizontally(int row, int col, int totalCol) {
        if (col == 0 || col == -1) {
            //move right
            for (col = 0; col < totalCol; col++) {
                result[row][col] = count++;
            }
        } else if (col == totalCol) {
            //move left
            for (col = totalCol - 1; col >= 0; col--) {
                result[row][col] = count++;
            }
        }
        return col;
    }
    private int fillVertically(int row, int col, int totalRow) {
        if (row == 0 || row == -1) {
            //move down
            for (row = 0; row < totalRow; row++) {
                result[row][col] = count++;
            }
        } else if (row == totalRow) {
            //move up
            for (row = totalRow - 1; row >= 0; row--) {
                result[row][col] = count++;
            }
        }
        return row;
    }
}
