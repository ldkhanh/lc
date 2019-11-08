package com.khanh.leetcode.dynamicProgramming;

/**
 * @url https://leetcode.com/problems/maximum-subarray/
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class P53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int maxE = nums[0], max = maxE;
        for (int i = 1; i < nums.length; i++) {
            maxE = Math.max(maxE, maxE + nums[i]);
            max = Math.max(max, maxE);
        }
        return max;
    }
}
