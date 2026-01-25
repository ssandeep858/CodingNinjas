package com.mycompany.mavenproject1.HashMapsPriorityQueues;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LongestSubarrayZeroSum {

    /*
     * 
     * Given an array consisting of positive and negative integers, find the length
     * of the longest subarray whose sum is zero.
     * 10
     * 95 -97 -387 -435 -5 -70 897 127 23 284
     * Sample Output 1:
     * 5
     * Explanation:
     * The five elements that form the longest subarray that sum up to zero are:
     * -387, -435, -5, -70, 897
     * Note
     * You don't have to print anything. Just complete the definition of the
     * function given and return the value accordingly.
     */
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        // Write your code here

        // here we will try to keep track of sum
        // Index: 0 1 2 3 4 5 6 7 8 9
        // Sum: 95 -2 -389 -824 -829 -899 -2 125 148 432
        // here -2 is being repeated so we will do 6 - 1 = 5
        int trackSum = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            trackSum += arr[i];

            if (trackSum == 0) {
                maxLength = i + 1;
                // start se lekr iss element tak so +1 for arr
            }

            if (hashMap.containsKey(trackSum)) {
                maxLength = Math.max(maxLength, i - hashMap.get(trackSum));
            } else {
                hashMap.put(trackSum, i);
            }
        }
        return maxLength;
    }

    public static void inplaceHeapSort(int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int index = 0;
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
    }

    public static void main(String[] args) {
        System.out.println(
                lengthOfLongestSubsetWithZeroSum(new int[] { 95, -97, -387, -435, -5, -70, 897, 127, 23, 284 }));
    }

}
