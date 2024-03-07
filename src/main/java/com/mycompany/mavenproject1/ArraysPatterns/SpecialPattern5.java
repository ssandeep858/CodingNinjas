package com.mycompany.mavenproject1.ArraysPatterns;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
    1
   232
  34543
 4567654
567898765
 */
import java.util.*;
public class SpecialPattern5 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfRows = sc.nextInt();
        int row = 1;
        while (row <= numOfRows) {
            int col = 1;
            int input = row;
            while (col <= numOfRows) {
                if (col <= numOfRows - row) {
                    System.out.print(" ");
                } else {
                    System.out.print(input);
                    if((2*row)-1==input){
                        int rev=input;
                        while(((rev-1)>=row)){
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
