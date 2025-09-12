package com.mycompany.mavenproject1.DP;

import java.util.HashMap;

/* 
 * Byteland has a very strange monetary system.

Each Bytelandian gold coin has an integer number written on it. 
A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4. 
But these numbers are all rounded down (the banks have to make a profit).
You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.
You have one gold coin. What is the maximum amount of American dollars you can get for it?

 * Sample Input 1 :
12
Sample Output 1 :
13
Explanation of Sample Output 1 :
 You can change 12 into 6, 4 and 3, and then change these into $6 + $4 + $3 = $13.
Sample Input 2 :
2
Sample Output 1 :
2
Explanation of Sample Output 2 :
If you try changing the coin 2 into 3 smaller coins, you will get 1, 0 and 0, 
and later you can get no more than $1 out of them.
 It is better just to change the 2 coin directly into $2.
 * 
 * 
 * 
 */

/*// Why NOT use an array?
long[] dp = new long[n + 1];  // ❌ Problem!
// If n = 1,000,000,000 (1 billion)
// We'd need an array of size 1 billion!
// That's ~8GB of memory just for the array! */
public class ByteLandian {
    public static long bytelandian(long n, HashMap<Long, Long> memo) {
        // Write your code here
        if (n <= 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long maxOption1 = n;

        long maxOption2 = bytelandian(n / 2, memo) + bytelandian(n / 3, memo) + bytelandian(n / 4, memo);

        memo.put(n, Math.max(maxOption1, maxOption2));
        return memo.get(n);
    }

    public static void main(String[] args) {
        HashMap<Long, Long> memo = new HashMap<>();

        // Test cases
        System.out.println("n=12: $" + bytelandian(12, memo)); // 13
        System.out.println("n=2: $" + bytelandian(2, memo)); // 2
        System.out.println("n=24: $" + bytelandian(24, memo)); // 27
        System.out.println("n=1000: $" + bytelandian(1000, memo)); // Much larger!
    }
}
