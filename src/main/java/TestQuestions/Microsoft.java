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
    public int solution(int[] A) {
        Arrays.sort(A);
        int lo = 1;
        int hi = A[A.length - 1] - A[0];
        int result = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(A, mid)) {
                result = mid;
                hi = mid - 1;
                
            } else {
                lo = mid + 1;
            }
        }

        return result;
    }

    private boolean isPossible(int[] A, int boardLength) {
        int lastPosition = A[0];
        int boardsNeeded = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - lastPosition > boardLength) {
                lastPosition = A[i - 1];
                boardsNeeded++;
            }
        }
// Check if at most 2 boards are needed
        return boardsNeeded <= 2 && A[A.length - 1] - lastPosition <= boardLength;
    }

    public static void main(String[] args) {
        Microsoft solution = new Microsoft();
        int[] A = {0, 44, 32, 30, 42, 18, 34, 16, 35};
        System.out.println("Shortest board length required: " + solution.solution(A));
    }

}
