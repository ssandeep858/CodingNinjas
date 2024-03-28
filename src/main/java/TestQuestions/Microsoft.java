/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author ssingh
 */
public class Microsoft {
    // Implement your solution here

    
    // sort the array and find the absolute difference between the two adjacent points 
    // and return the max difference ( max as it will be the minimum length of board required to cover all holes )
    public static int solution(int[] A) {
        
        // solution in O(n) time
        // calculate the total len of array
        int totalLen = A.length;
        //let us sort the vales of array for the range
        Arrays.sort(A);
        
        // variable to store the minimum
        int maxDistance = 0;

        // even length case
        if (totalLen % 2 == 0) {
            //loop and calculate the absolute difference between adjacent elements of array
            for (int i = 0; i < totalLen - 1; i += 2) {
                int currentDiff = Math.abs(A[i] - A[i + 1]);
                maxDistance = Math.max(maxDistance, currentDiff);
                // now we have which distance between the two elments is the maximum one  tobe able to cover all holes
            }
        } //odd length case
        else { // If the length of the array is odd
            // Set max to the difference between the first and last elements
            maxDistance = Math.abs(A[0] - A[totalLen - 1]);
            // Iterate through the array in steps of 2, starting from index 1
            for (int i = 1; i < totalLen - 1; i += 2) {
                // Calculate the absolute difference between adjacent elements
                int diff = Math.abs(A[i] - A[i + 1]);
                // Update the maximum difference
                maxDistance = Math.max(maxDistance, diff);
            }
            // Also consider the difference between the first and second elements
            maxDistance = Math.max(maxDistance, Math.abs(A[0] - A[1]));
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,44,32,30,42,18,34,16,35}));
    }

}
