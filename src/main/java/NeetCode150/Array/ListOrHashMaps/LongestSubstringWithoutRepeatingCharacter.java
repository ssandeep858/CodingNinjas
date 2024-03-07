/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.*;

/**
 *
 * @author ssingh 3. Longest Substring Without Repeating Characters Solved
 * Medium Topics Companies Given a string s, find the length of the longest
 * substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the
 * length of 3. Example 2:
 *
 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length
 * of 1. Example 3:
 *
 * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the
 * length of 3. Notice that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacter {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int count = 0;
        int left = 0;
        int right = left;

// typical sliding window problem 
        for (right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            count = Math.max(count, right - left + 1);
            set.add(s.charAt(right));
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
