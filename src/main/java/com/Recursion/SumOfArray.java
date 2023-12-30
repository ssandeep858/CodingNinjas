/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class SumOfArray {

    public static int sum(int input[]) {
        if (input.length == 1) {
            return input[0];
        }
        int smallProblem[] = new int[input.length - 1];

        for (int i = 1; i < input.length; i++) {
            smallProblem[i - 1] = input[i];
        }
        return input[0] + sum(smallProblem);
    }
    public static int sum_optimized(int input[],int startIndex) {
        if(startIndex==input.length-1){
            return input[startIndex];
        }
        return input[startIndex]+sum_optimized(input, startIndex+1);
        
        
    }
    public static void main(String[] args) {

        System.out.println(sum_optimized(new int[]{1, 2, 3, 4, 5},0));
    }

}
