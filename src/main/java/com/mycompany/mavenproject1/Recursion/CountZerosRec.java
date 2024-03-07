/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class CountZerosRec {

    public static int countZerosRec(String input, int index) {
        if (index == input.length() - 1 && input.charAt(index) == '0') {
            return 1;
        }
        if (index == input.length() - 1 && input.charAt(index) != '0') {
            return 0;
        }
        if (input.charAt(index) == '0') {
            return 1 + countZerosRec(input, index + 1);
        } else {
            return countZerosRec(input, index + 1);
        }
    }

    public static int countZerosRec(int input) {
        System.out.println(" temp value is " + input);
        return countZerosRec(String.valueOf(input), 0);
    }

    public static String removeLeadingZeroes(String input) {
        if (input.length() == 1 && input.charAt(0) == '0') {
            return "0";
        }
        if (input.charAt(0) != '0') {
            return input;
        } else {
            return removeLeadingZeroes(input.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(countZerosRec(Integer.valueOf(removeLeadingZeroes("012345"))));
    }
}
