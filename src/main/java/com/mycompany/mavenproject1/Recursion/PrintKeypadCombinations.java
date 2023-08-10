/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class PrintKeypadCombinations {

    public static char[] helperFunction(int number) {
        switch (number) {
            case 2:
                return new char[]{'a', 'b', 'c'};
            case 3:
                return new char[]{'d', 'e', 'f'};
            case 4:
                return new char[]{'g', 'h', 'i'};
            case 5:
                return new char[]{'j', 'k', 'l'};
            case 6:
                return new char[]{'m', 'n', 'o'};
            case 7:
                return new char[]{'p', 'q', 'r', 's'};
            case 8:
                return new char[]{'t', 'u', 'v'};
            case 9:
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return new char[]{};
        }
    }

    public static void keypad(int n) {
        keypad(n, "");
    }

    public static void keypad(int n, String outputSoFar) {
        if(n==0){
            System.out.println(outputSoFar);
            return;
        }
        // call helper to get 2..3..4(options of last digit)
        char arr[]=helperFunction(n%10);
        
        for( int i=0;i<arr.length;i++){
            keypad(n/10, arr[i]+outputSoFar);
        }
    }
    
    public static void main(String[] args) {
        keypad(23);
    }
}
