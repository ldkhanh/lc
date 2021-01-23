package com.khanh.leetcode.twoPointers;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * Level: Hard
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 0 <= n <= 3 * 10^4
 * 0 <= height[i] <= 10^5
 */
public class P42_Trapping_Rain_Water {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        // Two point result
        System.out.println(trap(height));
        // DP result
        System.out.println(trapDP(height));
    }

    // Two Pointer - change from DP
    // Time O(n) Space O(1)
    public static int trap(int[] height) {
        int n = height.length, result = 0;
        int left = 0, right = n - 1;
        int max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, height[left]);
                result += max - height[left++];
            } else {
                max = Math.max(max, height[right]);
                result += max - height[right--];
            }
        }
        return result;
    }

    // Dynamic Programming
    // Time O(n) Space O(n)
    public static int trapDP(int[] height) {
        int n = height.length, result = 0;
        if (n < 3) return result;
        int[] hei = new int[n];
        // Find max height upto given point from left end
        for (int i = 0; i < n; i++) {
            if (i == 0)
                hei[i] = height[i];
            else
                hei[i] = Math.max(hei[i-1], height[i]);
        }
        // Find max height upto the given from right end
        int currRight = 0, prevRight = 0;
        for (int i = n - 1; i >= 0; i--) {
            prevRight = currRight;
            if (i == n - 1)
                currRight = height[i];
            else
                currRight = Math.max(prevRight, height[i]);
            // Choose the minimum of 2 heights
            hei[i] = Math.min(hei[i], currRight);
            result += hei[i] - height[i];
        }
        return result;
    }
}
