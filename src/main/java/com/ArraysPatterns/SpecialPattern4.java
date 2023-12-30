package com.mycompany.mavenproject1.ArraysPatterns;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * 4444
 * 333
 * 22
 * 1
 */
import java.util.*;

public class SpecialPattern4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfRows = sc.nextInt();
        int row = 1;
        while (row <= numOfRows) {
            int col = 1;
            int input = 1;
            while (col <= numOfRows) {
                if (col <= numOfRows - row) {
                    System.out.print(" ");
                } else {
                    System.out.print(input);
                    if(input==row){
                        int rev=input;
                        while(((rev-1)>0)){
                            System.out.print(--rev);
                        }
                    }
                    input++;
                }
                col++;
            }
            System.out.println("");
            row++;
        }
    }
}
