package com.mycompany.mavenproject1.ArraysPatterns;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 */
public class PrintAllPairs {
    public static void printPairs( int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print(arr[i]+" "+ arr[j]+ "   ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        printPairs(new int[]{1,4,7,6,5});
    }
    
}
