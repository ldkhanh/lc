package com.khanh.leetcode.unionFind;

/**
 * @url https://leetcode.com/problems/number-of-islands/
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */

public class P200_Number_of_Islands {

    /**
     * Union Find Time : O(m*n*log(m*n))
     * DFS Time O(m*n)
     */

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        UF uf = new UF(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') uf.union(i * n + j, (i - 1) * n + j);
                    if (i + 1 < m && grid[i + 1][j] == '1') uf.union(i * n + j, (i + 1) * n + j);
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') uf.union(i * n + j, i * n + j - 1);
                    if (j + 1 < n && grid[i][j + 1] == '1') uf.union(i * n + j, i * n + j + 1);
                }
            }
        }
        return uf.numI();
    }
}

class UF {
    int[] parent;
    int[] rank;
    int island;

    public UF(char[][] g) {
        int m = g.length, n = g[0].length;
        parent = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '1') {
                    parent[i * n + j] = i * n + j;
                    island++;
                }
            }
    }

    public int find(int x) {        // path compression
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {       // weight union by rank
        int xr = find(x), yr = find(y);
        if (xr != yr) {
            if (rank[xr] < rank[yr])
                parent[xr] = yr;
            else if (rank[yr] < rank[xr])
                parent[yr] = xr;
            else {
                parent[yr] = xr;
                rank[xr]++;
            }
            island--;
        }
    }

    public int numI() {
        return island;
    }
}

    /*
    //DFS
    public int numIslands(char[][] grid) {
        int m = grid.length, n = (m == 0)? 0 : grid[0].length;
        if (m == 0) return 0;
        int island = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '1') continue;
                island++;
                dfs(grid, i, j);
            }
        }
        return island;
    }
    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i-1][j] == '1') dfs(grid, i - 1, j);
        if (i + 1 < grid.length && grid[i+1][j] == '1') dfs(grid, i + 1, j);
        if (j - 1 >= 0 && grid[i][j - 1] == '1') dfs(grid, i , j - 1);
        if (j + 1 < grid[0].length && grid[i][j+1] == '1') dfs(grid, i , j + 1);
    }

     */
