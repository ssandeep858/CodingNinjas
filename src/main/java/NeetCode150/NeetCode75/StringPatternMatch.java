package NeetCode150.NeetCode75;

public class StringPatternMatch {
    public static boolean searchPatternSimple(String[] words, String pattern) {
        // Edge case: empty pattern
        if (pattern == null || pattern.isEmpty()) {
            return true; // Empty pattern is found in any string
        }

        // Check each word for the pattern
        for (String word : words) {
            if (word.contains(pattern)) {
                return true; // Pattern found
            }
        }

        return false; // Pattern not found in any word
    }

    public static void main(String[] args) {
        System.out.println(searchPatternSimple(new String[]{"abc","def","ghi","cba"}, "de"));
    }

}
