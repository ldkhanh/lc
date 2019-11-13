package com.khanh.leetcode.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @url https://leetcode.com/problems/word-search-ii/
 * <p>
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * board = [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * <p>
 * Output: ["eat","oath"]
 * <p>
 * <p>
 * Note:
 * <p>
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 */

public class P_212_Word_Search_II {
    // Using Trie
    // O( n * 2^n) where n is number of characters in the matrix
    //  O(n*2^n) where n is number of characters in the matrix
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, i, j, root, result);
            }
        return result;
    }

    private void backtrack(char[][] board, int i, int j, TrieNode node, List<String> res) {
        char c = board[i][j];
        if (c == '#' || node.next[c - 'a'] == null) return;
        node = node.next[c - 'a'];
        if (node.word != null) {        // found - one
            res.add(node.word);
            node.word = null;          // de-duplicate
        }
        board[i][j] = '#';
        if (i > 0) backtrack(board, i - 1, j, node, res);
        if (j > 0) backtrack(board, i, j - 1, node, res);
        if (i < board.length - 1) backtrack(board, i + 1, j, node, res);
        if (j < board[0].length - 1) backtrack(board, i, j + 1, node, res);
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                if (node.next[c - 'a'] == null) node.next[c - 'a'] = new TrieNode();
                node = node.next[c - 'a'];
            }
            node.word = w;
        }
        return root;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}
