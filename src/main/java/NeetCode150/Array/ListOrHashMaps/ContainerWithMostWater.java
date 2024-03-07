/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

/**
 *
 * @author ssingh
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0;
        int right=height.length-1;
        
        int maxArea=0;
        while(left<right){
            int area=(right-left)*Math.min(height[left], height[right]);
            maxArea=Math.max(area, maxArea);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] input= new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(input));
    }
}
