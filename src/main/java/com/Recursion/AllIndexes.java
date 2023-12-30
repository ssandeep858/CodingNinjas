/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

import java.awt.BorderLayout;

/**
 *
 * @author ssingh
 */
public class AllIndexes {

    public static int[] allIndexes(int input[], int x, int index, int foundSoFar) {
        if (index == input.length) {
            return new int[foundSoFar];
        }
        if (input[index] == x) {
            int res[] = allIndexes(input, x, index + 1, foundSoFar + 1);
            res[foundSoFar] = index;
            System.out.println("fsf"+foundSoFar+" index"+index);
            return res;
        } else {
            int res[] = allIndexes(input, x, index + 1, foundSoFar);
            return res;
        }
    }

    public static int[] allIndexes(int input[], int x) {
        return allIndexes(input, x, 0, 0);
    }

    public static void main(String[] args) {
        char c='a';
        System.out.println(c-97);
        int res[] = allIndexes(new int[]{1, 2, 3, 2, 4, 2}, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
