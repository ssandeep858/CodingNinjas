/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class Multiplication {

    public static int multiplyTwoIntegers(int m, int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
        return m;
    }
        return m + multiplyTwoIntegers(m, n-1);
    }

    public static void main(String[] args) {
        System.out.println(multiplyTwoIntegers(5, 2));
    }
}
