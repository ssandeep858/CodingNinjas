/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh Print Keypad Combinations Code Send Feedback Given an integer
 * n, using phone keypad find out and print all the possible strings that can be
 * made using digits of input n. Note : The order of strings are not important.
 * Just print different strings in new lines. Input Format : Integer n Output
 * Format : All possible strings in different lines Constraints : 1 <= n <= 10^6
 * Sample Input: 23 Sample Output: ad ae af bd be bf cd ce cf
 */
public class returnKeypadCombinations {

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

    public static String[] keypad(int n) {
        // Write your code here
        if (n == 0) {
            return new String[]{""};
        }
        String temp[] = keypad(n / 10);
        char arr[] = helperFunction(n % 10);
        String resultingArray[] = new String[arr.length * temp.length];
        int resultingArrayIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                resultingArray[resultingArrayIndex++] = temp[j] + "" + arr[i];
            }
        }
        return resultingArray;
    }

    public static void printKeypad(int input) {
        String res[] = keypad(input);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static void main(String[] args) {
        printKeypad(23);
    }
}
