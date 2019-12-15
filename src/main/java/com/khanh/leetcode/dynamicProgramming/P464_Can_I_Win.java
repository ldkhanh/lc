package com.khanh.leetcode.dynamicProgramming;

/**
 * @url https://leetcode.com/problems/can-i-win/
 *
 * In the "100 game," two players take turns adding, to a running total, any integer from 1..10.
 * The player who first causes the running total to reach or exceed 100 wins.
 *
 * What if we change the game so that players cannot re-use integers?
 *
 * For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.
 *
 * Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.
 *
 * You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.
 *
 * Example
 *
 * Input:
 * maxChoosableInteger = 10
 * desiredTotal = 11
 *
 * Output:
 * false
 *
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
 * Same with other integers chosen by the first player, the second player will always win.
 *
 */
public class P464_Can_I_Win {
    private byte[] memo;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0)  return true;
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if ( sum < desiredTotal) return false;

        memo = new byte[1 << maxChoosableInteger];
        return canFirstWin(0, maxChoosableInteger, desiredTotal);
    }
    private boolean canFirstWin(int state, int max, int total) {
        // In the last step, the player already reach desiredTotal
        if (total <= 0) return false;
        if (memo[state] != 0)  // already has the result
            return memo[state] == 1;
        // Try every choosable interger
        for (int i = max - 1; i >= 0; i--) {
            if ( (state & (1 << i)) == 0) {  // if not used
                if ( !canFirstWin( state | (1 << i), max, total - i - 1)) {
                    memo[state] = 1;
                    return true;
                }
            }
        }
        memo[state] = -1;
        return false;
    }
}
// state is a maxChoosableInteger bit integer, representing whether a number in range 1 to n is used or not.
//(state & (1 << i)) == 0 is true if the number is not used, state | (1 << i) will set the number to be used
