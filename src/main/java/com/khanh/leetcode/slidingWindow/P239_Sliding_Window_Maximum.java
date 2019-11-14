package com.khanh.leetcode.slidingWindow;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @url https://leetcode.com/problems/sliding-window-maximum/
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 *
 * Accepted
 * 199,358
 * Submissions
 * 499,261
 *
 */

public class P239_Sliding_Window_Maximum {

    // Time O(n)   Space O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // remove numbers out of range k
            while (!q.isEmpty()  && q.peekFirst() < i - k + 1)          // peekFirst
                q.pollFirst();                                          // removeFirst
            // remove smaller numbers in k range as they useless
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            // q contains index ... res contains content
            q.offerLast(i);                                             // offerLast
            if (i >= k - 1) {
                res[ri++] = nums[q.peekFirst()];                        // peekFirst
            }
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length < 2) return nums;
        int[] res = new int[nums.length - k + 1];
        int maxIndex = -1;
        for (int i = 0; i < res.length; i++) {
            if (maxIndex < i) {
                maxIndex = i;
                for (int j = i + 1; j < i + k; j++) {
                    if (nums[j] >= nums[maxIndex])
                        maxIndex = j;
                }
            } else {
                if (nums[i + k - 1] >= nums[maxIndex])
                    maxIndex = i + k - 1;
            }
            res[i] = nums[maxIndex];
        }
        return res;
    }
}
