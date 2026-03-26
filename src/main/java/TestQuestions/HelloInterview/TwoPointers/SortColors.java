package TestQuestions.HelloInterview;

import java.util.Arrays;

public class SortColors {

    /*
     * DESCRIPTION (inspired by Leetcode.com)
     * Write a function to sort a given integer array nums in-place (and without the
     * built-in sort function), where the array contains n integers that are either
     * 0, 1, and 2 and represent the colors red, white, and blue. Arrange the
     * objects so that same-colored ones are adjacent, in the order of red, white,
     * and blue (0, 1, 2).
     * 
     * Input:
     * 
     * nums = [2,1,2,0,1,0,1,0,1]
     * Output:
     * 
     * [0,0,0,1,1,1,1,2,2]
     */

    public static void sortColors(int[] nums) {
        // Your code goes here
        int left=0;
        int right=nums.length-1;
        int mid=0;

        while(mid<=right){
            if(nums[mid]==0){
                int temp=nums[left];
                nums[left]=nums[mid];
                nums[mid]=temp;
                mid++;
                left++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                int temp=nums[right];
                nums[right]=nums[mid];
                nums[mid]=temp;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int input[] = new int[] { 2, 1, 2, 0, 1, 0, 1, 0, 1 };
        sortColors(input);
        System.out.println(Arrays.toString(input));
    }

}
