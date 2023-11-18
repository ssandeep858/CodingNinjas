/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreesOrGraphs;

import com.mycompany.mavenproject1.LinkedList.midPoint;
import java.util.PriorityQueue;

/**
 *
 * @author ssingh
 */
public class FindMinimum {

    //not in logn. logn ka matlab ct problem in half everytime like binary search
    public static int findMin1(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        return pq.poll();
    }

   public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid=0;
        while (left < right) {           
            mid = left+(right - left) / 2;
            if(nums[mid]>nums[right]){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        //11,13,15,17
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }

}
