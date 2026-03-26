package TestQuestions.HelloInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    /*
     * Given an input integer array nums, write a function to find all unique
     * triplets [nums[i], nums[j], nums[k]] such that i, j, and k are distinct
     * indices, and the sum of nums[i], nums[j], and nums[k] equals zero. Ensure
     * that the resulting list does not contain any duplicate triplets.
     * 
     * Input:
     * 
     * nums = [-1,0,1,2,-1,-1]
     * Output:
     * 
     * [[-1,-1,2],[-1,0,1]]
     * Explanation: Both nums[0], nums[1], nums[2] and nums[1], nums[2], nums[4]
     * both include [-1, 0, 1] and sum to 0. nums[0], nums[3], nums[4] ([-1,-1,2])
     * also sum to 0.
     * 
     * Since we are looking for unique triplets, we can ignore the duplicate [-1, 0,
     * 1] triplet and return [[-1, -1, 2], [-1, 0, 1]].
     * 
     * The order of the triplets and the order of the elements within the triplets
     * do not matter.
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        // Your code goes here
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int currentElement = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] + currentElement == 0) {
                    set.add(Arrays.asList(nums[left], nums[right], currentElement));
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + currentElement > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        result.addAll(set);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -1 }));
    }
}
