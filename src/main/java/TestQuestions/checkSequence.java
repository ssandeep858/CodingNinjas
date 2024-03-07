/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestQuestions;

/**
 *
 * @author ssingh Given two string s and t, write a function to check if s
 * contains all characters of t (in the same order as they are in string t).
 * Return true or false. Do it recursively. E.g. : s =
 * “abchjsgsuohhdhyrikkknddg” contains all characters of t=”coding” in the same
 * order. So function will return true. Input Format : Line 1 : String s Line 2
 * : String t Output Format : true or false Sample Input 1 :
 * abchjsgsuohhdhyrikkknddg coding Sample Output 1 : true Sample Input 2 : abcde
 * aeb Sample Output 2 : false
 */
public class checkSequence {

    public static boolean checkSequence(String a, String b) {
        if ((a.length() == 0 && b.length() != 0)) {
            return false;
        }
        if (b.length() == 0) {
            return true;
        }

        if (b.charAt(0) == a.charAt(0)) {
            return checkSequence(a.substring(1), b.substring(1));
        } else {
            return checkSequence(a.substring(1), b);
        }
    }

}
