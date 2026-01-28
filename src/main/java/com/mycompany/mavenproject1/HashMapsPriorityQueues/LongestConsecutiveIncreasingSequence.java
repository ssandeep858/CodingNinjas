package com.mycompany.mavenproject1.HashMapsPriorityQueues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveIncreasingSequence {

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        HashSet<Integer> hasSet = new HashSet<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (Integer i : arr) {
            hasSet.add(i);
        }
        System.out.println(hasSet);
        for (int i = 0; i < arr.length; i++) {
            if (!hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], i);
            }
        }
        System.out.println(hashMap);
        int maxLength = 0;
        int startElement = 0;
        int bestStartIndex = arr.length;

        for (int i = 0; i < arr.length; i++) {
            if (!hasSet.contains(arr[i] - 1)) {
                int currentElement = arr[i];
                int len = 1;

                while (hasSet.contains(currentElement + 1)) {
                    currentElement++;
                    len++;
                }

                if (len > maxLength) {
                    maxLength = len;
                    startElement = arr[i];
                    // same element can occur twice
                    bestStartIndex = hashMap.get(startElement);
                }
                if (len == maxLength) {
                    if (hashMap.get(arr[i]) < bestStartIndex) {
                        startElement = arr[i];
                        bestStartIndex = hashMap.get(arr[i]);
                    }
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        if (maxLength == 1) {
            res.add(startElement);

        } else {
            res.add(startElement);
            res.add(startElement + maxLength - 1);

        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> res = longestConsecutiveIncreasingSequence(
                new int[] { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6
                });

        System.out.println(res);
    }
}
