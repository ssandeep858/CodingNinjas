/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ssingh Example 1:
 *
 *         Input: coins = [1,2,5], amount = 11 Output: 3 Explanation: 11 = 5 + 5
 *         + 1
 *         Example 2:
 *
 *         Input: coins = [2], amount = 3 Output: -1 Example 3:
 *
 *         Input: coins = [1], amount = 0 Output: 0
 */
public class CoinChange {

    // 0-1 knapsac problem but unbounded as coins amount not fixed
    // [1,5,6,9] , amount 11 failure as min coins is 2 not 3
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
                    // 5 1 ke sikke and 1 5 ka sikka
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
        System.out.println(coinChange(new int[] { 186, 419, 83, 408 }, 6249));
    }
}

class Result {

    /*
     * Complete the 'findLowestStartingStair' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY jumps as parameter.
     */
    public static int findLowestStartingStair(List<Integer> jumps) {
        // Write your code here
        int minValue = Integer.MAX_VALUE;
        // 1<=n<=10^5
        for (int i = 0; i < jumps.size(); i++) {
            System.out.println("first i value" + jumps.get(i));
            int calculatedStairValue = findLowestStartingStair(jumps, i, jumps.get(i));
            if (calculatedStairValue == 0) {
                continue;
            }
            System.out.println("calval = " + calculatedStairValue);
            minValue = Math.min(minValue, calculatedStairValue);
        }
        return minValue;

    }

    // 1, -4, -2, 3
    // 6 => 4
    // 8 => 6
    // 2 -2
    // n >1 and <10^5
    // arr of size n
    public static int findLowestStartingStair(List<Integer> jumps, int index, int stairValue) {
        if (index == jumps.size()) {
            return stairValue;
        }
        int newStairValue = stairValue + jumps.get(index);
        System.out.println("new stairval" + newStairValue);
        return findLowestStartingStair(jumps, index + 1, newStairValue);
    }
}
