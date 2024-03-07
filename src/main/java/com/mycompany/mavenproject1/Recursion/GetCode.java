/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh Return all codes - String Send Feedback Assume that the value
 * of a = 1, b = 2, c = 3, ... , z = 26. You are given a numeric string S. Write
 * a program to return the list of all possible codes that can be generated from
 * the given string. Note : The order of codes are not important. And input
 * string does not contain 0s. Input format : A numeric string Constraints : 1
 * <= Length of String S <= 10 Sample Input: 1123 Sample Output: aabc kbc alc
 * aaw kw
 */
public class GetCode {

    // 2=> 2+97(for a)-1=98 ( 97 is for a and 98 is for b => 2
    private static char helper(int input) {
        //System.out.println("inside loop"+(char) (input + 'a')+1);
        return (char) (input + 'a' - 1);
    }
    //O(2^n)
    public static String[] getCode(String input) {
        // Write your code here
        if (input.length() == 0) {
            return new String[]{""};
        }
        boolean check1 = (input.length() > 1 && Integer.parseInt(input.substring(0, 2)) < 27);
        if (check1) {
            String smallOutput1[] = getCode(input.substring(1));
            String smallOutput2[] = getCode(input.substring(2));
            String finalOutput[] = new String[smallOutput1.length + smallOutput2.length];
            for (int i = 0; i < smallOutput1.length; i++) {
                //System.out.println("sandeep here "+(input.charAt(0) - '0') );    
                finalOutput[i] = helper(Integer.parseInt(input.substring(0, 1)+"")) + smallOutput1[i];
            }
            for (int i = 0; i < smallOutput2.length; i++) {
                //System.out.println("sandeep here "+Integer.parseInt(input.substring(0, 2))); 
                finalOutput[i + smallOutput1.length] = helper(Integer.parseInt(input.substring(0, 2))) + "" + smallOutput2[i];
            }
            return finalOutput;
        } else {
            String smallOutput1[] = getCode(input.substring(1));
            for (int i = 0; i < smallOutput1.length; i++) {
                smallOutput1[i] = helper(input.charAt(0) - '0') + "" + smallOutput1[i];
            }
            return smallOutput1;
        }

    }

    public static void main(String[] args) {
//        char a = '1';
        System.out.println(helper('1' - '0'));

        String res[] = getCode("1123");
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }


    }

}
