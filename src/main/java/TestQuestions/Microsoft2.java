/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestQuestions;

import java.util.Arrays;

/**
 *
 * @author ssingh
 */
public class Microsoft2 {

    public static int solution(int[] A) {

        // base case if no element present
        if (A.length == 0) {
            return 0;
        }
        // edge case if only one element present
        if (A.length == 1) {
            return 1;
        }

        //sorting the array to keep the hole in ascending order
        Arrays.sort(A);

        int boardLength = 0;

        if (A.length % 2 == 0) {
            for (int holeIndex = 0; holeIndex < A.length - 1; holeIndex++) {
                int currentDifference = Math.abs(A[holeIndex] - A[holeIndex + 1]);
                boardLength = Math.max(boardLength, currentDifference);
            }
        } else {
            int boardLen1 = 0;
            int boardLen2 = 0;
            for (int holeIndex = 0; holeIndex < A.length - 1; holeIndex += 2) {
                if (holeIndex == A.length - 1) {
                    break;
                }
                int currentDifference = Math.abs(A[holeIndex] - A[holeIndex + 1]);
                boardLen1 = Math.max(boardLen1, currentDifference);
            }

            for (int holeIndex = A.length - 1; holeIndex >= 0; holeIndex -= 2) {
                if (holeIndex == 0) {
                    break;
                }
                int currentDifference = Math.abs(A[holeIndex] - A[holeIndex - 1]);
                boardLen2=Math.max(boardLen2, currentDifference);
            }
            boardLength=Math.min(boardLen1, boardLen2);
        }
        return boardLength;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{11,20,15}));
    }
}
