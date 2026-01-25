/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ssingh Given n pairs of parentheses, write a function to generate all
 * combinations of well-formed parentheses. Example 1: Input: n = 3 Output:
 * ["((()))","(()())","(())()","()(())","()()()"] Example 2: Input: n = 1
 * Output: ["()"]
 */
public class GenerateParenthesis {

    // backTrackiing used for solving via Recursion
    public static void backTrack(int n, int closingCount, int openingCount, String currString, List<String> res) {
        if (currString.length() == n * 2) {
            res.add(currString);
            return;
        }
        if (openingCount < n) {
            backTrack(n, closingCount, openingCount + 1, currString+"(", res);
        }
        if (closingCount < openingCount) {            
            backTrack(n, closingCount + 1, openingCount, currString+")", res);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(n, 0, 0, "", res);
        return res;

    }

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        res = generateParenthesis(3);
        System.out.println(res.toString());
    }

}
