/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class RemoveConsecutiveDuplicates {

    public static String removeConsecutiveDuplicates(String s) {
        if (s.length() == 1) {
            return s;
        }

        if (s.charAt(0) == s.charAt(1)) {
            return removeConsecutiveDuplicates(s.substring(1));
        } else {
            return (s.charAt(0) + "") + removeConsecutiveDuplicates(s.substring(1));
        }
    }

    // p p p
    public static void main(String[] args) {
        System.out.println(removeConsecutiveDuplicates("ssaanddeeppp"));
    }
}
