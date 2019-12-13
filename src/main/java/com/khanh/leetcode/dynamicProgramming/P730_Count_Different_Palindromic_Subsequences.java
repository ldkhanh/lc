package com.khanh.leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * @url https://leetcode.com/problems/count-different-palindromic-subsequences/submissions/
 *
 * Given a string S, find the number of different non-empty palindromic subsequences in S, and return that number modulo 10^9 + 7.
 *
 * A subsequence of a string S is obtained by deleting 0 or more characters from S.
 *
 * A sequence is palindromic if it is equal to the sequence reversed.
 *
 * Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.
 *
 * Example 1:
 * Input:
 * S = 'bccb'
 * Output: 6
 * Explanation:
 * The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
 * Note that 'bcb' is counted only once, even though it occurs twice.
 * Example 2:
 * Input:
 * S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
 * Output: 104860361
 * Explanation:
 * There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.
 * Note:
 *
 * The length of S will be in the range [1, 1000].
 * Each character S[i] will be in the set {'a', 'b', 'c', 'd'}.
 */
class P730_Count_Different_Palindromic_Subsequences {
    // Dynamic Programming   2D
    // Time and Space : O(N^2)
    int[][] memo, prv, nxt;
    byte[] A;
    int MOD = 1_000_000_007;
    public int countPalindromicSubsequences(String S) {
        int N = S.length();
        prv = new int[N][4];
        nxt = new int[N][4];
        memo = new int[N][N];
        for (int[] row : prv) Arrays.fill(row, -1);
        for (int[] row : nxt) Arrays.fill(row, -1);
        A = new byte[N];
        int ix = 0;
        for (char c : S.toCharArray()) {
            A[ix++] = (byte) (c - 'a');
        }
        int[] last = new int[4];
        Arrays.fill(last, -1);

        // prev[i][0] will the previous occurrence of 'a' in S[:i]
        for (int i = 0; i < N; i++) {
            last[A[i]] = i;
            for (int k = 0; k < 4; k++) {
                prv[i][k] = last[k];
            }
        }
        Arrays.fill(last, - 1);         // Reset last array
        // next[i][0] will the next occurrence of 'a' in S[i:]
        for (int i = N-1; i >= 0; i--) {
            last[A[i]] = i;
            for (int k = 0; k < 4; k++) {
                nxt[i][k] = last[k];
            }
        }
        return dp(0, N - 1) - 1;
    }
    private int dp(int i, int j) {
        if (memo[i][j] > 0) return memo[i][j];
        int ans = 1;
        if (i <= j) {
            for (int k= 0; k < 4; k++) {
                int i0 = nxt[i][k];
                int j0 = prv[j][k];
                if (i <= i0 && i0 <= j) ans++;
                if (-1 < i0 && i0 < j0) ans += dp(i0 +1, j0 - 1);
                if (ans >= MOD) ans -= MOD;
            }
        }
        memo[i][j] = ans;
        return ans;
    }
}





/*
    // Dynamic Programming   3D
    // Bottom up - Left right
    // Time and Space : O(N^2)
    public int countPalindromicSubsequences(String S) {
        int n = S.length();
        int mod = 1000000007;
        int[][][] dp = new int[4][n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    char c = (char) (k + 'a');
                    if (i == j) {
                        if (S.charAt(i) == c)
                            dp[k][i][j] = 1;
                        else
                            dp[k][i][j] = 0;
                    } else { // j > i
                        if (S.charAt(i) != c) { //S[i] != 'a'+x, then dp[x][i][j] = dp[x][i+1][j]
                            dp[k][i][j] = dp[k][i+1][j];
                        } else if (S.charAt(j) != c) {//S[j] != 'a'+x,then dp[x][i][j] = dp[x][i][j-1]
                            dp[k][i][j] = dp[k][i][j-1];
                        } else {            // S[i] == S[j] == 'a'+x,
                            dp[k][i][j] = 2;
                            for (int m = 0; m < 4; m++) {
                                dp[k][i][j] += dp[m][i+1][j-1];
                                dp[k][i][j] %= mod;
                            }
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int k = 0; k < 4; k++) {
            result += dp[k][0][n-1];
            result %= mod;
        }
        return result;
    }

*/