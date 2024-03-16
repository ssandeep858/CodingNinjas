/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ssingh
 * string s and an integer k. You can choose any character of the
 * string and change it to any other uppercase English character. You can
 * perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can
 * get after performing the above operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2 Output: 4 Explanation: Replace the two 'A's with two
 * 'B's or vice versa. Example 2:
 *
 * Input: s = "AABABBA", k = 1 Output: 4 Explanation: Replace the one 'A' in the
 * middle with 'B' and form "AABBBBA". The substring "BBBB" has the longest
 * repeating letters, which is 4. There may exists other ways to achieve this
 * answer too.
 */
public class LongestRepeatingCharacterReplacement {

    public static int getMaxValue(HashMap<Character, Integer> hashMap) {
        int max = 0;
        for (Map.Entry<Character, Integer> h : hashMap.entrySet()) {
            max = Math.max(max, h.getValue());
        }
        return max;
    }

    public static int characterReplacement(String s, int k) {
        int maxRange = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            //// window length ---- count[maximum means how many we have to replace
            hashMap.put(s.charAt(right), hashMap.getOrDefault(s.charAt(right), 0) + 1);

            while (right - left + 1 - getMaxValue(hashMap) > k) {
                hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) - 1);
                left++;
            }

            maxRange = Math.max(maxRange, right - left + 1);
            right++;
        }
        return maxRange;
    }

    public static int characterReplacementMine(String s, int k) {
        int maxRange = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {

            // window length ---- count[maximum means how many we have to replace
            hashMap.put(s.charAt(right), hashMap.getOrDefault(s.charAt(right), 0) + 1);
            if (right - left + 1 - getMaxValue(hashMap) <= k) {
                System.out.println("max value right now is " + getMaxValue(hashMap));
                System.out.println("right side " + hashMap);
                maxRange = Math.max(maxRange, right - left + 1);
                right++;
            } else {
                while (right - left + 1 - getMaxValue(hashMap) > k) {
                    hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) - 1);
                    System.out.println("left side " + hashMap);
                    left++;
                }
                right++;
            }
        }
        return maxRange;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacementMine("AABABBA", 1));
    }
}
