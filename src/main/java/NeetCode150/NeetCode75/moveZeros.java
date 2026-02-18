package NeetCode150.NeetCode75;

public class moveZeros {
    public void moveZeroes(int[] nums) {
        // Your code goes here
        int nextNonZero = 0;
        // 2,0,4,0,9
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nextNonZero];
                nums[nextNonZero] = nums[i];
                nums[i] = temp;
                nextNonZero++;
            }
        }
    }

}
