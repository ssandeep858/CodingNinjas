package com.mycompany.mavenproject1.HashMapsPriorityQueues;

import java.util.HashMap;

/*
 * Problem statement
Given a random integer array A of size N. 
Find and print the count of pair of elements in the array which sum up to 0.
Note:
Array A can contain duplicate elements as well.
 */
public class pairsumAndPrintIntersection {
    public static int PairSum(int[] input, int size) {
        int count = 0;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (hashmap.containsKey(-input[i])) {
                count += hashmap.get(-input[i]);
            }
            if (hashmap.containsKey(input[i])) {
                hashmap.put(input[i], hashmap.get(input[i]) + 1);
            } else {
                hashmap.put(input[i], 1);
            }
            System.out.println(hashmap);
        }
        return count;
    }

    /*
     * 
     * You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M,
     * respectively. You need to print their intersection; An intersection for this
     * problem can be defined when both the arrays/lists contain a particular value
     * or to put it in other words, when there is a common value that exists in both
     * the arrays/lists.
     * 
     * Note :
     * Input arrays/lists can contain duplicate elements.
     * 
     * The intersection elements printed would be in the order they appear in the
     * second array/list (ARR2).
     */
    public static void printIntersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            hashMap.put(arr1[i], hashMap.getOrDefault(arr1[i], 0) + 1);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (hashMap.containsKey(arr2[i])) {
                System.out.println(arr2[i]);

                // very important change the hashmap so it doesn't print more than expected
                // element
                hashMap.put(arr2[i], hashMap.getOrDefault(arr2[i], 0) - 1);
                if (hashMap.get(arr2[i]) == 0) {
                    hashMap.remove(arr2[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(PairSum(new int[] { 2, 1, -2, 2, 3 }, 5));
    }
}
