package com.khanh.leetcode.stack;

import java.util.Stack;

/**
 * @url https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 *
 */

public class P20_Valid_Parentheses {

    public boolean isValid1(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{')
                st.push('}');
            else if (ch == '[')
                st.push(']');
            else if (ch == '(')
                st.push(')');
            else if (st.isEmpty() || ch != st.pop())
                return false;
        }
        return st.isEmpty();
    }

    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int i = -1;
        for (char c : s.toCharArray()) {
            if (c == '{') stack[++i] = '}';
            else if (c == '(') stack[++i] = ')';
            else if (c == '[') stack[++i] = ']';
            else if (i < 0 || c != stack[i--])
                return false;
        }
        return i < 0;
    }

}
