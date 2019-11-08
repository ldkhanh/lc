package com.khanh.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @url https://leetcode.com/problems/permutations/
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */

public class P46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            backtrack(nums, ans, temp, visited);
            temp.remove(nums[i]);
            visited[i] = false;
        }
    }

}
