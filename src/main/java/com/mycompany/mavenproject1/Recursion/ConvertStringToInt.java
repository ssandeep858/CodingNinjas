/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh Write a recursive function to convert a given string into the
 *         number it represents. That is input will be a numeric string that
 *         contains
 *         only numbers, you need to convert the string into corresponding
 *         integer and
 *         return the answer. Input format : Numeric string S (string, Eg.
 *         "1234")
 *         Output format : Corresponding integer N (int, Eg. 1234) Constraints :
 *         0 < |S|
 *         <= 9 where |S| represents length of string S. Sample Input 1 :
 *         00001231
 *         Sample Output 1 : 1231
 */
public class ConvertStringToInt {

    public static int convertStringToInt(String input) {
        // Write your code here
        if (input.length() == 1) {
            return input.charAt(0) - 48;
        }
        // 1234
        int temp = convertStringToInt(input.substring(1));
        System.out.println("temp is " + temp);
        int temToPower = input.length() - 1;
        System.out.println("ten to power value is " + temToPower);
        int powervariable = input.charAt(0) - 48;
        System.out.println("power variable is " + powervariable);
        return powervariable * (int) Math.pow(10, temToPower) + temp;
    }

    public static void main(String[] args) {
        System.out.println(convertStringToInt("00012312"));
    }
}
