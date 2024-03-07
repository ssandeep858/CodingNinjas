/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class FirstIndex {

    public static int firstIndex(int input[], int x, int startIndex) {
        if (input.length - 1 == startIndex) {
            return input[startIndex] == x ? startIndex : -1;
        }
        if (input[startIndex] == x) {
            return startIndex;
        }
        return firstIndex(input, x, startIndex + 1);
    }

    public static int firstIndex(int input[], int x) {
        return firstIndex(input, x, 0);
    }

    public static void main(String[] args) {
        System.out.println(firstIndex(new int[]{1, 2, 3, 2, 4}, 2));
    }

}
