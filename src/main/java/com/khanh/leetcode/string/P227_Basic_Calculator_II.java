package com.khanh.leetcode.string;

/**
 * @url https://leetcode.com/problems/basic-calculator-ii/
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 *
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */

public class P227_Basic_Calculator_II {

    public static void main(String[] args) {
        System.out.println(calculate("3 + 2 * 2"));
    }

    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int num = 0, tmp = 0, res = 0;
        char op = '+';
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                tmp = tmp * 10 + c - '0';
            } else if (c != ' ') {
                num = cal(num, tmp, op);
                if (c == '+' || c == '-') {
                    res += num;
                    num = 0;
                }
                tmp = 0;
                op = c;
            }
        }
        return res + cal(num, tmp, op);
    }

    private static int cal(int num, int tmp, char op) {
        if (op == '+') return num + tmp;
        else if (op == '-') return num - tmp;
        else if (op == '*') return num * tmp;
        else return num / tmp;
    }

}
