package com.khanh.leetcode.recursion;

import java.util.Arrays;
import java.util.List;

/**
 * @url https://leetcode.com/problems/lexicographical-numbers/
 * Given an integer n, return 1 - n in lexicographical order.
 *
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 *
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 */

public class P386_Lexicographical_Numbers {
    public List<Integer> lexicalOrder(int n) {
        Integer[] res = new Integer[n];
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            res[i-1] = curr;
            if (curr*10 <= n) {
                curr *= 10;
            } else if (curr + 1 <= n && curr % 10 != 9) {
                curr++;
            } else {
                curr /= 10;
                while (curr % 10 == 9) {
                    curr /= 10;
                }
                curr++;
            }
        }
        return Arrays.asList(res);
    }
}
