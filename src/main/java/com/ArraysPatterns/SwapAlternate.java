package com.mycompany.mavenproject1.ArraysPatterns;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 */
import java.util.*;
public class SwapAlternate {

    public static void swapAlternate(int arr[]) {
        //Your code goes here
        for(int i=0;i<arr.length;){
            int temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
            i+=2;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=4;
        int arr[]=new int[4];
        int i=0;
        while(i<4){
            arr[i]=sc.nextInt();
            i++;
        }
        swapAlternate(arr);
        for(int j=0;j< arr.length;j++){
            System.out.print(arr[j]+" ");
        }
    }
}
