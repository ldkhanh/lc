package com.khanh.leetcode.binarySearch;

/**
 * @url https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 */

public class P34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        int leftIdx = binarySearch(nums, target, true);
        if (leftIdx == nums.length || nums[leftIdx] != target)  return res;
        res[0] = leftIdx;
        res[1] = binarySearch(nums, target, false) - 1;
        return res;
    }

    private int binarySearch(int[] nums, int x, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] > x || (left && nums[mid] == x))          // nums[mid] >= x    if left == true
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }
}
