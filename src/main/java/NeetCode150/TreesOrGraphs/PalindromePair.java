package NeetCode150.TreesOrGraphs;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class PalindromePair {
    private static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromePairTreeMap(String[] words) {
        System.out.println("\n=== USING TREEMAP APPROACH ===");

        // TreeMap to store words in sorted order
        TreeMap<String, Integer> sortedWords = new TreeMap<>();

        // TreeMap to store reverse of words
        TreeMap<String, Integer> reverseMap = new TreeMap<>();

        // Populate both maps
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            sortedWords.put(word, i);

            // Check if word itself is palindrome
            if (isPalindrome(word)) {
                System.out.println("Found palindrome: " + word);
                return true;
            }

            // Store reverse
            String reverse = new StringBuilder(word).reverse().toString();
            reverseMap.put(reverse, i);
        }

        System.out.println("Sorted words: " + sortedWords);
        System.out.println("Reverse map: " + reverseMap);

        // Check if any word exists in reverse map (from different index)
        for (Map.Entry<String, Integer> entry : sortedWords.entrySet()) {
            String word = entry.getKey();
            Integer wordIndex = entry.getValue();

            // Check if this word exists in reverse map from different source
            if (reverseMap.containsKey(word)) {
                Integer reverseIndex = reverseMap.get(word);
                if (!wordIndex.equals(reverseIndex)) {
                    // Found a pair!
                    System.out.println("Found pair: word '" + word + "' (index " + wordIndex +
                            ") matches with reverse of word at index " + reverseIndex);
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== PALINDROME PAIRS USING TREEMAP ===\n");

        // Test Case 1: Should return true (abc + cba forms palindrome)
        System.out.println("TEST CASE 1:");
        String[] words1 = { "abc", "def", "ghi", "cba" };
        System.out.println("Input: " + Arrays.toString(words1));
        boolean result1 = isPalindromePairTreeMap(words1);
        System.out.println("Result: " + result1);
        System.out.println("Expected: true");
        System.out.println("-".repeat(50) + "\n");
    }

}
