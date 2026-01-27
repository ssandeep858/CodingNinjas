package com.mycompany.mavenproject1.HashMapsPriorityQueues;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Problem Statement: Sort a K-Sorted Array
You are given an array of n integers where each element is at most k positions away from its target position in the sorted array. 
Your task is to sort this array efficiently.
✅ Input:
An integer array arr[] of size n.
An integer k (where k < n), representing how far each element is from its correct sorted position.
✅ Output:
Return or print the sorted array.
 */
public class KSortedArray {
    public static void KSortedArr(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            arr[i - k] = pq.poll();
            pq.add(arr[i]);
        }

        for (int i = arr.length - k; i < arr.length; i++) {
            arr[i] = pq.poll();
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        int arr[] = new int[] { 2, 1, 4, 3, 6, 5, 8, 7 };
        KSortedArr(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

}
