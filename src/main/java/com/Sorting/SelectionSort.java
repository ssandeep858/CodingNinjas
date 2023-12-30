/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Sorting;

/**
 *
 * @author ssingh
 */
public class SelectionSort {

    
    // pehle ko pakadkr bache hue mein sabse chota dhundho aur swap krdo. 
    public static void selectionSort(int arr[]) {
        
        for(int i =0;i<arr.length;i++){
            int min=arr[i];
            int pos= i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<min){
                    min=arr[j];
                    pos=j;
                }
            }
            arr[pos]=arr[i];
            arr[i]=min;
        }
    }

    public static void main(String[] args) {

        int arr[] = new int[]{3, 4, 9, 1, 3, 11, 11, 2};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
