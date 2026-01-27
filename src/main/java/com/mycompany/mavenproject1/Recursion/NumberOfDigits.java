/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 *
 *         We can define the steps of a recursive solution as follows:
 *         1.Base Case: A
 *         recursive function must have a terminating condition at which the
 *         function
 *         will stop calling itself. Such a condition is known as a base
 *         case. 2.
 *         Recursive Call: The recursive function will recursively invoke itself
 *         on the
 *         smaller version of problem. We need to be careful while writing this
 *         step as
 *         it is important to correctly figure out what your smaller problem is
 *         on whose
 *         solution the original problem’s solution depends.
 *         3. Small Calculation:
 *         Generally we perform a some calculation step in each recursive call.
 *         We can
 *         perform this calculation step before or after the recursive call
 *         depending
 *         upon the nature of the problem.
 */
public class NumberOfDigits {

    public static int count(int n) {
        
        if (n == 0) {
            return 0;
        }
        int small = count(n / 10);
        return small + 1;
    }

    public static void main(String[] args) {
        System.out.println(count(156));
    }
}
