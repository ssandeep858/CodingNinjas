/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.NeetCode75;

import static java.lang.System.exit;

/**
 *
 * @author ssingh Example 1:
 *
 * Input: nums = [1,2,3,4] Output: [24,12,8,6] Example 2:
 *
 * Input: nums = [-1,1,0,-3,3] Output: [0,0,9,0,0]
 */
public class productExceptSelf {

    public static void printArr(int res[]) {
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println("");
    }

    // will be doing postfix and prefix all together youtube video => https://www.youtube.com/watch?v=bNvIQI2wAjk&t=317s
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int tempProduct = 1;
        //for preFix calculation
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                tempProduct *= 1;
            } else {
                tempProduct *= nums[i - 1];
            }
            res[i] = tempProduct;
        }
        printArr(res);
        tempProduct = 1;
        // for postFix calculation 
        
        //Input: nums = [1,2,3,4]
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                tempProduct *= 1;
            } else {
                tempProduct *= nums[i + 1];
            }
            //System.out.println(tempProduct);
            res[i] *= tempProduct;
        }
        printArr(res);
        return res;
    }

    public static void main(String[] args) {
        int res[] = productExceptSelf(new int[]{1, 2, 3, 4});

    }
}
