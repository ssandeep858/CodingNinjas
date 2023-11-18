/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.ArrayOrString;

import java.util.HashMap;

/**
 *
 * @author ssingh
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int sumToFind=target - nums[i];
            if(hashMap.containsKey(sumToFind)){
                System.out.println(sumToFind+" <= value ");
                  return new int[]{i, hashMap.get(sumToFind)};
            }
            else{
                hashMap.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
    
    public static void main(String[] args) {
        int arr[]=twoSum(new int[]{3,2,4},6);
    }
}
