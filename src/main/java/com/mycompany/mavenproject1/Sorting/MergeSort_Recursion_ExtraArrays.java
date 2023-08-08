/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Sorting;

/**
 *
 * @author ssingh
 */
public class MergeSort_Recursion_ExtraArrays {

    public static void merge(int arr[],int leftArray[],int[] rightArray){
        
        int leftPosition=0, rightPosition=0,mainArrayPosition=0;
        
        while (leftPosition < leftArray.length && rightPosition < rightArray.length){
            if(leftArray[leftPosition]<=rightArray[rightPosition]){
                arr[mainArrayPosition]=leftArray[leftPosition++];
            }
            else{
                arr[mainArrayPosition]=rightArray[rightPosition++];
            }
            mainArrayPosition++;
        }
        while (leftPosition < leftArray.length){
            arr[mainArrayPosition]=leftArray[leftPosition++];
            mainArrayPosition++;
        }
        while (rightPosition < rightArray.length){
            arr[mainArrayPosition]=rightArray[rightPosition++];
            mainArrayPosition++;
        }
    }
    public static void mergeSort(int[] arr) {
        // Write your code here
        if(arr.length==1){
            return;
        }
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
        int mid=(arr.length)/2;
        int[] leftArray=new int[mid];    // 0   4    9
        int[] rightArray=new int[arr.length-mid];

        for(int i=0;i<mid;i++){
            System.out.println("left array =>"+i+" "+arr[i]);
            leftArray[i]=arr[i];
        }
        for(int i=mid;i<arr.length;i++){
            System.out.println("right array =>"+(i-leftArray.length)+" "+arr[i]);
            rightArray[i-mid]=arr[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(arr, leftArray, rightArray);
    }
    public static void main(String[] args) {
        int arr[]=new int[]{11,22,12,4,9,1,4,2,22};
        mergeSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

}
