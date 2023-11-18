/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.Stack;

import java.util.*;

/**
 *
 * @author ssingh Example 1:
 *
 * Input: s = "()" Output: true Example 2:
 *
 * Input: s = "()[]{}" Output: true Example 3:
 *
 * Input: s = "(]" Output: false
 */
public class validParethesis {

    public static boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('}', '{');
        hashMap.put(']', '[');
        hashMap.put(')', '(');

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '}' || s.charAt(i) == ']'
                    || s.charAt(i) == ')') {
                if (hashMap.get(s.charAt(i)) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

}
