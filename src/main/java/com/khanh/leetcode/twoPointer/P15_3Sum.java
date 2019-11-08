package com.khanh.leetcode.twoPointer;

/**
*
* @url https://leetcode.com/problems/3sum/
*
* Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
* */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i > 0 && nums[i-1] != nums[i])
                twoSum(nums, result, i);
        }
        return result;
    }
    private void twoSum(int[] nums, List<List<Integer>> result, int idx) {
        int l = idx+1, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == -nums[idx]) {
                result.add(Arrays.asList(nums[idx], nums[l], nums[r]));
                while (l < r && nums[l] == nums[l+1]) l++;
                while (l < r && nums[r] == nums[r-1]) r--;
                l++;
                r--;
            } else if (nums[l] + nums[r] < -nums[idx]) {
                l++;
            } else {
                r--;
            }
        }
    }
}