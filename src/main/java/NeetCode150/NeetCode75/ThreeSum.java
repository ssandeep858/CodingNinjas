/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.NeetCode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ssingh Given an integer array nums, return all the triplets [nums[i],
 *         nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] +
 *         nums[j]
 *         + nums[k] == 0.
 *
 *         Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 *         Example 1:
 *
 *         Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
 *         Explanation:
 *         nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0. nums[1] + nums[2] +
 *         nums[4] =
 *         0 + 1 + (-1) = 0. nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 *         The
 *         distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that the order
 *         of the
 *         output and the order of the triplets does not matter.
 */
public class ThreeSum {

    // -1,0,1,2,-1,-4
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int currentSumToFind = 0 - nums[i];

            int lowPointer = i + 1;
            int highPointer = nums.length - 1;

            while (lowPointer < highPointer) {
                if (nums[lowPointer] + nums[highPointer] == currentSumToFind) {
                    set.add(Arrays.asList(nums[i], nums[lowPointer], nums[highPointer]));
                    l.add(Arrays.asList(nums[i], nums[lowPointer], nums[highPointer]));
                    lowPointer++;
                    highPointer--;
                } else if (nums[lowPointer] + nums[highPointer] < currentSumToFind) {
                    lowPointer++;
                } else {
                    highPointer--;
                }
            }
        }
        // System.out.println(set);
        //System.out.println(Arrays.toString(l.toArray()));
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        System.out.println(res);
    }
}
