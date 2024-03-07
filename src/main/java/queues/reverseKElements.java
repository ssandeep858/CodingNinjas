/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queues;

import java.util.Queue;

/**
 *
 * @author ssingh For a given queue containing all integer data, reverse the
 * first K elements.
 *
 * You have been required to make the desired change in the input queue itself.
 *
 * Sample Input 1: 5 3 1 2 3 4 5 Sample Output 1: 3 2 1 4 5 Sample Input 2: 7 7
 * 3 4 2 5 6 7 8 Sample Output 2: 8 7 6 5 2 4 3
 */
public class reverseKElements {

    public static Queue<Integer> helper(Queue<Integer> input, int k) {
        if (k == 0) {
            return input;
        } else {
            int temp = input.poll();
            helper(input, --k);
            input.add(temp);
            // 1 2 3 4 5 k = 3
            // 4 5 3 2 1
        }
        return input;
    }

    // 1 2 3 4 5
    // after first function call i have 4 5 3 2 1 
    // after second call 3 2 1 4 5 hence got the answer
    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
        // Your code goes here
        input = helper(input, k);
        // 1 2 3 4 5 k = 3
        // 4 5 3 2 1
        for (int i = 0; i < input.size() - k; i++) {
            int temp = input.poll();
            input.add(temp);
        }
        return input;
    }

}
