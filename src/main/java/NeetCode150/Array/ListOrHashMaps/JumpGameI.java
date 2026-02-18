/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ssingh given an integer array nums. You are initially positioned at
 *         the array's first index, and each element in the array represents
 *         your
 *         maximum jump length at that position.
 *
 *         Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 *         Example 1:
 *
 *         Input: nums = [2,3,1,1,4] Output: true Explanation: Jump 1 step from
 *         index 0
 *         to 1, then 3 steps to the last index. Example 2:
 *
 *         Input: nums = [3,2,1,0,4] Output: false Explanation: You will always
 *         arrive
 *         at index 3 no matter what. Its maximum jump length is 0, which makes
 *         it
 *         impossible to reach the last index.
 */
public class JumpGameI {

    // Your solution isn’t bad at all — it’s actually the best greedy solution (O(n)
    // time, O(1) space). It looks “backward”, but that’s just one clean way to
    // express the greedy idea.
    public static boolean canJump(int[] nums) {

        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
    }

}
