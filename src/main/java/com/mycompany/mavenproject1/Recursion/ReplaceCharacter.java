/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh Given an input string S and two characters c1 and c2, you need
 * to replace every occurrence of character c1 with character c2 in the given
 * string. Do this recursively. Input Format : Line 1 : Input String S Line 2 :
 * Character c1 and c2 (separated by space) Output Format : Updated string
 * Constraints : 1 <= Length of String S <= 10^6 Sample Input : abacd a x Sample
 * Output : xbxcd
 */
public class ReplaceCharacter {

    public static String replaceCharacter(String input, char c1, char c2) {
        if (input.length() == 1 && input.charAt(0) == c1) {
            return String.valueOf(c2);
        }
        if (input.length() == 1 && input.charAt(0) != c1) {
            return input;
        }
        return (input.charAt(0) == c1 ? String.valueOf(c2) : String.valueOf(input.charAt(0))) + replaceCharacter(input.substring(1), c1, c2);

    }

    public static void main(String[] args) {
        System.out.println(replaceCharacter("nsandeepsingh", 'n', 'm'));
    }
}
