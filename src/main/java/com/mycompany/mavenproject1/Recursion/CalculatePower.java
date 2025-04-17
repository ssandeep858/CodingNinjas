/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 *
 * Write a program to find x to the power n (i.e. x^n). Take x and n from the
 * user. You need to return the answer. Do this recursively. Input format : Two
 * integers x and n (separated by space) Output Format : x^n (i.e. x raise to
 * the power n) Constraints : 0 <= x <= 30 0 <= n <= 30 Sample Input 1 : 3 4
 * Sample Output 1 : 81
 */
public class CalculatePower {

    public static int power(int x, int n) {
        if (n < 1) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        return x * power(x, n-1);
    }

    public static void main(String[] args) {
        System.out.println(power(2, 5));
    }

}
