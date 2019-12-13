package com.khanh.leetcode.dynamicProgramming;

/**
 * @url https://leetcode.com/problems/maximum-product-subarray/
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 */
public class P152_Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {

        // store the result that is the max have found so far
        int r = nums[0];
        int n = nums.length;
        // imax / imin stores the max / min product of
        // subarray that ends with the current number num[i]
        for (int i = 1, imax = r, imin = r; i < n; i++) {
            // multiplied by a negative makes big number smaller, smaller bigger
            // so we redefine the extrenums by swapping them
            if (nums[i] < 0) {              // Special in here
                int t = imax;
                imax = imin;
                imin = t;
            }
            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
            r = Math.max(r, imax);
        }
        return r;
    }
}
