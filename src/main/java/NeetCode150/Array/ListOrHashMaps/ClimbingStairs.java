/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

/**
 *
 * @author ssingh
 *         /*
 *         Problem: Climbing Stairs
 *
 *         You are climbing a staircase with n steps.
 *         Each time, you can climb either 1 step or 2 steps.
 *
 *         Return the total number of distinct ways to reach the top.
 *
 *         Example 1:
 *         Input: n = 2
 *         Output: 2
 *         Explanation:
 *         1 + 1
 *         2
 *
 *         Example 2:
 *         Input: n = 3
 *         Output: 3
 *         Explanation:
 *         1 + 1 + 1
 *         1 + 2
 *         2 + 1
 */
public class ClimbingStairs {

    // array top(8) [8 5 3 2 1] -> (top) as at one spot you can do either 1 step or
    // 2 so each value
    // will be sum of previous 2 because it can be one step so previous value or 2
    // step 2nd previous
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1; // last se last pr jaane ka ek tareeka hai
        int second = 2;// second last se last pr sirf ek step leke jaya jaa sakta hai
        int third = 0;
        for (int i = 1; i < n - 1; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    public static int climbStairsRecursive(int n) {
        // because 2 step pr can do 1+1 or 2 so 2 ways.
        if (n <= 2)
            return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairsRecursiveMemoization(int n, int[] mem) {
        // because 2 step pr can do 1+1 or 2 so 2 ways.
        if (n <= 2) {
            mem[n] = n;
            return n;
        }
        if (mem[n] != 0) {
            return mem[n];
        }
        mem[n] = climbStairsRecursiveMemoization(n - 1, mem) + climbStairsRecursiveMemoization(n - 2, mem);
        return mem[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
        int[] mem = new int[10 + 1];
        System.out.println(climbStairsRecursiveMemoization(10, mem));
    }

}
