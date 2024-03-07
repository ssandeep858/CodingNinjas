/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Sorting;

/**
 *
 * @author ssingh Given the 'start' and the 'end'' positions of the array
 * 'input'. Your task is to sort the elements between 'start' and 'end' using
 * quick sort.
 *
 *
 * Note : Make changes in the input array itself. Input format : Line 1 :
 * Integer N i.e. Array size Line 2 : Array elements (separated by space) Output
 * format : Array elements in increasing order (separated by space) Sample Input
 * 1 : 6 2 6 8 5 4 3 Sample Output 1 : 2 3 4 5 6 8
 */
public class QuickSort {

    private static void swapArray(int[] input, int startIndex, int destination) {
        int temp = input[startIndex];
        input[startIndex] = input[destination];
        input[destination] = temp;
    }

    public static void quickSort(int[] input, int startIndex, int endInedx) {
        if(startIndex>=endInedx){
            return;
        } 
        int pivot = input[endInedx];
        int leftPointer = partion(startIndex, endInedx, input, pivot);
        quickSort(input, startIndex, leftPointer-1);
        quickSort(input, leftPointer+1, endInedx);
    }

    private static int partion(int startIndex, int endInedx, int[] input, int pivot) {
        int leftPointer = startIndex;
        int rightPointer = endInedx-1;
        while (leftPointer < rightPointer) {
            while (input[leftPointer] <= pivot && leftPointer < rightPointer) {
                //swapArray(input, leftPointer, rightPointer);
                leftPointer++;
            }
            while (input[rightPointer] >= pivot && leftPointer < rightPointer) {
                //swapArray(input, leftPointer, rightPointer);
                rightPointer--;
            }
            swapArray(input, leftPointer, rightPointer);
            
        }
        swapArray(input, leftPointer, endInedx);
        return leftPointer;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 4, 9, 1, 3, 11, 11, 2};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
