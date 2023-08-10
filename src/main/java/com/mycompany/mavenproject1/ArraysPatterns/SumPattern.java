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
public class SumPattern {

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int numOfRows = sc.nextInt();
        int row, col;
        for (row = 1; row <= numOfRows; row++) {
            int sum = 0;
            for (col = 1; col <= row; col++) {
                System.out.print(col);
                sum += col;
                if (col != row) {
                    System.out.print("+");
                }
            }
            System.out.println("=" + sum);
        }
    }
}
