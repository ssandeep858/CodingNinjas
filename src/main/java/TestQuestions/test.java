package TestQuestions;

import java.util.Arrays;

public class test {
    public void moveZeroes(int[] nums) {
        // Your code goes here
        int nextNonZero = 0;
        // 2,0,4,0,9
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                int temp=nums[nextNonZero];
                nums[nextNonZero]=nums[i];
                nums[i]=temp;
                nextNonZero++;
            }
        }
    }

    public static void main(String[] args) {
        // System.out.println(triangleNumber(new int[] { 11, 4, 9, 6, 15, 18 }));
    }
}
