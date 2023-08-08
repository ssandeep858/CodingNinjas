/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class replacePi {

    public static String replace(String input) {
        // Write your code here
        if (input.length() == 1) {
            return input;
        }
        String temp = replace(input.substring(1));
        if (input.charAt(0) == 'p' && temp.charAt(0) == 'i') {

            return "3.14" + temp.substring(1);
        } else {
            return input.charAt(0) + temp;
        }
    }
    public static void main(String[] args) {
        System.out.println(replace("xpixpi"));
    }

}
