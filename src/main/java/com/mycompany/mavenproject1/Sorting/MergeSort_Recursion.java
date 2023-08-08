/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Sorting;

/**
 *
 * @author ssingh
 */
public class MergeSort_Recursion {

    public static void merge(int arr[], int startIndex, int endIndex) {
        // yaha pr ek chota array ka tukda aaega 
        int tempArray[] = new int[endIndex - startIndex + 1];
        // temp array banaya hai jismein ye chote aaye hue array ka sorted version hoga
        int tempArrayIndex = 0;

        //ab loop ke liye temp variables declare kro
        int i = startIndex;
        int mid = (startIndex + endIndex) / 2;
        int j = mid + 1;
        //loop aese lagega ki aaye hue array ko hi beech mein se tod do
        //kyuki agr 4 ka array tuta hoga neeche to 2-2 ke array judkr 4 mein merge hone aae hongein isliye 
        // merge hone ke liye 1 ka 3rd se aur 2nd k 4th se compare hoga in 2-2 short arrays
        while (i <= mid && j <= endIndex) {
            if (arr[i] <= arr[j]) {
                tempArray[tempArrayIndex++] = arr[i++];
            } else {
                tempArray[tempArrayIndex++] = arr[j++];
            }
        }
        while (i <= mid) {
            tempArray[tempArrayIndex++] = arr[i++];
        }
        while (j <= endIndex) {
            tempArray[tempArrayIndex++] = arr[j++];
        }
        
        // beech mein agr koi array ki click aae hogi to main aray mein add krne ke liye index hoga temp arrya ka start + function ka startIndex input
//        System.out.println("inputs of this function are "+startIndex+" "+endIndex);
//         for (int h = 0; h < tempArray.length; h++) {
//            System.out.print(tempArray[h] + " ");
//        }
//         System.out.println("");
//         
        
        for(int t=0;t<tempArray.length;t++){
            arr[t+startIndex]=tempArray[t];
        }
    }

    public static void mergeSort(int[] arr, int startIndex, int endIndex) {
        // Write your code here
        if (startIndex >= endIndex) {
            return;
        }
        int mid = (startIndex + endIndex) / 2;
        mergeSort(arr, startIndex, mid);
        mergeSort(arr, mid + 1, endIndex);
        merge(arr, startIndex, endIndex);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{11, 2, 1, 4};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
