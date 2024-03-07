/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class Palindrome {

    public static boolean isPalindrome(String input) {

        if (input.length() == 1 || input.length()==0 ) {
            return true;
        }
        if (input.charAt(0) != input.charAt(input.length()-1)) 
            return false;
        return isPalindrome(input.substring(1, input.length()-1));
    }

    public static void main(String[] args) {
       
        System.out.println(isPalindrome("kayak"));
    }

}
