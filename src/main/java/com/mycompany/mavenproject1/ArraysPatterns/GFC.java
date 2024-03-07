package com.mycompany.mavenproject1.ArraysPatterns;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 */
public class GFC {

    public static void findGcd(int x, int y) {
        // Write your code here
        int num1 = x, num2 = y;
        int loopMax = num1 < num2 ? num1 : num2;
        int gcd = 1;
        for (int i = 2; i <= loopMax; i++) {
            System.out.println("i is " + i);
            if (((num1 % i) == 0) && ((num2 % i) == 0)) {
                //System.out.println("i is " + i + " num 1=>" + num1 + "num2 => " + num2);
                gcd = i;
            }
        }
        System.out.println("gcd is =" + gcd);
    }

    public static void main(String[] args) {
        findGcd(8, 32);
    }

}
