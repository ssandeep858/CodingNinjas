/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.HashSet;

/**
 *
 * @author ssingh Given an unsorted array of integers nums, return the length of
 * the longest consecutive elements sequence. You must write an algorithm that
 * runs in O(n) time. Example 1: Input: nums = [100,4,200,1,3,2] Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4. Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1] Output: 9
 */
public class LongestConsecutiveSequence {

    // goal is get in O(N) not by sorting in nlogn
    public static int longestConsecutive(int[] nums) {
        int longestLen = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer n : nums) {
            hashSet.add(n);
        }

        for (int i = 0; i < nums.length; i++) {
            // check if this is start of the sequence
            if (!hashSet.contains(nums[i] - 1)) {
                // if yes then keep going till the forward number not found
                int len = 1;
                while (hashSet.contains(nums[i] + len)) {
                    len++;
                }
                longestLen = Math.max(longestLen, len);
            }
        }
        return longestLen;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
