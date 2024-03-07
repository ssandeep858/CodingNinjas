/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.*;

/**
 *
 * @author ssingh Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit
 * dig","let3 art zero"] Output: ["let1 art can","let3 art zero","let2 own kit
 * dig","dig1 8 1 5 1","dig2 3 6"] Explanation: The letter-log contents are all
 * different, so their ordering is "art can", "art zero", "own kit dig". The
 * digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
 */
public class reorderLogFiles {

    public static void createLists(String[] logs, List<String> letterLogs, List<String> digitLogs) {
        for (String currentString : logs) {
            if (Character.isAlphabetic(currentString.split(" ")[1].charAt(0))) {
                letterLogs.add(currentString);
            } else {
                digitLogs.add(currentString);
            }
        }
    }

    public static void sortLists(List<String> letterLogs) {
        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String l1, String l2) {
                if (l1.substring(l1.indexOf(" ") + 1).compareTo(l2.substring(l2.indexOf(" ") + 1)) == 0) {
                    return l1.split(" ")[0].compareTo(l2.split(" ")[0]);
                } else {
                    return l1.substring(l1.indexOf(" ") + 1).compareTo(l2.substring(l2.indexOf(" ") + 1));
                }
            }
        });
    }

    public static String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        createLists(logs, letterLogs, digitLogs);
        sortLists(letterLogs);
        String[] res = new String[letterLogs.size() + digitLogs.size()];
        int j = 0;
        for (String let : letterLogs) {
            res[j++] = let;
        }
        for (String dig : digitLogs) {
            res[j++] = dig;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] res = reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"});
        for (String res1 : res) {
            System.out.println(res1);
        }
    }
}
