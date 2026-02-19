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
public class BalancedParanthesis {

    public static boolean isBalanced(String expression) {
        //Your code goes here
        HashMap<Character, Character> bracketMappings = new HashMap<>();
        bracketMappings.put('}', '{');
        bracketMappings.put(')', '(');
        bracketMappings.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            System.out.println("CHaracter is " + expression.charAt(i));
            if (stack.isEmpty()) {
                stack.push(expression.charAt(i));
            } else if (expression.charAt(i) == '}' || expression.charAt(i) == ')' || expression.charAt(i) == ']') {
                if (bracketMappings.get(expression.charAt(i)) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(expression.charAt(i));
                }
            } else {
                stack.push(expression.charAt(i));
            }

            //System.out.print(stack.toString().replaceAll("\\[", "").replaceAll("]", ""));
        }
        //System.out.println(stack.toString());

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("(()()())"));
    }

}
