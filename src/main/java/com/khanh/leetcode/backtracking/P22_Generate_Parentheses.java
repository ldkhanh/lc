package com.khanh.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @url https://leetcode.com/problems/generate-parentheses/
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

public class P22_Generate_Parentheses {

    // Backtracking
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n < 1) return res;
        char[] temp = new char[2*n];
        backtrack(res, temp, 0, 0, 0, n);
        return res;
    }
    public void backtrack(List<String> res, char[] temp, int index, int left, int right, int n)
    {
        if(right == n){
            res.add(new String(temp));
            return;
        }
        if(left > right){
            temp[index] = ')';
            backtrack(res, temp, index + 1, left, right + 1, n);
        }
        if(left < n)
        {
            temp[index] = '(';
            backtrack(res, temp, index + 1, left + 1, right, n);
        }
    }

}
