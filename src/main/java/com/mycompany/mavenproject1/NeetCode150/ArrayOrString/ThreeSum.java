/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.ArrayOrString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ssingh
 */
public class ThreeSum {

    
    //-1,0,1,2,-1,-4
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        for(int i =0;i<nums.length-2;i++){
            int currentSumToFind=0-nums[i];
            
            int lowPointer=i+1;
            int highPointer=nums.length-1;
            
            while(lowPointer<highPointer){
                if(nums[lowPointer]+nums[highPointer]==currentSumToFind){
                    set.add(Arrays.asList(nums[i],nums[lowPointer],nums[highPointer]));
                    lowPointer++;
                    highPointer--;
                }
                else if(nums[lowPointer]+nums[highPointer]<currentSumToFind){
                    lowPointer++;
                }
                else{
                    highPointer--;
                }
            }
        }
        System.out.println(set);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        List<List<Integer>> res=
                threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(res);
    }
}
