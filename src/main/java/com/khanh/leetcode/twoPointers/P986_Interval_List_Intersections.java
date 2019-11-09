package com.khanh.leetcode.twoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * @url https://leetcode.com/problems/interval-list-intersections/
 *
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 *
 *
 * Note:
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 *
 */

public class P986_Interval_List_Intersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;   // We use two index to access two array's interval.
        while (i < A.length && j < B.length) {
            int left = Math.max(A[i][0], B[j][0]);
            int right = Math.min(A[i][1], B[j][1]);
            // if intersection exists, we add the intersection interval to the rest list
            if (left <= right) list.add(new int[]{left, right});

            // if A's current interval's end is larger than B's, we will move to the B's next interval
            // otherwise. If their ends are equals, move both A and B to their next interval.
            if (A[i][1] < B[j][1]) i++;
            else if (A[i][1] > B[j][1]) j++;
            else {
                i++;
                j++;
            }
        }
        // convert res list to int array
        int[][] res = new int[list.size()][2];
        int idx = 0;
        for (int[] interval : list) {
            res[idx++] = interval;
        }
        return res;
    }

}
