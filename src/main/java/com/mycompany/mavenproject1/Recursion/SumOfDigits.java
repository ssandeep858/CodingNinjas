/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class SumOfDigits {
    public static int sumOfDigitsOld( int k){
        if(k/10==0){
            return k;
        }
        
        return Integer.parseInt(String.valueOf(k).charAt(0)+"") + sumOfDigits(Integer.parseInt(String.valueOf(k).substring(1)));
    }
    
    public static int sumOfDigits( int k){
        if(k==0){
            return k;
        }
        
        return k%10 + sumOfDigits(k/10);
    }
    public static void main(String[] args) {
        System.out.println(sumOfDigits(12345));
    }
}
