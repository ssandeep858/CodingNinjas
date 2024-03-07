/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh Given an integer array (of length n), find and return all the
 * subsets of input array. Subsets are of length varying from 0 to n, that
 * contain elements of the array. But the order of elements should remain same
 * as in the input array.
 *
 *
 * Note : The order of subsets are not important.
 *
 *
 * Input format :
 *
 * Line 1 : Size of array
 *
 * Line 2 : Array elements (separated by space)
 *
 * Sample Input: 3 15 20 12 Sample Output: [] (this just represents an empty
 * array, don't worry about the square brackets) 12 20 20 12 15 15 12 15 20 15
 * 20 12
 */
import java.util.*;

public class SubsetsOfArray {

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

    public static int[][] subsets(int input[], int startIndex) {
        if (startIndex == input.length) {
            //number of rows 1 and column 0 as empty
            return new int[1][0];
        }
        int[][] smallerOutput = subsets(input, startIndex + 1);

        int res[][] = new int[2 * smallerOutput.length][];
        for (int i = 0; i < smallerOutput.length; i++) {
            // res ka bataya hai ki kitne rows hai lekin columns bhi toh define krne padengein
            res[i] = new int[smallerOutput[i].length];
            for (int j = 0; j < smallerOutput[i].length; j++) {
                res[i][j] = smallerOutput[i][j];
            }
        }
        for (int i = 0; i < smallerOutput.length; i++) {
            res[i+smallerOutput.length] = new int[smallerOutput[i].length + 1];
            res[i+smallerOutput.length][0] = input[startIndex];
            for (int j = 1; j <= smallerOutput[i].length; j++) {
                res[i+smallerOutput.length][j] = smallerOutput[i][j - 1];
            }
        }

        return res;
    }

    public static int[][] subsets(int input[]) {
        // Write your code here
        int res[][] = subsets(input, 0);
        return res;
    }

    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3}, {2, 3}};
        int ar[] = {1, 2, 3};
        //ar=Arrays.copyOfRange(ar, 0, ar.length-1);
        int[][] res = subsets(ar);
        print(res);

    }
}
