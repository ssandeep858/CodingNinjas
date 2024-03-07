/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.ArrayOrString;

/**
 *
 * @author ssingh Kadane's Algorithm Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: The subarray
 * [4,-1,2,1] has the largest sum 6. Example 2:
 *
 * Input: nums = [1] Output: 1 Explanation: The subarray [1] has the largest sum
 * 1. Example 3:
 *
 * Input: nums = [5,4,-1,7,8] Output: 23 Explanation: The subarray [5,4,-1,7,8]
 * has the largest sum 23.
 */
public class MaximumSubArray {

    //Kadane’s Algorithm
    public static int maxSubArray(int[] nums) {
        int maximumSum = nums[0];
        int currentSum = maximumSum;

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            if (currentSum > maximumSum) {
                maximumSum = currentSum;
            }
        }
        return maximumSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
