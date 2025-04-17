/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.NeetCode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ssingh Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"] Output:
 * [["bat"],["nat","tan"],["ate","eat","tea"]] Example 2:
 *
 * Input: strs = [""] Output: [[""]] Example 3:
 *
 * Input: strs = ["a"] Output: [["a"]]
 */
public class GroupAnagrams {

    public static String sortString(String input) {
        char[] temp = input.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();

        for (String currentString : strs) {
            String sortedString = sortString(currentString);
            if (hashMap.containsKey(sortedString)) {
                hashMap.get(sortedString).add(currentString);
            } else {
                hashMap.put(sortedString, new ArrayList<>(Arrays.asList(currentString)));
            }
        }
//        Some initiallization rules 
//        List<List<String>> arrayList=new ArrayList<>();
//        for(Map.Entry<String, List<String>> map : hashMap.entrySet()){
//            arrayList.add(map.getValue());
//        }
//        return arrayList;
//          System.out.println(hashMap.keySet());
//          System.out.println(hashMap.values());
//          very very important logic to append 2 lists         
//          List<String> list2= new ArrayList<>(list1);
        return new ArrayList<>(hashMap.values());
    }
    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();
        result = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(result);
        for (List<String> resultOuter : result) {
            for (String resultInner : resultOuter) {
                System.out.println(resultInner);
            }
        }
    }
}
