/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.ArraysPatterns;

/**
 *
 * @author ssingh For a given two-dimensional integer array/list of size (N x
 * M), print it in a spiral form. That is, you need to print in the order
 * followed for every iteration: a. First row(left to right) b. Last column(top
 * to bottom) c. Last row(right to left) d. First column(bottom to top) Mind
 * that every element will be printed only once.
 * Sample Input 1:
1
4 4 
1 2 3 4 
5 6 7 8 
9 10 11 12 
13 14 15 16
Sample Output 1:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
Sample Input 2:
2
3 3 
1 2 3 
4 5 6 
7 8 9
3 1
10
20
30
Sample Output 2:
1 2 3 6 9 8 7 4 5 
10 20 30 
 */
public class SpiralPrint {
    public static void spiralPrint(int matrix[][]) {
		// Your code goes here

        if(matrix.length==0 || matrix[0].length==0)
        System.exit(0);
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        int count = 0;
        //System.out.println(matrix.length * matrix[0].length);
        while (count < matrix.length * matrix[0].length) {
                for (int i = colStart; i <= colEnd; i++) {
                        System.out.print(matrix[colStart][i]+" ");

                        count++;
                }
                rowStart++;

                if(count>=matrix.length * matrix[0].length)
                break;
                for (int i = rowStart; i <= rowEnd; i++) {
                        System.out.print(matrix[i][colEnd]+" ");
                        count++;
                }
                //System.out.println(count);
                colEnd--;

                if(count>=matrix.length * matrix[0].length)
                break;
                for (int i = colEnd; i >= colStart; i--) {
                        System.out.print(matrix[rowEnd][i]+" ");
                        count++;
                }
                if(count>=matrix.length * matrix[0].length)
                break;
                rowEnd--;
                for (int i = rowEnd; i >= rowStart; i--) {
                        System.out.print(matrix[i][colStart]+" ");
                        count++;
                }
                colStart++;
		}
	}

}
