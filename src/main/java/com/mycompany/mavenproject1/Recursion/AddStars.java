/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class AddStars {

    public static String addStars(String s) {
        // Write your code here
        if (s.length() == 1) {
            return s;
        }
        String res = addStars(s.substring(1));
        if (s.charAt(0) == s.charAt(1)) {
            return s.charAt(0) + "*" + res;
        } else {
            return s.charAt(0) + res;
        }

    }

    public static void main(String[] args) {
        System.out.println(addStars("aaaa"));
    }

}
