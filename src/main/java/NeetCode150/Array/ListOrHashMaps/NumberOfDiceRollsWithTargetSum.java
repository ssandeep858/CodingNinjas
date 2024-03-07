/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.Arrays;

/**
 *
 * @author ssingh
 *
 * You have n dice, and each dice has k faces numbered from 1 to k.
 *
 * Given three integers n, k, and target, return the number of possible ways
 * (out of the kn total ways) to roll the dice, so the sum of the face-up
 * numbers equals target. Since the answer may be too large, return it modulo
 * 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1, k = 6, target = 3 Output: 1 Explanation: You throw one die with
 * 6 faces. There is only one way to get a sum of 3. Example 2:
 *
 * Input: n = 2, k = 6, target = 7 Output: 6 Explanation: You throw two dice,
 * each with 6 faces. There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3,
 * 5+2, 6+1. Example 3:
 *
 * Input: n = 30, k = 30, target = 500 Output: 222616187 Explanation: The answer
 * must be returned modulo 109 + 7.
 *
 *
 * Constraints:
 *
 * 1 <= n, k <= 30 1 <= target <= 1000
 */
public class NumberOfDiceRollsWithTargetSum {

    public static int numRollsToTargetRecursion(int n, int k, int target) {

        if (target < 0) {
            return 0;
        }
        if (target == 0 && n == 0) {
            return 1;
        }
        if (target == 0 && n != 0) {
            return 0;
        }

        int ways = 0;
        for (int face = 1; face <= k; face++) {
            ways += numRollsToTarget(n - 1, k, target - face);
        }
        return ways;
    }

    public static int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n + 1][target + 1];
        for (int i[] : dp) {
            Arrays.fill(i, -1);
        }

        return numRollsToTarget(n, k, target, dp);

    }

    public static int numRollsToTarget(int n, int k, int target, int[][] dp) {
        if (n < 0 || target < 0) {
            return 0;
        }
        if (target == 0 && n == 0) {
            return 1;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }

        int ways = 0;

        for (int face = 1; face <= k; face++) {
            ways = (ways + numRollsToTarget(n - 1, k, target - face, dp)) % 1000000007;
        }
        dp[n][target] = ways;
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(2, 6, 7));
    }

}
