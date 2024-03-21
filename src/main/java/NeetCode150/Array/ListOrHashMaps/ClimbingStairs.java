/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

/**
 *
 * @author ssingh
 */
public class ClimbingStairs {

    // array  top(8) [8  5  3  2  1] -> (top) as at one spot you can do either 1 step or 2 so each value 
    // will be sum of previous 2 because it can be one step so previous value or 2 step 2nd previous
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1; // last se last pr jaane ka ek tareeka hai 
        int second = 2;// second last se last pr sirf ek step leke jaya jaa sakta hai 
        int third = 0;
        for (int i = 1; i < n - 1; i++) {
            third = first + second;
            first= second;
            second = third;
        }
        return third;
        // 3
        // 
        //
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

}
