package com.khanh.leetcode.math;

/**
 *
 * @url https://leetcode.com/problems/solve-the-equation/
 *
 * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.
 *
 * If there is no solution for the equation, return "No solution".
 *
 * If there are infinite solutions for the equation, return "Infinite solutions".
 *
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 *
 * Example 1:
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 * Example 2:
 * Input: "x=x"
 * Output: "Infinite solutions"
 * Example 3:
 * Input: "2x=x"
 * Output: "x=0"
 * Example 4:
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 * Example 5:
 * Input: "x=x+2"
 * Output: "No solution"
 */

public class P640_Solve_the_Equation {

    public String solveEquation(String equation) {
        if (equation == null || equation.length() == 0) return "No solution";
        String[] parts = equation.split("=");

        int[] left = parse(parts[0]);
        int[] right = parse(parts[1]);


        int xCount = left[0] - right[0];
        int value = right[1] - left[1];
        if (xCount == 0) {
            return value == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + value / xCount;

    }

    private int[] parse(String s) {

        int[] values = new int[2];
        StringBuilder sb = new StringBuilder();

        int signBefore = 1;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));

            } else if (s.charAt(i) == 'x') {
                if (sb.length() == 0) {
                    values[0] += signBefore;
                } else {
                    values[0] += Integer.parseInt(sb.toString()) * signBefore;
                }
                sb.setLength(0);

            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {

                if (sb.length() > 0) {
                    values[1] += Integer.parseInt(sb.toString()) * signBefore;
                    sb.setLength(0);
                }

                //set sign
                if (s.charAt(i) == '-') {
                    signBefore = -1;
                } else {
                    signBefore = 1;
                }
            }
        }

        if (sb.length() > 0) {
            values[1] += Integer.parseInt(sb.toString()) * signBefore;
            sb.setLength(0);
        }

        return values;
    }
}
