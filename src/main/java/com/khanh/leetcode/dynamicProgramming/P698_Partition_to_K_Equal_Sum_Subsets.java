package com.khanh.leetcode.dynamicProgramming;

/***
 * @url https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 *
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 *
 * Example 1:
 *
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 *
 *
 * Note:
 *
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */
class P698_Partition_to_K_Equal_Sum_Subsets {
    // Backtracking DFS
    // Time O()
    // Space O()
    public boolean canPartitionKSubsets(int[] nums, int k) {

        boolean[] visited = new boolean[nums.length];
        int target = 0;
        for (int one : nums) target += one;
        if (k <= 0 || target % k != 0) return false;
        return backtracking(nums, visited, k, target/k, 0, 0);
    }
    private boolean backtracking(int[] nums, boolean[] visited, int k, int target, int cursum, int curInd) {
        if (k == 1) return true;
        if (cursum == target) return backtracking(nums, visited, k - 1, target, 0, 0);
        if (cursum > target) return false;
        for (int i = curInd; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (backtracking(nums, visited, k, target, cursum + nums[i], i + 1)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}

/**
 *

enum Result {TRUE, FALSE}
class Solution {
    // Dynamic Programming
    // Top - Down
    // Time O(n * 2^n)
    // Space O(2^n)
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        Result[] memo = new Result[1 << nums.length];
        memo[ (1 << nums.length) - 1] = Result.TRUE;
        return search(0, sum, memo, nums, sum / k);
    }
    boolean search(int used, int todo, Result[] memo, int[] nums, int target) {
        if (memo[used] == null) {
            memo[used] = Result.FALSE;
            int targ = (todo - 1) % target + 1;
            for (int i = 0; i < nums.length; i++) {
                if ((((used >> 1) & 1) == 0) && nums[i] <= targ) {
                    if (search(used | (1 << i), todo - nums[i], memo, nums, target)) {
                        memo[used] = Result.TRUE;
                        break;
                    }
                }
            }
        }
        return memo[used] == Result.TRUE;
    }
}


*/