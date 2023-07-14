/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class ReverseString {

    public static String reverseString(String input) {
        int len = input.length();
        if (input.length() == 1) {
            return input;
        }
        return input.charAt(len - 1) + reverseString(input.substring(0, --len));
    }
    
    public static String reverseStringOptimized(String input, int indexAt) {
        
        int i=indexAt;
        if(i==0){
            return input.charAt(i)+"";
        }
        
        return input.charAt(i)+reverseStringOptimized(input, i-1);
    }
    public static String reverseString2(String input) {
        return reverseStringOptimized(input, input.length()-1);
    }
    
    public static String reverseString3(String input) {
        if(input.length()==0){
            return "";
        }
        
        return reverseString3(input.substring(1)) + input.charAt(0);
    }
    public static void main(String[] args) {
        System.out.println(reverseString3("sandeep"));
    }

}
