package TestQuestions.HelloInterview;

public class moveZeros {
    /*
     * DESCRIPTION (inspired by Leetcode.com)
     * Given an integer array nums, write a function to rearrange the array by
     * moving all zeros to the end while keeping the order of non-zero elements
     * unchanged. Perform this operation in-place without creating a copy of the
     * array.
     * 
     * Input:
     * 
     * nums = [2,0,4,0,9]
     * Output:
     * 
     * [2,4,9,0,0]
     */

    public static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nonZeroIndex];
                nums[nonZeroIndex] = nums[i];
                nums[i] = temp;
                nonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2,0,4,0,9};
        moveZeroes(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
