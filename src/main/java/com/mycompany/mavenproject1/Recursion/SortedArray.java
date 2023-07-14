/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class SortedArray {

    public static boolean checkSorted(int[] arr) {
        if (arr.length == 1) {
            return true;
        }
        int smallProblem[] = new int[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            smallProblem[i - 1] = arr[i];
        }
        boolean result = checkSorted(smallProblem);
        if (!result) {
            return false;
        }
        if (arr[0] <= arr[1]) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkSorted2(int[] arr) {
        if (arr.length == 1) {
            return true;
        }
        if (arr[0] > arr[1]) {
            return true;
        } 
        int smallProblem[] = new int[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            smallProblem[i - 1] = arr[i];
        }
        boolean result = checkSorted(smallProblem);
        return result;
    }
    public static boolean checkSorted_optimized(int[] arr,int startIndex) {
        if(startIndex==arr.length-1){
            return true;
        }
        if(arr[startIndex]>arr[startIndex+1]){
            return false;
        }
        boolean res=checkSorted_optimized(arr, startIndex+1);
        return res;
    }
    public static void main(String[] args) {
        System.out.println(checkSorted_optimized(new int[]{1, 2, 4, 4, 5, 6},0));
    }

}
