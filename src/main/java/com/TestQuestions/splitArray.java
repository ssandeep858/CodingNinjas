/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestQuestions;

/**
 *
 * @author ssingh Given an integer array A of size N, check if the input array
 * can be divided in two groups G1 and G2 with following properties- - Sum of
 * both group elements are equal - Group 1: All elements in the input, which are
 * divisible by 5 - Group 2: All elements in the input, which are divisible by 3
 * (but not divisible by 5). - Elements which are neither divisible by 5 nor by
 * 3, can be put in either group G1 or G2 to satisfy the equal sum property.
 * Group 1 and Group 2 are allowed to be unordered and all the elements in the
 * Array A must belong to only one of the groups.
 *
 *
 * Return true, if array can be split according to the above rules, else return
 * false. Note: You will get marks only if all the test cases are passed. Input
 * Format : Line 1 : Integer N (size of array) Line 2 : Array A elements
 * (separated by space) Output Format : true or false Constraints : 1 <= N <= 50
 * Sample Input 1 : 2 1 2 Sample Output 1 : false Sample Input 2 : 3 1 4 3
 * Sample Output 2 : true
 */
public class splitArray {

    public static boolean splitArray(int input[], int startIndex, int lSum, int rSum) {

        if (startIndex == input.length) {
            return lSum == rSum;
        }
        if (input[startIndex] % 5 == 0) {
            lSum += input[startIndex];
            startIndex++;
        } else if (input[startIndex] % 3 == 0) {
            rSum += input[startIndex];
            startIndex++;
        } else {
            return splitArray(input, startIndex + 1, lSum + input[startIndex], rSum) || splitArray(input, startIndex + 1, lSum, rSum + input[startIndex]);
        }
        return splitArray(input, startIndex, lSum, rSum);

    }

    public static boolean splitArray(int input[]) {
        return splitArray(input, 0, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{1, 1, 1}));
    }

}
