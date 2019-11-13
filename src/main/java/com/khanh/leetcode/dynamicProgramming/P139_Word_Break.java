package com.khanh.leetcode.dynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @url https://leetcode.com/problems/word-break/
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */

public class P139_Word_Break {
    // DP:
    // Time :  [length of s][size of dict][avg length of words in dict]

    public boolean wordBreak(String s, List<String> wordDict) {
        int maxWord = 0;
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
            maxWord = Math.max(maxWord, word.length());
        }
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i <= s.length(); i++ ) {
            for (int j = i-1; j >= 0 && i - j <= maxWord; j--) {
                if (f[j] && dict.contains(s.substring(j,i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
