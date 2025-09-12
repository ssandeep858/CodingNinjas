package com.mycompany.mavenproject1.DP;

public class LootHouses {
    /*
     * Problem statement
     * A thief wants to loot houses. He knows the amount of money in each house. He
     * cannot loot two consecutive houses. Find the maximum amount of money he can
     * loot.
     * 
     * Detailed explanation ( Input/output format, Notes, Images )
     * Constraints :
     * 0 <= n <= 10 ^ 4
     * 
     * Time Limit: 1 sec
     * Sample Input 1 :
     * 6
     * 5 5 10 100 10 5
     * Sample Output 1 :
     * 110
     * Sample Input 2 :
     * 6
     * 10 2 30 20 3 50
     * Sample Output 2 :
     * 90
     * Explanation of Sample Output 2 :
     * Looting first, third, and the last houses([10 + 30 + 50]) will result in the
     * maximum loot, and all the other possible combinations would result in less
     * than 90.
     */

    public static int maxMoneyLooted(int[] houses) {
        // Your code goes here
        if (houses.length == 0) {
            return 0;
        }
        if (houses.length == 1) {
            return houses[0];
        }
        if (houses.length == 2) {
            return Math.max(houses[0], houses[1]);
        }

        int dp[] = new int[houses.length];
        dp[0] = houses[0];// not zero we would need first array value.
        dp[1] = Math.max(houses[0], houses[1]);

        // Loot the current house: Add current house's money to the maximum money from
        // houses up to i-2
        // Skip the current house: Take the maximum money from houses up to i-1

        for (int i = 2; i < houses.length; i++) {
            // Either loot current house + max from i-2
            // Or skip current house and take max from i-1
            dp[i] = Math.max(houses[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[houses.length - 1];

    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] houses1 = { 5, 5, 10, 100, 10, 5 };
        int result1 = maxMoneyLooted(houses1);
        System.out.println("Maximum money looted: " + result1); // Output: 110

        // Sample Input 2
        int[] houses2 = { 10, 2, 30, 20, 3, 50 };
        int result2 = maxMoneyLooted(houses2);
        System.out.println("Maximum money looted: " + result2); // Output: 90

        // Additional test cases
        int[] houses3 = { 1, 2, 3, 1 };
        System.out.println("Maximum money looted: " + maxMoneyLooted(houses3)); // Output: 4

        int[] houses4 = { 2, 7, 9, 3, 1 };
        System.out.println("Maximum money looted: " + maxMoneyLooted(houses4)); // Output: 12
    }
}
