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
 */
public class characterReplacement {

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
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
