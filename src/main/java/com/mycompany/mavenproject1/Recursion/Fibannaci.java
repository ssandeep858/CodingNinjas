/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class Fibannaci {
    
    public static int calculateFibannaci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        
        return calculateFibannaci(n-1)+calculateFibannaci(n-2);
    }
    
    public static void main(String[] args) {
        System.out.println(calculateFibannaci(4));
    }
    
    // 0 1 1 2 3 5 8 
}
