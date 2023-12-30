/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class RemoveX {

    public static String removeX(String input) {
        if(input.length()==1 && input.charAt(0)=='x'){
            return "";
        }
        else if(input.length()==1 && input.charAt(0)!='x'){
            return input;
        }
        String temp= removeX(input.substring(1));
        if(input.charAt(0)=='x'){
            return temp;
        }
        else return input.charAt(0)+temp;
    }

    public static void main(String[] args) {
        System.out.println(removeX("xxabsd"));
    }

}
