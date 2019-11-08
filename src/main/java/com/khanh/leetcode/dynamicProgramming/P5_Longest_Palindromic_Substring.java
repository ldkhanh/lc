package com.khanh.leetcode.dynamicProgramming;

/**
 * @url https://leetcode.com/problems/longest-palindromic-substring/
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */

public class P5_Longest_Palindromic_Substring {

    /**
     * Solution 0: Expand Around Center V2
     *
     */
    public String longestPalindrome0(String s) {
        if (s == null || s.length() <= 1) return s;
        int[] resP = {0,0};
        char[] ss = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            i = manacher(ss, i, resP); // i is the center of palindromic test
        }
        return s.substring(resP[0], resP[0] + resP[1]);
    }

    private int manacher(char[] ss, int i, int[] resP) {
        int n = ss.length;
        int j = i--;
        while (j < n - 1 && ss[j] == ss[j + 1]) j++;  // move to right all same char at center
        int nextI = j++;
        while (i >= 0 && j < n && ss[i] == ss[j]) {
            i--;
            j++;
        }
        if (j - i > resP[1]) {
            resP[1] = j - i - 1;
            resP[0] = i + 1;
        }
        return nextI;
    }

    /**
     * Dynamic programming
     * dp(i,j) represents whether s(i ... j) can form a palindromic substring,
     * dp(i,j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring.
     * When we found a palindrome, check if it's the longest one.
     */

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        String res = null;
        boolean[][] dp = new boolean[n][n];

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3  || dp[i+1][j-1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length()))
                    res = s.substring(i, j + 1);
            }
        }
        return res;
    }


}
