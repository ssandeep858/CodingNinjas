/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestQuestions;

import java.util.Arrays;

/**
 *
 * @author ssingh Triplet sum Send Feedback You have been given a random integer
 * array/list(ARR) and a number X. Find and return the triplet(s) in the
 * array/list which sum to X. Note : Given array/list can contain duplicate
 * elements. Input format : The first line contains an Integer 't' which denotes
 * the number of test cases or queries to be run. Then the test cases follow.
 *
 * First line of each test case or query contains an integer 'N' representing
 * the size of the first array/list.
 *
 * Second line contains 'N' single space separated integers representing the
 * elements in the array/list.
 *
 * Third line contains an integer 'X'. Output format : For each test case, print
 * the total number of triplets present in the array/list.
 *
 * Output for every test case will be printed in a separate line. Constraints :
 * 1 <= t <= 10^2 0 <= N <= 10^3 0 <= X <= 10^9
 *
 * Time Limit: 1 sec Sample Input 1: 1 7 1 2 3 4 5 6 7 12 Sample Output 1: 5
 * Sample Input 2: 2 7 1 2 3 4 5 6 7 19 9 2 -5 8 -6 0 5 10 11 -3 10 Sample
 * Output 2: 0 5
 */
public class TripleSumProblem {

    public static int tripletSum(int[] arr, int num) {
        //Your code goes here
        Arrays.sort(arr);
        int tripleSumCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int remainingSum = num - arr[i];
            tripleSumCount += pairSum(arr, i + 1, arr.length - 1, remainingSum);
        }
        return tripleSumCount;
    }

    public static int pairSum(int arr[], int startIndex, int endIndex, int num) {
        int pairs = 0;
        while (startIndex < endIndex) {
            if (arr[startIndex] + arr[endIndex] < num) {
                startIndex++;
            } else if (arr[startIndex] + arr[endIndex] > num) {
                endIndex--;
            } else {

                if (arr[startIndex] == arr[endIndex]) {
                    pairs += ((endIndex - startIndex + 1) * (endIndex - startIndex)) / 2;
                    return pairs;
                }
                int tempStartIndex = startIndex + 1;
                int tempEndIndex = endIndex - 1;
                while (tempStartIndex>=tempEndIndex && arr[startIndex] == arr[tempStartIndex]) {
                    tempStartIndex++;
                }
                while (tempStartIndex>=tempEndIndex && arr[endIndex] == arr[tempEndIndex]) {
                    tempEndIndex--;
                }
                pairs += (tempStartIndex - startIndex) * (endIndex - tempEndIndex);
                startIndex = tempStartIndex;
                endIndex = tempEndIndex;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(tripletSum(new int[]{6, 1, 6, 5, 3, 2, 5, 0, 5, 6, 0}, 5
        ));
    }
}
