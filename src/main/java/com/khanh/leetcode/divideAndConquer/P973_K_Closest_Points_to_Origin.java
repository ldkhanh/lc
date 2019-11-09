package com.khanh.leetcode.divideAndConquer;

import java.util.Random;

/**
 * @URL https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 *
 * Note:
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 *
 * Solution with Quick Select
 *
 * Time: O(\log{K}) in average; O(N) in the worst case.
 * Space: O(\log{K}) in average; O(N) in the worst case (call stack).
 *
 * Quick Select
 * The idea of Quick Select is to find the K-th element, make elements on the left less than the K-th element, and make elements on the right greater than the K-th element.
 *
 * We randomly pick an element. If it turns out to be the actual K-th element, we can stop at the first step. So it depends on luck.
 *
 * After swapping, if this element turns out to be an element to the left of the K-th element, we recursively solve the subproblem for the right subarray; if it is to the right, we solve it for the left subarray.
 *
 * Note: To make code cleaner, after we pick the random index, we place the element at the beginning before doing swapping.
 */

public class P973_K_Closest_Points_to_Origin {

    // quickSelect
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        quickSelect(points, K-1, 0, n - 1);     // index from 0
        int[][] result = new int[K][];
        for (int i = 0; i < K; ++i) {
            result[i] = points[i];
        }
        return result;
    }

    // find the k-th element (from 0 ~ hi - 1)
    private void quickSelect(int[][] points, int k, int lo, int hi) {
        if (lo == hi)
            return;
        Random rand = new Random();
        int randIdx = lo + rand.nextInt(hi - lo + 1);   // lo + (0 ~ #element)
        //place the key to the beginning
        swap(points, lo, randIdx);
        int key = lo;
        int i = lo, j = hi + 1; // one index offset
        while (true) {
            while (dis(points[++i]) < dis(points[key])) {   // move i
                if (i == hi) break;
            }
            while (dis(points[--j]) > dis(points[key])) {   // move j
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(points, i, j);
        }
        swap(points, key, j);     // put[key] to the correct place [<key] [key] [>key]

        // notice that k = K - 1
        // j is now where [key] is
        if (j > k) quickSelect(points, k, lo, j - 1); // left
        if (j < k) quickSelect(points, k, j + 1, hi); // right
        // if j == k, finish
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private int dis(int[] p) {      // spuare
        return p[0] * p[0] + p[1] * p[1];
    }

}
