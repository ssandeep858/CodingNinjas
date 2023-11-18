/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.Arrays;

/**
 *
 * @author ssingh Example 1:
 *
 * Input: coins = [1,2,5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3 Output: -1 Example 3:
 *
 * Input: coins = [1], amount = 0 Output: 0
 */
public class CoinChange {

    // 0-1 knapsac problem but unbounded as coins amount not fixed
    public static int coinChange(int[] coins, int amount) {

        if (amount < 1) {
            return 0;
        }
        // memoization array for previous results
        int[] minCoins = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            minCoins[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && minCoins[i - coins[j]] != Integer.MAX_VALUE) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coins[j]]);
                }
            }
        }
        if (minCoins[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return minCoins[amount];

    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
