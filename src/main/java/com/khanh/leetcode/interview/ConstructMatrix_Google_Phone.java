package com.khanh.leetcode.interview;

/***
 * https://leetcode.com/discuss/interview-question/668450/Google-or-Phone-or-Construct-Matrix
 * Given total numer of rows, columns, starting position and direction, construct a matrix of the given size and fill it while moving in the given direction.
 * m -> row
 * n -> column
 * start position -> enumeration
 * moving direction -> enumeration
 *
 * m = 4, n = 4
 * start positions: TL, TR, BL, BR
 * moving direction: H, V
 * TL  .  .  TR
 * .   .  .   .
 * .   .  .   .
 * BL  .  .  BR
 *
 * Example 1:
 * Input: m = 3, n = 3, startposition = TL, moving_direction = H
 *
 * Output: return matrix[3][3]
 * 		1 -> 2 -> 3
 * 		          |
 * 		6 <- 5 <- 4
 * 		|
 * 		7 -> 8 -> 9
 *
 * Example 2:
 * Input: m = 3, n = 3, startposition = TL, moving_direction = V
 *
 * Output: return matrix[3][3]
 * 		1  6  7
 * 		2  5  8
 * 		3  4  9
 */
public class ConstructMatrix_Google_Phone {
}
