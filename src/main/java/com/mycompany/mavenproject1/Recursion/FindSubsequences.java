/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */

// 2^n is the time complexity
public class FindSubsequences {
    public static String[] findSubsequences(String input) {
        if (input.length() == 0) {
            return new String[] { "" };
        }
        String temp[] = findSubsequences(input.substring(1));
        String res[] = new String[2 * temp.length];
        for (int i = 0; i < temp.length; i++) {
            res[i] = temp[i];
        }
        for (int i = 0; i < temp.length; i++) {
            res[i + temp.length] = input.charAt(0) + temp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String res[] = findSubsequences("xyz");
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
}
