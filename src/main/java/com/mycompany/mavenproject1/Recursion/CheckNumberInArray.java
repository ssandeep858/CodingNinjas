/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class CheckNumberInArray {

    public static boolean checkNumber(int input[], int x) {
        
        if(input.length==1){
            return input[0]==x;
        }
        int[] small = new int[input.length - 1];
        for (int i = 1; i < input.length; i++) {
            small[i - 1] = input[i];
        }
        boolean res = checkNumber(small, x);
        if (res) {
            return true;
        } else if (input[0] == x) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean checkNumber_optimized(int input[], int x,int startIndex) {
        if(input.length-1==startIndex){
           return input[startIndex]==x; 
        }
        if(input[startIndex]==x)
            return true;
        return checkNumber_optimized(input, x,startIndex+1);
    }
    
    public static void main(String[] args) {
        System.out.println(checkNumber_optimized(new int[]{1, 2, 3}, 2,0));
    }
}
