/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stacks;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author ssingh
 */
public class checkRedundantBrackets {

    public static boolean checkRedundantBrackets(String expression) {
        //Your code goes here
        HashMap<Character, Character> bracketMappings = new HashMap<>();
        bracketMappings.put('}', '{');
        bracketMappings.put(')', '(');
        bracketMappings.put(']', '[');

        Stack<Character> stack = new Stack<>();
        int count = 0;
        boolean countStart = false;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '{' || expression.charAt(i) == '(' || expression.charAt(i) == '[') {
                stack.push(expression.charAt(i));

            } else if (expression.charAt(i) == '}' || expression.charAt(i) == ')' || expression.charAt(i) == ']') {
                while (stack.peek() != bracketMappings.get(expression.charAt(i))) {
                    stack.pop();
                    count++;
                }
                if (count < 3) {
                    return true;
                } else {
                    count = 0;
                    stack.pop();
                }
            } else {
                if (!stack.isEmpty()) {
                    stack.push(expression.charAt(i));
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkRedundantBrackets("(x+y*(a-b))"));
    }

}
