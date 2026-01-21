/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.NeetCode75;

/**
 *
 * @author ssingh
 *         You are given an integer array height of length n. There are n
 *         vertical lines drawn such that the two endpoints of the ith line are
 *         (i, 0) and (i, height[i]).
 * 
 *         Find two lines that together with the x-axis form a container, such
 *         that the container contains the most water.
 * 
 *         Return the maximum amount of water a container can store.
 * 
 *         Notice that you may not slant the container.
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(input));
    }
}
