package TestQuestions.HelloInterview;

public class TwoSum {

    /*
     * Given a sorted array of integers nums, determine if there exists a pair of
     * numbers that sum to a given target.
     * Input:
     * 
     * nums = [1,3,4,6,8,10,13]
     * target = 13
     * Output:
     * 
     * True # (3 + 10 = 13)
     */

    public static Boolean twoSum(int[] nums, Integer target) {
        // Your code goes here
        int left=0;
        int right=nums.length-1;

        while(left<right){
            if(nums[left]+nums[right]==target){
                return true;
            }
            else if (nums[left]+nums[right]>target) {
                right--;
            }else{
                left++;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{1,3,4,6,8,10,13}, 13));
    }
}
