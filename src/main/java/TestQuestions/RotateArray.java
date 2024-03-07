/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestQuestions;

import java.util.*;

/**
 *
 * @author ssingh
 */
public class RotateArray {

    // using extra space
    public static void rotate1(int[] arr, int d) {
        //Your code goes here
        int[] tempArray = new int[d];
        for (int i = 0; i < d; i++) {
            tempArray[i] = arr[i];
        }
        for (int i = 0; i < arr.length - d; i++) {
            arr[i] = arr[i + d];
        }
        for (int i = 0; i < d; i++) {
            arr[arr.length - d + i] = tempArray[i];
        }
    }

    // no extra space or memory and least complexity 
    public static void rotate(int[] arr, int d) {
        //Your code goes here
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < (arr.length - d) / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - d - 1 - i];
            arr[arr.length - d - 1 - i] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

        for (int i = 0; i < d / 2; i++) {
            int temp = arr[arr.length - d + i];
            arr[arr.length - d + i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        //rotate(arr, 2);
        rotate(arr, 2);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
