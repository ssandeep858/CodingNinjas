/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh Return Permutations - String Send Feedback Given a string S,
 *         find and return all the possible permutations of the input string.
 *         Note 1 :
 *         The order of permutations is not important. Note 2 : If original
 *         string
 *         contains duplicate characters, permutations will also be duplicates.
 *         Input
 *         Format : String S Output Format : All permutations (in different
 *         lines)
 *         Sample Input : abc Sample Output : abc acb bac bca cab cba
 */
public class PermutationOfString {

    private static int fact(int i) {
        if (i == 0 || i == 1) {
            return 1;
        }

        return i * fact(i - 1);
    }

    // MUSHKILL LAGA THA TEKO REVISE KRLE
    public static String[] permutationOfString(String input) {
        if (input.length() == 0) {
            return new String[] { "" };
        }
        String res[] = new String[fact(input.length())];
        int k = 0;
        for (int i = 0; i < input.length(); i++) {
            // bc ac ab
            // c b
            String subSubstring = input.substring(0, i) + input.substring(i + 1);
            String smallOutput[] = permutationOfString(subSubstring);

            for (int j = 0; j < smallOutput.length; j++) {
                res[k++] = input.charAt(i) + smallOutput[j];
            }

        }
        return res;

    }

    public static void main(String[] args) {
        String res[] = permutationOfString("abc");
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
