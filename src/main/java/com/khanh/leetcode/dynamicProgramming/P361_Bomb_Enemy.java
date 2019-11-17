package com.khanh.leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * @url https://leetcode.com/problems/bomb-enemy/
 *
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * Note: You can only put the bomb at an empty cell.
 *
 * Example:
 *
 * Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
 * Output: 3
 * Explanation: For the given grid,
 *
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 *
 * Placing a bomb at (1,1) kills 3 enemies.
 *
 */

public class P361_Bomb_Enemy {

    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        int[] colS = new int[col];          // number of enemies by column
        int[][] memo = new int[row][col];

        // Start from left side to right side
        for (int i = 0; i < row; i++) {
            int enemies = 0;        // number of enemies by row from left side
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'E') {
                    colS[j]++;
                    enemies++;
                } else if (grid[i][j] == '0') {
                    memo[i][j] += enemies + colS[j];
                } else if (grid[i][j] == 'W') {
                    enemies = 0;
                    colS[j] = 0;
                }
            }
        }
        int result = 0;
        Arrays.fill(colS, 0);
        // Run from right to left
        for (int i = row - 1; i >= 0; i--) {
            int enemies = 0;    // number of enemies by row from right side
            for (int j = col - 1; j >= 0; j--) {
                if (grid[i][j] == 'E') {
                    enemies++;
                    colS[j]++;
                } else if (grid[i][j] == '0') {
                    memo[i][j] += enemies + colS[j];
                    result = Math.max(result, memo[i][j]);
                } else if (grid[i][j] == 'W') {
                    enemies = 0;
                    colS[j] = 0;
                }
            }
        }
        return result;
    }
}
