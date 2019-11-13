package com.khanh.leetcode.breathFirstSearch;

import java.util.Arrays;
import java.util.List;

/**
 * @url https://leetcode.com/problems/walls-and-gates/
 *
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * Example:
 *
 * Given the 2D grid:
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * After running your function, the 2D grid should be:
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 */
public class P286_Walls_and_Gates {

    private static final List<int[]> DIRECTION = Arrays.asList(
            new int[]{-1, 0},
            new int[]{ 1, 0},
            new int[]{ 0,-1},
            new int[]{ 0, 1}
    );
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (rooms[i][j] == 0)
                    dfs(rooms, i , j , 0);

    }
    private void dfs(int[][] rooms, int r, int c, int depth) {
        int m = rooms.length, n = rooms[0].length;
        if ( r < 0 || r >= m || c < 0 || c >= n ) return;
        if (depth == 0 || rooms[r][c] > depth) {
            rooms[r][c] = depth;
            for (int[] dir : DIRECTION)
                dfs(rooms, r + dir[0], c + dir[1], depth + 1);
        }
    }
}
