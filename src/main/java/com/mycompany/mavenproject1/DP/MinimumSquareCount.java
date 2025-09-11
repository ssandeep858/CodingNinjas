package com.mycompany.mavenproject1.DP;

import java.sql.Time;
import java.util.Arrays;

public class MinimumSquareCount {
    /*
     * Given an integer N, find and return the count of minimum numbers required to
     * represent N as a sum of squares.
     * 
     * That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and
     * {2^2}. The output will be 1, as 1 is the minimum count of numbers required to
     * represent N as sum of squares.
     */
    /*
     * Sample Input 1 :
     * 12
     * Sample Output 1 :
     * 3
     * Explanation of Sample Output 1 :
     * 12 can be represented as :
     * A) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) +
     * (1^2) + (1^2) + (1^2)
     * 
     * B) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (2 ^ 2)
     * 
     * C) (1^2) + (1^2) + (1^2) + (1^2) + (2 ^ 2) + (2 ^ 2)
     * 
     * D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)
     * 
     * As we can see, the output should be 3.
     * Sample Input 2 :
     * 9
     * Sample Output 2 :
     * 1
     */

    public static int minCount(int n) {
        int[] mm = new int[n + 1];
        Arrays.fill(mm, -1);
        return minCountHelper(n, mm);
    }

    // O(Time Complexity: O(n × √n))
    public static int minCountHelper(int n, int[] mm) {
        // Your code goes here
        if (n == 0)
            return 0; // 0 = nothing, needs 0 perfect squares
        if (n == 1)
            return 1; // 1 = 1², needs 1 perfect square
        if (n == 2)
            return 2; // 2 = 1² + 1², needs 2 perfect squares
        if (n == 3)
            return 3; // 3 = 1² + 1² + 1², needs 3 perfect squares

        if (mm[n] != -1) {
            return mm[n];
        }
        int minNum = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            // Subtract this square from n and solve for remainder
            int remainder = n - square;
            // Recursively find minimum count for remainder
            int countForRemainder = minCountHelper(remainder, mm);
            // Total = 1 (for current square) + count for remainder
            int totalCount = 1 + countForRemainder;
            minNum = Math.min(minNum, totalCount);
        }
        mm[n] = minNum;
        return minNum;
    }

    // Time Complexity: O(n × √n)
    public static int minCountDP(int n) {
        /*
         * DP Table Example for n=5:
         * dp[0] = 0 (base case)
         * dp[1] = 1 (1 = 1²)
         * dp[2] = 2 (2 = 1² + 1²)
         * dp[3] = 3 (3 = 1² + 1² + 1²)
         * dp[4] = 1 (4 = 2²)
         * dp[5] = 2 (5 = 2² + 1²)
         */
        int[] dp = new int[n + 1];

        // Base case: zero needs zero perfect squares
        dp[0] = 0;

        // Fill the DP table from 1 to n
        for (int i = 1; i <= n; i++) {
            // Start with worst case: express i as sum of i ones
            // This is always valid since 1² = 1
            dp[i] = i; // i = 1² + 1² + ... + 1² (i times)

            // Try to improve by using larger perfect squares
            // j represents the potential square root we're testing
            // We stop when j² > i because we can't use squares larger than i
            for (int j = 1; j * j <= i; j++) {
                // The perfect square we're considering
                int square = j * j;

                // After using this square, we need to solve for (i - square)
                // Example: To make 13 using 9 (3²), we need to solve for 13-9=4
                int remainder = i - square;

                // Total squares needed = 1 (current square) + squares for remainder
                // dp[remainder] was calculated in a previous iteration
                int totalCount = 1 + dp[remainder];

                // Update dp[i] if we found a better solution
                // Example: dp[13] = min(previous best, 1 + dp[4])
                dp[i] = Math.min(dp[i], totalCount);
            }

            /*
             * After inner loop completes, dp[i] contains the minimum
             * number of perfect squares needed to represent i
             */
        }

        // Return the answer for n
        return dp[n];
    }

    public static int minCountDP(int n) {
        // Create a DP array to store minimum squares needed for each number from 0 to n
        // dp[i] will store the minimum number of perfect squares that sum to i
        int[] dp = new int[n + 1];

        // Base case: 0 requires 0 perfect squares (empty sum)
        dp[0] = 0;

        // Build up the solution for each number from 1 to n
        for (int i = 1; i <= n; i++) {
            // Initialize with worst case scenario: using all 1s
            // Example: 5 = 1² + 1² + 1² + 1² + 1² (five 1s)
            dp[i] = i;

            // Try all possible perfect squares that are less than or equal to i
            // We only go up to j where j² ≤ i (equivalent to j ≤ √i)
            for (int j = 1; j * j <= i; j++) {
                // Calculate the perfect square we're trying to use
                // Example: if j=2, then square=4
                int square = j * j;

                // Calculate what remains after using this square
                // Example: if i=12 and square=4, remainder=8
                int remainder = i - square;

                // Total count = 1 (for current square) + minimum count for remainder
                // We look up dp[remainder] which we've already calculated
                // Example: For 12 using 4: totalCount = 1 + dp[8] = 1 + 2 = 3
                int totalCount = 1 + dp[remainder];

                // Keep the minimum between current best and this new option
                // This ensures we always have the optimal solution for dp[i]
                dp[i] = Math.min(dp[i], totalCount);
            }
        }

        // Return the minimum squares needed for n
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minCountDP(12));
    }
}
