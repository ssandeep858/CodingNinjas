package com.mycompany.mavenproject1.ArraysPatterns;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 */
public class Fibonacci {

    public static void printFibonacciNumbers(int num) {
        int first = 0, second = 1;
        System.out.println(first);
        System.out.println(second);
        for (int i = 0; i <= num; i++) {

            int sum = first + second;
            if (sum >= 0 && sum <= num) {
                System.out.println(sum);
            }
            first = second;
            second = sum;
        }
    }

    public static void main(String[] args) {
        printFibonacciNumbers(7);
    }
// 0,1,1,2,3,5,8,13,21   
}
