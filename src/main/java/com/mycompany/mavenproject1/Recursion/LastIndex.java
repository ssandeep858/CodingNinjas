/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class LastIndex {
        public static int lastIndex(int input[], int x, int startIndex) {
        if (startIndex==0) {
            return input[startIndex] == x ? startIndex : -1;
        }
        if (input[startIndex] == x) {
            return startIndex;
        }
        return lastIndex(input, x, startIndex - 1);
    }

    public static int firstlastIndexIndex(int input[], int x) {
        return lastIndex(input, x, input.length-1);
    }
    
}
