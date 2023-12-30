package com.mycompany.mavenproject1.ArraysPatterns;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ssand
 */
public class OutputTest {

    private static int funcTwins(int[] arr, int index) {
        // base condition when index is at second last then it should 
        if (index >= arr.length) {
            return -1;
        }

        if (arr[index] == arr[index + 1] && index <= arr.length - 2) {
            return funcTwins(arr, index + 2);

        } else {
            return arr[index];
        }

    }

    public static void funcTwins(int[] inputArr) {
        // Write your code here

        System.out.println(funcTwins(inputArr, 0));
    }

    public static void main(String[] args) {
        funcTwins(new int[]{1, 1, 2, 2, 3, 3});
    }
}
