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

    // array [ 8  5  3  2  1  1 ] as at one spot you can do either 1 step or 2 so each value 
    // will be sum of previous 2 because it can be one step so previous value or 2 step 2nd previous
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1; // last se last pr jaane ka ek tareeka hai 
        int second = 1;// second last se last pr sirf ek step leke jaya jaa sakta hai 
        int third = 0;
        for (int i = 0; i < n - 1; i++) {
            third = first + second;
            second = first;
            first = third;
        }
        return third;

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

}
