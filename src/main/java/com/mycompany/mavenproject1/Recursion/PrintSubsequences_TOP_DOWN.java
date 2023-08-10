/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class PrintSubsequences_TOP_DOWN {

    public static void findSubsequences(String input, String outuputSoFar) {
        if (input.length() == 0) {
            System.out.println("output is " + outuputSoFar);
            return;
        }
        //not include the first alphabet
        findSubsequences(input.substring(1), outuputSoFar);

        //include the first alphabet
        findSubsequences(input.substring(1), outuputSoFar + input.charAt(0));

    }

    public static void findSubsequences(String input) {
        findSubsequences(input, "");
    }

    public static void main(String[] args) {
        findSubsequences("xyz");
    }

}
