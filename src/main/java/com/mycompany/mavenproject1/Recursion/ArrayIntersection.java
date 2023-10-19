/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
import java.util.Arrays;

//You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.
//Note :
//Input arrays/lists can contain duplicate elements.
//
//The intersection elements printed would be in ascending order.
//
//
//Input format :
//The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
//
//The first line of each test case or query contains an integer 'N' representing the size of the first array/list.
//
//The second line contains 'N' single space separated integers representing the elements of the first the array/list.
//
//The third line contains an integer 'M' representing the size of the second array/list.
//
//The fourth line contains 'M' single space separated integers representing the elements of the second array/list.
//Output format :
//For each test case, print the intersection elements in a row, separated by a single space.
//
//Output for every test case will be printed in a separate line.
//Constraints :
//1 <= t <= 10^2
//0 <= N <= 10^6
//0 <= M <= 10^6
//
//Time Limit: 1 sec
//Sample Input 1 :
//2
//6
//2 6 8 5 4 3
//4
//2 3 4 7
//2
//10 10
//1
//10
//Sample Output 1 :
//2 3 4
//10
public class ArrayIntersection {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void intersection(int[] arr1, int[] arr2) {
        //Your code goes here
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int array1Index = 0;
        int array2Index = 0;
        while (array1Index < arr1.length && array2Index < arr2.length) {
            if (arr1[array1Index] < arr2[array2Index]) {
                array1Index++;
            } else if (arr1[array1Index] > arr2[array2Index]) {
                array2Index++;
            } else {
                System.out.print(arr1[array1Index] + " ");
                array1Index++;
                array2Index++;
            }
        }
    }

    public static void main(String[] args) {
        intersection(new int[]{6, 9, 8, 5}, new int[]{9, 2, 4, 1, 8});
    }
}
