/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class BinarySearch {

    public static int search(int[] nums, int target, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            return -1;
        }
        int mid = (startIndex + endIndex) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return search(nums, target, mid + 1, endIndex);
        } else {
            return search(nums, target, 0, mid - 1);
        }
    }

    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);

    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 4, 7, 8, 13, 14, 17}, 13));
    }
}
