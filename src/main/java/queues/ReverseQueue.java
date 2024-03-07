/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queues;

import java.util.Queue;

/**
 *
 * @author ssingh You have been given a queue that can store integers as the
 * data. You are required to write a function that reverses the populated queue
 * itself without using any other data structures. Sample Input 1: 1 6 1 2 3 4 5
 * 10 Note: Here, 1 is at the front and 10 is at the rear of the queue.
 */
public class ReverseQueue {

    public static void reverseQueue(Queue<Integer> input) {
        //Your code goes here
        if (input.size() == 0) {
            return;
        }
        int temp = input.poll();
        reverseQueue(input);
        input.add(temp);
    }

}
