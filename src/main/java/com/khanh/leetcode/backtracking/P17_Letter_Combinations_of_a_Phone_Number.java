package com.khanh.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @url https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */

public class P17_Letter_Combinations_of_a_Phone_Number {

    // Time O(4 ^ n)   Space O(n)
    private static final String[] KEY = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        backtrack(result, new char[digits.length()], digits, 0);
        return result;
    }

    private void backtrack(List<String> result, char[] sb, String digits, int offset) {
        if (offset == digits.length()) {
            result.add(new String(sb));
            return;
        }
        String letters = KEY[digits.charAt(offset) - '0'];
        for (char c : letters.toCharArray()) {
            sb[offset] = c;     // replace itself so we don't assign original again
            backtrack(result, sb, digits, offset+1);
        }
    }
}
