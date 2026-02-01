package TreesOrGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 *      System.out.println("  lowerKey(25) = 20  ← [Strictly less than 25]");
        System.out.println("  floorKey(25) = 20  ← [Less than or equal to 25]");
        System.out.println("  ceilingKey(25) = 30 → [Greater than or equal to 25]");
        System.out.println("  higherKey(25) = 30  → [Strictly greater than 25]");
 */

public class AutoComplete {
    public static List<String> autoComplete(String[] words, String prefix) {
        System.out.println("\n=== DETAILED TREEMAP AUTO-COMPLETE ===");
        System.out.println("Input words: " + Arrays.toString(words));
        System.out.println("Prefix: '" + prefix + "'");

        // Create TreeMap with custom comparator for case-insensitive sorting if needed
        // TreeMap<String, Boolean> wordMap = new
        // TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        TreeMap<String, Boolean> wordMap = new TreeMap<>();

        // Add words and show the sorted order
        System.out.println("\nStep 1: Building TreeMap...");
        for (String word : words) {
            wordMap.put(word, true);
            System.out.println("  Added: " + word);
        }
        System.out.println("Sorted words in TreeMap: " + wordMap.keySet());

        // Find the range for prefix matching
        System.out.println("\nStep 2: Finding range for prefix '" + prefix + "'");

        // Method 1: Using subMap (most efficient)
        String fromKey = prefix;
        String toKey = prefix + '}';
        System.out.println("  Range: ['" + fromKey + "', '" + toKey + "')");

        SortedMap<String, Boolean> prefixMap = wordMap.subMap(fromKey, toKey);
        System.out.println("  Matching words: " + prefixMap.keySet());

        // Method 2: Using navigation methods (alternative approach)
        System.out.println("\nAlternative approach using navigation methods:");
        String ceilingKey = wordMap.ceilingKey(prefix); // First key >= prefix
        String higherKey = wordMap.higherKey(prefix + "~"); // First key > prefix+~
        System.out.println("  Ceiling key (first match): " + ceilingKey);
        System.out.println("  Higher key (first non-match): " + higherKey);
        // System.out.println("Ceiling and Higher wala mehtod " +
        // wordMap.subMap(ceilingKey, higherKey));
        return new ArrayList<>(prefixMap.keySet());
    }

    public static void main(String[] args) {
        System.out.println("=== AUTO-COMPLETE USING TREEMAP ===");
        System.out.println("====================================\n");

        // Test Case 1: "no" prefix
        System.out.println("TEST CASE 1:");
        System.out.println("-----------");
        String[] words1 = { "do", "dont", "no", "not", "note", "notes", "den" };
        String prefix1 = "no";

        List<String> results1 = autoComplete(words1, prefix1);
        System.out.println("Input: " + Arrays.toString(words1));
        System.out.println("Prefix: '" + prefix1 + "'");
        System.out.println("Output: " + results1);
        System.out.println("Expected: [no, not, note, notes]");
        System.out.println("Match: " + results1.equals(Arrays.asList("no", "not", "note", "notes")));

        // Test Case 2: "de" prefix
        System.out.println("\nTEST CASE 2:");
        System.out.println("-----------");
        String prefix2 = "de";

        List<String> results2 = autoComplete(words1, prefix2);
        System.out.println("Prefix: '" + prefix2 + "'");
        System.out.println("Output: " + results2);
        System.out.println("Expected: [den]");
        System.out.println("Match: " + results2.equals(Arrays.asList("den")));

        // Test Case 3: "nom" prefix (no matches)
        System.out.println("\nTEST CASE 3:");
        System.out.println("-----------");
        String prefix3 = "nom";

        List<String> results3 = autoComplete(words1, prefix3);
        System.out.println("Prefix: '" + prefix3 + "'");
        System.out.println("Output: " + (results3.isEmpty() ? "(Empty)" : results3.toString()));
        System.out.println("Expected: (Empty)");
        System.out.println("Match: " + results3.isEmpty());
    }
}
