package com.khanh.leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * @url https://leetcode.com/problems/longest-palindromic-subsequence/
 *
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input:
 *
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 * Input:
 *
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 */
public class P516_Longest_Palindromic_Subsequence {
    /**
     *     //  DP solution  --- Top bottom recursive method with memoization
     *     //  dp[i][j]: the longest palindromic subsequence's length of substring(i, j)
     *     //  State transition:
     *     //  dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
     *     //  otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
     *     //  Initialization: dp[i][i] = 1
     */

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];
        char[] ss = s.toCharArray();
        Arrays.fill(dp,1);      // A single char is count as a palindrom with length 1
        for (int j = 1; j < n; j++) {
            // i and j start with different as 1, no character between them initialiy (curLong == 0)
            int curLong = 0;
            for (int i = j - 1; i >= 0; i--) {
                int tmp = dp[i];    // dp[i][j]
                if (ss[i] == ss[j]) {
                    dp[i] = curLong + 2;
                }
                curLong = Math.max(curLong, tmp);
            }
        }
        int max = 1;
        for (int m : dp) max = Math.max(max, m);
        return max;
    }
}
