package com.khanh.leetcode.array;

/**
 * @url https://leetcode.com/problems/shortest-word-distance-iii/submissions/
 *
 *Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * word1 and word2 may be the same and they represent two individual words in the list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “makes”, word2 = “coding”
 * Output: 1
 * Input: word1 = "makes", word2 = "makes"
 * Output: 3
 * Note:
 * You may assume word1 and word2 are both in the list.
 *
 *
 *
 */
public class P245_Shortest_Word_Distance_III {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int w1 = -1, w2 = -1, n = words.length, res = n;
        boolean equal = word1.equals(word2);
        for (int i = 0; i < n; i++) {
            if (equal) {
                if (word1.equals(words[i])) {
                    if (w1 != -1)
                        res = Math.min(res, i - w1);
                    w1 = i;
                }
            } else {
                if (word1.equals(words[i]))
                    w1 = i;
                if (word2.equals(words[i]))
                    w2 = i;
                if (w1 != -1 && w2 != -1)
                    res = Math.min(res, Math.abs(w2-w1));
            }
        }
        return res;
    }
}