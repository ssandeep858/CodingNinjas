/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class FindGeometricSum {

    
    // 1 + 1/2^1 +1/2^2 + 1/2^3 + 1/2^4 + 1/2^5 ......... 
    
    public static double findGeometricSum(int k) {
        // Write your code here
        if (k == 0) {
            return 1;
        }
        return 1/ Math.pow( 2, k) + findGeometricSum(k - 1);
    }

    public static void main(String[] args) {
        System.out.println(findGeometricSum(0));
    }
}
