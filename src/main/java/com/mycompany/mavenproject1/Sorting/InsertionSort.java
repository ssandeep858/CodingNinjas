/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Sorting;

/**
 *
 * @author ssingh
 */
public class InsertionSort {

    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while ( j >= 0 && arr[j] > temp) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j + 1] = temp;

        }

    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 1, 9, 1, 3, 11, 11, 2};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
