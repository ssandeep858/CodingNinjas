package TestQuestions.HelloInterview;

import java.util.Arrays;

public class TraingleNumbers {
    /*
     * Write a function to count the number of triplets in an integer array nums
     * that could form the sides of a triangle.
     * 
     * For three sides to form a valid triangle, all three of these conditions must
     * hold: (a + b > c), (a + c > b), and (b + c > a), where (a), (b), and (c) are
     * the side lengths. In other words, the sum of every possible pair must exceed
     * the third side.
     * 
     * a
     * b
     * c
     * Valid triangle requires:
     * a + b > c AND a + c > b AND b + c > a
     * (every pair must sum to more than the third side)
     * The triplets do not need to be unique.
     * 
     * Example:
     * 
     * Input:
     * 
     * nums = [11,4,9,6,15,18]
     * Output:
     * 
     * 10
     * Explanation: Valid combinations are...
     * 
     * 4, 15, 18
     * 6, 15, 18
     * 9, 15, 18
     * 11, 15, 18
     * 9, 11, 18
     * 6, 11, 15
     * 9, 11, 15
     * 4, 6, 9
     */

    public static Integer triangleNumber(int[] nums) {
        // Your code goes here
        // 4 6 9 11 15 18
        // 0 1 2 3 4 5
        Arrays.sort(nums);
        int count = 0;

        for (int thirdSide = nums.length-1; thirdSide >=2; thirdSide--) {
            int firstSide = 0;
            int secondSide = thirdSide-1;
            while (firstSide<secondSide) {

                if (nums[firstSide] + nums[secondSide] > nums[thirdSide]) {
                    count += (secondSide-firstSide);
                    secondSide--;
                }
                else{
                    firstSide++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[] { 11, 4, 9, 6, 15, 18 }));
    }
}
