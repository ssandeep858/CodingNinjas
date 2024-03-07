/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ssingh
 */
public class CiscoAssesment {

    // print mode and if more than one mode then print the lowest mode element
    private static void printMode(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }
        System.out.println(hm);
        int modeElement = Integer.MAX_VALUE;
        int frequency = 1;
        for (Map.Entry<Integer, Integer> h : hm.entrySet()) {
            if (h.getValue() > 1 && h.getValue() >= frequency) {
                if (modeElement > h.getKey()) {
                    frequency = h.getValue();
                    modeElement = h.getKey();
                }
            }
        }
        System.out.println(frequency > 1 ? modeElement : -1);
    }

    // print -1 if all twins else print the number that is not twin.  
    //112233
    private static int funcTwins(String input) {
        if (input.length() == 1) {
            return Integer.parseInt(input.charAt(0) + "");
        }
        if (input.length() == 2 && input.charAt(0) == input.charAt(1)) {
            return -1;
        }

        if (input.charAt(0) == input.charAt(1)) {
            return funcTwins(input.substring(2));
        } else {
            return Integer.parseInt(input.charAt(0) + "");
        }

    }

    public static void funcTwins(int[] inputArr) {
        // Write your code here
        String input = "";
        for (int i = 0; i < inputArr.length; i++) {
            input += inputArr[i];
        }
        System.out.println(funcTwins(input));
    }

    public static int funcTwins(int[] arr, int justIgnoreMe) {
        // Write your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }
        int lowElement = Integer.MAX_VALUE;
        int freq = 0;
        for (Map.Entry<Integer, Integer> h : hm.entrySet()) {
            if (h.getValue() == 1) {
                if (lowElement > h.getKey()) {
                    freq = h.getValue();
                    lowElement = h.getKey();
                }
            }
        }
        System.out.println(hm);
        return lowElement;
    }

    public static int binarySearch(int input[], int element, int startIndex, int midIndex, int endIndex) {
        if (input[midIndex] == element) {
            return midIndex;
        }
        while (startIndex < endIndex) {
            if (element > input[midIndex]) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
            midIndex = (startIndex + endIndex) / 2;
            return binarySearch(input, element, startIndex, midIndex, endIndex);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,3,4,5,6}, 33, 0, 2, 5));
        //printMode(new int[]{3, 3, 2, 2, 1, 1, 4});
        //int res = funcTwins(new int[]{1, 1, 3, 3, 4}, 0);
        //System.out.println(res);
    }
}
