/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh Suppose you have a string, S, made up of only 'a's and 'b's.
 * Write a recursive function that checks if the string was generated using the
 * following rules: a. The string begins with an 'a' b. Each 'a' is followed by
 * nothing or an a or bb c. Each bb is followed by nothing or an 'a' If all the
 * rules are followed by the given string, return true otherwise return false.
 */
public class CheckAB {

    public static boolean check(String input) {
        if (input.length() == 0 || input.equals("")) {
            return true;
        }

        if (input.charAt(0) == 'a') {
            if (input.substring(1).equals("")) {
                return check(input.substring(1));
            }
            if (input.substring(1, 2).equals("a")) {
                return check(input.substring(2));
            }
            if (input.substring(1, 3).equals("bb")) {
                return check(input.substring(3));
            }
            //else  return check(input.substring(2));
        } else if (input.substring(0, 2).equals("bb")) {
            if (input.substring(2).equals("")) {
                return check(input.substring(2));
            }
            if (input.substring(2, 3).equals("a")) {
                return check(input.substring(3));
            }
            //else  return check(input.substring(2));
        }
        return false;
    }

    public static boolean checkAB(String input) {
        // Write your code here
        if (input.length() == 0) {
            return false;
        }
        if (input.charAt(0) != 'a') {
            return false;
        } else {
            return check(input.substring(1));
        }

    }

    public static void main(String[] args) {
        System.out.println(checkAB("abbaabb"));//abbaabb
    }

}
