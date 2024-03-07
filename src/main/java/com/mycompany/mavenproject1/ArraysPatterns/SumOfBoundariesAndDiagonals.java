/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.ArraysPatterns;

/**
 *
 * @author ssingh For a given two-dimensional square matrix of size (N x N).
 * Find the total sum of elements on both the diagonals and at all the four
 * boundaries. Input format: The first line contains an Integer 't' which
 * denotes the number of test cases or queries to be run. Then the test cases
 * follow.
 *
 * First line of each test case or query contains a single integer value, 'N'
 * representing the 'rows' and 'columns' for the two-dimensional square matrix.
 *
 * Second line onwards, the next 'N' lines or rows represent the ith row values.
 *
 * Each of the ith row constitutes 'N' column values separated by a single
 * space. Output format: For each test case, print the single integer denoting
 * the sum.
 *
 * Output for every test case will be printed in a seperate line. Constraints: 1
 * <= t <= 10^2 0 <= N <= 10^3 Time Limit: 1sec Sample input 1: 1 3 1 2 3 4 5 6
 * 7 8 9 Sample Output 1: 45 Explanation for Sample Output 1: The boundary
 * elements are 1, 2, 3, 6, 9, 8, 7 and 4.  *
 * The first-diagonal elements are 1, 5 and 9.  *
 * The second-diagonal elements are 3, 5 and 7.
 *
 * We just need to add all these numbers making sure that no number is added
 * twice. For example, '1' is both a boundary element and a first-diagonal
 * element similarly, '5' contributes to both the diagonals but they won't be
 * added twice.
 *
 * Hence, we add up, [1 + 2 + 3 + 6 + 9 + 8 + 7 + 4 + 5] to give 45 as the
 * output.
 */
public class SumOfBoundariesAndDiagonals {

    public static void totalSum(int[][] mat) {
        // Your code goes here
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == 0 || i == mat.length - 1 || j == mat[0].length - 1 || j == 0) {
                    //System.out.println("outer element is "+ mat[i][j]+ " ");
                    sum += mat[i][j];
                }
                if (i != 0 && i != mat.length - 1 && (i == j || j == mat[0].length - i - 1)) //System.out.println("diagonals are "+ mat[i][j]+ " ");
                {
                    sum += mat[i][j];
                }
            }
        }
        System.out.print(sum);
    }

}
