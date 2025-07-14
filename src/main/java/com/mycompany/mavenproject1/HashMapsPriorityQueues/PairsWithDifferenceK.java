package com.mycompany.mavenproject1.HashMapsPriorityQueues;

import java.util.HashMap;
import java.util.Map;

/*
* You are given with an array of integers and an integer K.
*  You have to find and print the count of all such pairs which have difference K.
*
*Note: Take absolute difference between the elements of the array.
    Sample Input 1 :
    4 
    5 1 2 4
    3
    Sample Output 1 :
    2
    Explanation
    (5,2) and (1,4) are the possible combinations as their absolute difference is 3.
    Sample Input 2 :
    4
    4 4 4 4 
    0
    Sample Output 2 :
    6

     
 */

public class PairsWithDifferenceK {

    // |a - b| = K ➜ a - b = K OR a - b = -K
    public static int getPairsWithDifferenceK(int arr[], int k) {
        // Write your code here
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (k == 0) {
                if (freq > 1) {
                    count += (freq * (freq - 1)) / 2;
                }
            } else {
                int target = num - k;
                // |a - b| == k means:
                // a - b = k ➜ b = a - k
                // a - b = -k ➜ b = a + k
                // not doing num + k as to avoid duplicate pairs like 5,2 and 2,5
                if (hashMap.containsKey(target)) {
                    count += freq * hashMap.get(target);
                }
            }
        }
        System.out.println(hashMap);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getPairsWithDifferenceK(new int[] { 5, 1, 2, 2, 4 }, 3));
    }

}
