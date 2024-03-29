/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestQuestions;

/**
 *
 * @author ssingh You have been given an integer array/list(ARR) of size N. It
 * has been sorted(in increasing order) and then rotated by some number 'K' (K
 * is greater than 0) in the right hand direction. Your task is to write a
 * function that returns the value of 'K', that means, the index from which the
 * array/list has been rotated. Input format : The first line contains an
 * Integer 't' which denotes the number of test cases or queries to be run. Then
 * the test cases follow.
 *
 * First line of each test case or query contains an integer 'N' representing
 * the size of the array/list.
 *
 * Second line contains 'N' single space separated integers representing the
 * elements in the array/list. Output Format : For each test case, print the
 * value of 'K' or the index from which which the array/list has been rotated.
 *
 * Output for every test case will be printed in a separate line. Constraints :
 * 1 <= t <= 10^2 2 <= N <= 10^5 Time Limit: 1 sec Sample Input 1: 1 6 5 6 1 2 3
 * 4 Sample Output 1: 2
 */
public class ArrayRotateCheck {

    public static int arrayRotateCheck(int[] arr) {
        // Your code goes here

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                count = i + 1;;
            }
        }
        return count;
    }

}
