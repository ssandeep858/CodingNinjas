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
public class PairSum {

    public static int pairSum(int[] arr, int num) {
        //Your code goes here
        Arrays.sort(arr);
        int totalPairs = 0;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] == arr[j]&&(arr[i]+arr[j]==num)) {
                 totalPairs += ((j - i+1) * (j - i))/2;
                return totalPairs;
            }
            if (arr[i] + arr[j] > num) {
                j--;
            } else if (arr[i] + arr[j] < num) {
                i++;
            } else {
                if ((arr[i] == arr[i + 1]) || (arr[j] == arr[j - 1])) {
                    int tempResults[] = countSame(arr, i, j);
                    totalPairs += tempResults[0]-1;
                    i = tempResults[1];
                    j = tempResults[2];
                } else {
                    totalPairs++;
                    i++;j--;
                }
            }
        }
        return totalPairs;

    }

    public static int[] countSame(int arr[], int i, int j) {
        int ICount = 1, JCount = 1;
        while (i < j && ((arr[i] == arr[i + 1]) || (arr[j] == arr[j - 1]))) {
            if (arr[i] == arr[i + 1]) {
                ICount++;
                i++;
            }
            if (arr[j] == arr[j - 1]) {
                JCount++;
                j--;
            }
        }
        return new int[]{ICount * JCount, i, j};
    }

    public static void main(String[] args) {
        int arr[] = new int[]{0, 6, 0, 0};
        Arrays.sort(arr);
        System.out.println(pairSum(arr, 6));
    }
}
