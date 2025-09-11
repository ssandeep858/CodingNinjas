package com.mycompany.mavenproject1.DP;

import java.util.Arrays;

/*
 * A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time. 
 * Implement a method to count and return all possible ways in which the child can run-up to the stairs.
 * Sample Input 1:
4
Sample Output 1:
7
Sample Input 2:
10
Sample Output 2:
274

*/

public class Stairs {
    public static long staircase(int n) {

        if (n == 0) {
            // Since the child starts at step 0 (the ground),
            // there is exactly 1 way to be at step 0 - by doing nothing/staying there!
            return 1;
        }

        if (n == 1) {
            return 1;
            // ground se upar just 1 step so 1 way
        }
        if (n == 2) {
            return 2;
            // ground se upar just 1+1 step or ground se upar seedha 2 step so total 2 way
        }
        long dp[] = new long[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            // To reach step i going UP, child could have been at:
            // - Step (i-3) and jumped UP 3 steps
            // - Step (i-2) and jumped UP 2 steps
            // - Step (i-1) and jumped UP 1 step
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(staircase(38));
    }
}
