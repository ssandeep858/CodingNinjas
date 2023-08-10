package com.mycompany.mavenproject1.ArraysPatterns;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 * Sample Input 2:
 *
 * 2
 * 4
 * 5
 * Sample Output 2:
 ****
 ***
 **
 *
 *
 *****
 ****
 ***
 **
 *
 */
public class YetanotherPattern {
    public static void ninjaPuzzle(int n) {
        int numOfRows=n;
        for(int i=1;i<=numOfRows;i++){
            for(int j=1;j<=numOfRows;j++){
               if(i-j>0){
                   System.out.print(" ");
               }
               else{
                   System.out.print("*");
               }
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        ninjaPuzzle(4);
    }
}
