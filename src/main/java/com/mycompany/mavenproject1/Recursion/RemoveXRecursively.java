/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class RemoveXRecursively {

 public static String replaceRecursively(String input, char x){
     if(input.length()==1 && input.charAt(0)== x){
         return "";
     }
     if(input.length()==1 && input.charAt(0)!= x){
         return input.charAt(0)+"";
     }
     return (input.charAt(0)== x ? "": input.charAt(0))  + replaceRecursively(input.substring(1), x);
 }
    public static void main(String[] args) {
        System.out.println(replaceRecursively("xxxx", 'x'));
    }
}
