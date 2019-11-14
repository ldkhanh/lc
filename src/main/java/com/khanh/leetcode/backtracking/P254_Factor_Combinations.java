package com.khanh.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @url https://leetcode.com/problems/factor-combinations/
 *
 * Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 *
 * Note:
 *
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * Example 1:
 *
 * Input: 1
 * Output: []
 * Example 2:
 *
 * Input: 37
 * Output:[]
 * Example 3:
 *
 * Input: 12
 * Output:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 * Example 4:
 *
 * Input: 32
 * Output:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 *
 */

public class P254_Factor_Combinations {
    public List<List<Integer>> getFactors(int n) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (n <= 3) return result;
        backtrack(result, new ArrayList<>(), n, 2);
        return result;
    }
    private void backtrack(ArrayList<List<Integer>> result, ArrayList<Integer> tmp, int n, int factor) {
        for (int i = factor; i*i <= n; i++) {
            if (n % i == 0) {
                tmp.add(i);
                tmp.add(n/i);
                result.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size()-1);
                backtrack(result, tmp, n / i, i);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
