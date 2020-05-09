package com.khanh.leetcode.stack;

/**
 * @url https://leetcode.com/problems/daily-temperatures/
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 *
 *
 *
 */
public class P739_Daily_Temperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        int[] st = new int[n];
        int in = -1;    // stack
        for (int i = n - 1; i >= 0; i--) {
            while (in >= 0 && temperatures[i]  >= temperatures[st[in]]) in--;
            result[i] = in == -1? 0 : st[in] - i;
            st[++in] = i;
        }
        return result;
    }
}
