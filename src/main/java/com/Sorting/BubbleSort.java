/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Sorting;

/**
 *
 * @author ssingh
 */
public class BubbleSort {

    
    // complexity of bubble sort => O(n2)
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            // no temp here because hum ek ko pakadkr baaki sabse compare nahi karengein
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 4, 9, 1, 3, 11, 11, 2};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
