package com.khanh.leetcode.binarySearch;

import java.util.Random;

/**
 *
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
 *
 * Note:
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * Example 1:
 *
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * Example 2:
 *
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * Explanation of Input Syntax:
 *
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 *
 */

public class P528_Random_Pick_with_Weight {

    int[] sumw;
    Random random;
    public P528_Random_Pick_with_Weight(int[] w) {
        random = new Random();
        sumw = new int[w.length];
        sumw[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sumw[i] = sumw[i-1] + w[i];
        }
    }

    public int pickIndex() {
        int n = sumw.length;
        int idx = random.nextInt(sumw[n-1]) + 1;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (sumw[mid] == idx) {
                return mid;
            } else if (sumw[mid] < idx) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }



}
