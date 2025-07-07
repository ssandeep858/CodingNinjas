package com.mycompany.mavenproject1.HashMapsPriorityQueues;

import java.util.HashMap;

/*
You are given an array of integers that contain numbers in random order. 
Write a program to find and return the number which occurs the maximum times in the given input.
If two or more elements are having the maximum frequency, return the element which occurs in the array first.
 */

public class maxFrequencyNumber {
    public static int maxFrequencyNumber(int[] arr) {

        // very imp to loop second time on ARR as we want first occuring to be printed.
        int max = -1;
        int element = arr[0];
        HashMap<Integer, Integer> HashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (HashMap.containsKey(arr[i])) {
                HashMap.put(arr[i], HashMap.get(arr[i]) + 1);
            } else {
                HashMap.put(arr[i], 1);
            }
        }
        // System.out.println(HashMap);
        for (int i = 0; i < arr.length; i++) {
            int freq = HashMap.get(arr[i]);

            if (freq > max) {
                max = freq;
                element = arr[i];
            }
        }

        return element;
    }
}
