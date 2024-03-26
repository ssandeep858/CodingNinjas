/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

/**
 *
 * @author ssingh Input: nums = [0,0,1,1,1,2,2,3,3,4] Output: 5, nums =
 * [0,1,2,3,4,_,_,_,_,_] Explanation: Your function should return k = 5, with
 * the first five elements of nums being 0, 1, 2, 3, and 4 respectively. It does
 * not matter what you leave beyond the returned k (hence they are underscores).
 */
public class removeDuplicatesinSortedArray {

    public static int removeDuplicates(int[] nums) {
        int index=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] != nums[i+1]){
                nums[index++]=nums[i+1];
            }
        }
        return index;
    }
    
    public static int removeDuplicates2(int[] nums) {
        int left=0,right=1;
        int count=1;
        while(left<=right && right<nums.length){
            if(nums[left]!=nums[right]){
                nums[count++]=nums[right];
                left++;
            }
            right++;
        }
        return count;
    }
    
    
    
    public static void main(String[] args) {
        System.out.println(removeDuplicates2(new int[]{1,1,2}));
    }
}
