package com.mycompany.mavenproject1.DP;

import java.util.Scanner;

public class FindWineer {
    /*
     * Problem statement
     * Whis and Beerus are playing a new game today. They form a tower of N coins
     * and make a move in alternate turns. Beerus plays first. In one step, the
     * player can remove either 1, X, or Y coins from the tower. The person to make
     * the last move wins the game. Can you find out who wins the game?
     * 
     * Detailed explanation ( Input/output format, Notes, Images )
     * Constraints :
     * 1 <= N <= 10 ^ 6
     * 2 <= X <= Y<= 50
     * 
     * Time Limit: 1 sec
     * Sample Input 1 :
     * 4 2 3
     * Sample Output 1 :
     * Whis
     * Sample Input 2 :
     * 10 2 4
     * Sample Output 2 :
     * Beerus
     * Explanation to Sample Input 1:
     * Initially, there are 4 coins, In the first move, Beerus can remove either 1,
     * 2, or 3 coins in all three cases, Whis can win by removing all the remaining
     * coins.
     */

    public static String findWinner(int n, int x, int y) {
        // Your code goes here
        // Create array to store if position is GOOD (true) or BAD (false)
        boolean dp[] = new boolean[n + 1];
        // With 0 coins, you've already lost (previous player took last coin)
        if (n == 0) {
            dp[0] = false;
        }

        for (int i = 1; i <= n; i++) {
            // Assume this position is BAD
            dp[i] = false;

            // Move 1: Remove 1 coin OR
            if (i >= 1) {
                if (dp[i - 1] == false) {
                    // Opponent is in BAD position = GOOD for me!
                    dp[i] = true;
                }
            }
            // Move 2: Remove x coins OR
            if (i >= x) {
                // After I remove x, opponent has (coins-x) coins
                if (dp[i - x] == false) {
                    // Opponent is in BAD position = GOOD for me!
                    dp[i] = true;
                }
            }
            // Move 3: Remove y coins
            if (i >= y) {
                // After I remove y, opponent has (coins-y) coins
                if (dp[i - y] == false) {
                    // Opponent is in BAD position = GOOD for me!
                    dp[i] = true;
                }
            }

        }
        // Beerus starts with n coins
        if (dp[n] == true) {
            return "Beerus"; // Starting position is GOOD for Beerus
        } else {
            return "Whis"; // Starting position is BAD for Beerus
        }

    }

    public static void main(String[] args) {
        // Test Sample 1
        System.out.println("Sample 1: " + findWinner(4, 2, 3)); // Output: Whis

        // Test Sample 2
        System.out.println("Sample 2: " + findWinner(10, 2, 4)); // Output: Beerus

        // Additional test cases
        System.out.println("Test 3: " + findWinner(5, 2, 3)); // Output: Beerus
        System.out.println("Test 4: " + findWinner(1, 2, 3)); // Output: Beerus
    }
}
