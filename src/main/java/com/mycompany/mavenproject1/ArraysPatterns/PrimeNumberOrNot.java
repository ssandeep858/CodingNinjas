package com.mycompany.mavenproject1.ArraysPatterns;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class PrimeNumberOrNot {
    public static boolean isPrime(int num){
        for ( int i=2;i <= num/2;i++){
            if(num<=1)
                return false;
            else if(num%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPrime(2));
    }
}
