package com.mycompany.mavenproject1.HashMapsPriorityQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Given k no. of different size arrays, which are sorted individually (in ascending order). You need to merge all the given arrays such that output array should be sorted (in ascending order).

Hint : Use Heaps.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= k <= 1000
0 <= n1, n2 <= 10000
Time Limit: 1 second
    4
    3
    1 5 9
    2
    45 90
    5
    2 6 78 100 234
    1
    0
    Sample Output 1:
    0 1 2 5 6 9 45 78 90 100 234
    2
    3
    4 13 17
    4
    5 10 11 14

 */
//  // ============= SOLUTION 2: Divide and Conquer (Merge in Pairs) =============
// Time: O(N log K), Space: O(1) excluding result - Best for memory efficiency
public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        ArrayList<Integer> result = new ArrayList<>();
        int[] currentArrayIndex = new int[input.size()];
        // base condition
        if (input == null || input.isEmpty()) {
            return result;
        }
        // Initialize heap with first element from each non-empty array
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) != null && !input.get(i).isEmpty()) {
                int tempIndex = i;
                int element = input.get(i).get(0);
                priorityQueue.add(new int[] { element, tempIndex });
                // each index will now point to next element
                currentArrayIndex[i] = 1;
            }
        }

        while (!priorityQueue.isEmpty()) {
            int currentMinElementData[] = priorityQueue.poll();
            int minElement = currentMinElementData[0];
            // Kaunsa array hai in list of list
            int whichArray = currentMinElementData[1];
            result.add(minElement);

            // after removing 1 element from PQ and adding to list now add another element
            // from same Array to pq
            if (currentArrayIndex[whichArray] < input.get(whichArray).size()) {
                int element = input.get(whichArray).get(currentArrayIndex[whichArray]);
                int index = whichArray;
                priorityQueue.add(new int[] { element, index });
                currentArrayIndex[whichArray]++;
            }
            // if one array empty then it will do the rce between the rest two

        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> r1 = new ArrayList<>();
        ArrayList<Integer> r2 = new ArrayList<>();
        ArrayList<Integer> r3 = new ArrayList<>();
        r1.add(1);
        r1.add(5);
        r1.add(9);
        r2.add(45);
        r2.add(90);
        r3.add(2);
        r3.add(6);
        r3.add(78);
        r3.add(100);
        r3.add(234);
        System.out.println(mergeKSortedArrays(new ArrayList<>(Arrays.asList(r1, r2, r3))));
    }
}
