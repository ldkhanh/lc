package com.khanh.leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @url https://leetcode.com/problems/word-break-ii/
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */

public class P140_Word_Break_II {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0 || wordDict.size() == 0) return result;
        Set<String> dict = new HashSet<>();
        boolean[] dead = new boolean[s.length()];
        int minLen = Integer.MAX_VALUE, maxLen = 0;
        // Add to set dict and find the minimum and maximum of word in wordDict
        for (String w : wordDict) {
            dict.add(w);
            minLen = Math.min(minLen, w.length());
            maxLen = Math.max(maxLen, w.length());
        }
        wordBreakHelper(dict, result, dead, new StringBuilder(), minLen, maxLen, s, 0);
        return result;
    }

    private boolean wordBreakHelper(Set<String> dict,
                                    List<String> result,
                                    boolean[] dead,
                                    StringBuilder sb,
                                    int minLen,
                                    int maxLen,
                                    String s,
                                    int start) {
        if (start == s.length()) {
            sb.setLength(sb.length() - 1);      // remove the last ' '
            result.add(sb.toString());
            return true;
        }
        if (dead[start]) return false;
        boolean success = false;
        for (int i = start + minLen - 1; i < Math.min(s.length(), start + maxLen); i++) {
            String sub= s.substring(start, i + 1);
            if (!dict.contains(sub)) continue;
            int prevLen = sb.length();
            sb.append(sub).append(' ');
            if (wordBreakHelper(dict, result, dead, sb, minLen, maxLen, s, i + 1)){
                success = true;
            }
            sb.setLength(prevLen);
        }
        dead[start] = !success;
        return success;

    }


}
