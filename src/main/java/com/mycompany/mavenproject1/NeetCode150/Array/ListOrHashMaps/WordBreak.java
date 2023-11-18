/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ssingh Input: s = "leetcode", wordDict = ["leet","code"] Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"] Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple". Note that you are allowed to reuse a dictionary word. Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"] Output:
 * false
 */
public class WordBreak {

    
    // Bottom up dynmaic approach
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] stringFound = new boolean[s.length() + 1];
        System.out.println(Arrays.toString(stringFound));
        // dp[4+4] for searching code =dp[8] which we already set to true. 
        stringFound[s.length()] = true;
         System.out.println(Arrays.toString(stringFound));
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < wordDict.size(); j++) {
                if (i + wordDict.get(j).length() <= s.length() && s.subSequence(i, i + wordDict.get(j).length()).equals(wordDict.get(j))) {
                    stringFound[i] = stringFound[i + wordDict.get(j).length()];
                }
                if (stringFound[i]) {
                    break;
                }
            }
        }
        return stringFound[0];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", new ArrayList<String>(Arrays.asList(new String[]{"leet", "code"}))));
    }
}
