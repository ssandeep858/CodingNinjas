/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh Return subsets sum to K Send Feedback Given an array A of size
 * n and an integer K, return all subsets of A which sum to K. Subsets are of
 * length varying from 0 to n, that contain elements of the array. But the order
 * of elements should remain same as in the input array.
 *
 *
 * Note : The order of subsets are not important.
 *
 *
 * Input format : Line 1 : Integer n, Size of input array Line 2 : Array
 * elements separated by space Line 3 : K Constraints : 1 <= n <= 20 Sample
 * Input : 9 5 12 3 17 1 18 15 3 17 6 Sample Output : 3 3 5 1
 */
public class SubsetsSumK {

    static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] != 0) {
                        System.out.print(arr[i][j] + " ");
                    }
                }
            }
            System.out.println("");
        }
    }

    public static int[][] subsetsSumK(int input[], int k, int startIndex) {
        // Write your code here

        if (k <= 0 || startIndex >= input.length) {
            if (k == 0) {
                return new int[1][0];
            }
            return new int[0][0];
        }
        // first we put the current element into the output
        int[][] res1 = subsetsSumK(input, k - input[startIndex], startIndex + 1);
        // then we do not put the current element into the output
        int res2[][] = subsetsSumK(input, k, startIndex + 1);

        int finalRes[][] = new int[res1.length + res2.length][];

        for (int i = 0; i < res2.length; i++) {
            finalRes[i] = new int[res2[i].length];
            for (int j = 0; j < res2[i].length; j++) {
                finalRes[i][j] = res2[i][j];
            }
        }

        for (int i = 0; i < res1.length; i++) {
            finalRes[i + res2.length] = new int[res1[i].length + 1];
            finalRes[i + res2.length][0] = input[startIndex];
            for (int j = 1; j <= res1[i].length; j++) {
                finalRes[i + res2.length][j] = res1[i][j - 1];
            }
        }

        return finalRes;
    }

    public static int[][] subsetsSumK(int input[], int k) {
        // Write your code here

        int temp[][] = subsetsSumK(input, k, 0);
        return temp;
    }

    public static void main(String[] args) {
        int res[][] = subsetsSumK(new int[]{17, 18, 6, 11, 2, 4}, 6);
        print(res);

    }

}
