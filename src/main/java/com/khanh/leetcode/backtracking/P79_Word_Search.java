package com.khanh.leetcode.backtracking;

/**
 * @url https://leetcode.com/problems/word-search/
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 */

public class P79_Word_Search {

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (backtrack(board, i, j, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, int i, int j, char[] w, int index) {
        if (index == w.length) return true;
        if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != w[index]) return false;
        board[i][j] ^= 256;
        boolean exist =
                backtrack(board, i-1, j, w, index + 1) ||
                backtrack(board, i+1, j, w, index + 1) ||
                backtrack(board, i, j-1, w, index + 1) ||
                backtrack(board, i, j+1, w, index + 1);
        board[i][j] ^= 256;
        return exist;
    }

}
