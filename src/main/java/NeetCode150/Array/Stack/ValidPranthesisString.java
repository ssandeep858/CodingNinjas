/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.Stack;

/*
 LeetCode 678 — Valid Parenthesis String

 You are given a string s containing only three types of characters:
 '(' , ')' , and '*'.

 The '*' character can represent any of the following:
   - '('
   - ')'
   - an empty string ""

 A string is valid if:
   1. Every '(' has a matching ')'.
   2. Every ')' has a matching '('.
   3. Parentheses are properly nested.

 Return true if the string can be made valid by replacing each '*' with
 either '(' , ')' , or empty. Otherwise return false.

 Examples:

 Input: s = "()"
 Output: true

 Input: s = "(*)"
 Output: true

 Input: s = "(*))"
 Output: true

 Input: s = "("
 Output: false

 Constraints:
 1 <= s.length <= 100000
 s contains only '(', ')', '*'
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
