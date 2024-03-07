/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stacks;

import java.util.Stack;

/**
 *
 * @author ssingh Problem statement For a given expression in the form of a
 * string, find the minimum number of brackets that can be reversed in order to
 * make the expression balanced. The expression will only contain curly
 * brackets.
 *
 * If the expression can't be balanced, return -1.
 *
 * Example: Expression: {{{{ If we reverse the second and the fourth opening
 * brackets, the whole expression will get balanced. Since we have to reverse
 * two brackets to make the expression balanced, the expected output will be 2.
 *
 * Expression: {{{ In this example, even if we reverse the last opening bracket,
 * we would be left with the first opening bracket and hence will not be able to
 * make the expression balanced and the output will be -1.
 */
public class CountBracketReversal {

    public static int countBracketReversals(String input) {
        //Your code goes here
        if(input.length()%2!=0){
            return -1;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            
            if (stack.isEmpty()) {
                stack.push(input.charAt(i));
            } else if (input.charAt(i) == '}') {
                if(!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                }else{
                    stack.push(input.charAt(i));
                }   
            } else {
                stack.push(input.charAt(i));
            }
        }
        
        System.out.println("Before count "+stack.toString());
        int count=0;
        while(!stack.isEmpty()){
            char c1=stack.pop();
            char c2=stack.pop();
            if(c1==c2){
                count++;
            }else{
                count+=2;
            }
        }
        
        System.out.println("After count "+stack.toString());
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBracketReversals("{{}}{}}}}}{{{{{{{}{}{}}{}}{}}{{}{}{}{{{}{{}{{}{{{}{}}{{{{{{}}{}}}}}}}}}{}{}}}{{}{{}}}}}}{}}{}{{}}}{{"));
    }

}
