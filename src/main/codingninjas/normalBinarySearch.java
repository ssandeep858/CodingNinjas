/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.codingninjas;

/**
 *
 * @author ssand
 */
 class normalBinarySearch {

    /**
     * @param args the command line arguments
     */
     
     public static int binarySearch(int[] arr, int x) {
        // Your co-de goes here
        int low, upper, mid;
        int length = arr.length - 1;
        low = 0;
        upper = length;
        mid = (upper + low) / 2;
        return binarySearchCalculate(arr, low, mid, upper, x);
    }

    public static int binarySearchCalculate(int[] arr, int low, int mid, int upper, int x) {
        if (low > upper) {
            return -1;
        } else if (x == arr[mid]) {
            return mid;
        } else if (x > arr[mid]) {
            low = mid + 1;
            mid = (low + upper) / 2;
            return binarySearchCalculate(arr, low, mid, upper, x);
        } else if (x < arr[mid]) {
            upper = mid - 1;
            mid = (low + upper) / 2;
            return binarySearchCalculate(arr, low, mid, upper, x);
        }
        return 0;
    }
}
