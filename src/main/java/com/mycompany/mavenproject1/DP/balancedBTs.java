package com.mycompany.mavenproject1.DP;

import java.util.Arrays;

/*
 * 
 * Problem statement
Given an integer h, find the possible number of balanced binary trees of height h. You just need to return the count of possible binary trees which are balanced.

This number can be huge, so, return output modulus 10^9 + 7.

Write a simple recursive solution.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= h <= 24
Time Limit: 1 sec
Sample Input 1:
3
Sample Output 1:
15
Sample Input 2:
4
315
 */
public class balancedBTs {
    public static long balancedBTs(long n) {
        long mod = 1000000007;
        /*
         * The Recursive Logic:
         * For a balanced tree of height h:
         * 
         * Case 1: Both left and right subtrees have height (h-1)
         * 
         * Count = count(h-1) × count(h-1)
         * Case 2: Left subtree has height (h-1), right has height (h-2)
         * 
         * Count = count(h-1) × count(h-2)
         * Case 3: Left subtree has height (h-2), right has height (h-1)
         * 
         * Count = count(h-2) × count(h-1)
         */
        if (n == 0 || n == 1) {
            return 1;
        }
        long opt1 = balancedBTs(n - 1);
        long opt2 = balancedBTs(n - 2);

        long count1 = (opt1 * opt1) % mod;
        long count2 = (2 * opt2 * opt1) % mod;

        // final mein bhi modulus krna jarruri hai
        /*
         * // For large n:
         * count1 = 999999999 // (just under MOD)
         * count2 = 999999999 // (just under MOD)
         * count1 + count2 = 1999999998 // Exceeds MOD! ❌
         */
        return (count1 + count2) % mod;
    }

    // bottom-up dynamic programming
    public static int balancedBTsDynamic(int height) {
        long mod = 1000000007;

        if (height == 0 || height == 1) {
            return 1;
        }
        int dp[] = new int[height + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= height; i++) {
            long opt1 = dp[i - 1];
            long opt2 = dp[i - 2];

            long case1 = (opt1 * opt1) % mod;
            long case2 = (2 * opt1 * opt2) % mod;
            dp[i] = (int) ((case1 + case2) % mod);
        }
        return dp[height];
    }

    public static void main(String[] args) {
        System.out.println(balancedBTsDynamic(35));
    }
}
