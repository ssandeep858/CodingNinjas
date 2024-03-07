/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.Stack;

/**
 *
 * @author ssingh Example 1:
 *
 * Input: s = "()" Output: true Example 2:
 *
 * Input: s = "(*)" Output: true Example 3:
 *
 * Input: s = "(*))" Output: true
 *
 * Input s = "(" Output false Expected false
 */
public class ValidPranthesisString {

    public static boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftMin++;
                leftMax++;
            } else if (s.charAt(i) == ')') {
                leftMin--;
                leftMax--;
            } else {
                // if start was wrtten as )
                leftMax++;
                // if star was written as (
                leftMin--;
            }

            if (leftMin < 0) {
                leftMin = 0;
            }
            
            // this means ) came first or more often
            if (leftMax < 0) {
                return false;
            }
        }
        return (leftMin == 0);
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("("));
    }

}
