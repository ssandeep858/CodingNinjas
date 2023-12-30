/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

/**
 *
 * @author ssingh
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // racecar type of string
            int len1 = traverseOutwards(s, i, i);
            // aabbaa even type of string case
            int len2 = traverseOutwards(s, i, i + 1);
            int len = Math.max(len1, len2);
            System.out.println(len + " for the iteration " + i);
            System.out.println("start is " + start + " end is " + end);
            if (len > end - start) {
                System.out.println("inside condition");
                // racecar and i is at e i.e. 3
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }

        System.out.println("left is " + start + " right is " + end);
        return s.substring(start, end + 1);
    }

    public static int traverseOutwards(String s, int left, int right) {
        if (left > right || s.length() == 0) {
            return 0;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // racecar
        // 7- (-1) -1 =7 length for racecar
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("racecar"));
    }

}
