/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreesOrGraphs;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.*;

/**
 *
 * @author ssingh You are given an array of strings products and a string
 * searchWord.
 *
 * Design a system that suggests at most three product names from products after
 * each character of searchWord is typed. Suggested products should have common
 * prefix with searchWord. If there are more than three products with a common
 * prefix return the three lexicographically minimums products.
 *
 * Return a list of lists of the suggested products after each character of
 * searchWord is typed.
 *
 *
 *
 * Example 1:
 *
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"],
 * searchWord = "mouse" Output:
 * [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
 * Explanation: products sorted lexicographically =
 * ["mobile","moneypot","monitor","mouse","mousepad"]. After typing m and mo all
 * products match and we show user ["mobile","moneypot","monitor"]. After typing
 * mou, mous and mouse the system suggests ["mouse","mousepad"].
 */
public class SuggestedProducts {

    // A TreeMap stores map elements in a Red-Black tree.Sorts on the based of keys
    //Red-Black tree is a binary search tree in which every node is colored with either red or black. 
    // It is a type of self balancing binary search tree. It has a good efficient worst case running time complexity.
    // HashMap allows storing at most one null key and many null values. 
    // However, TreeMap doesn't allow a null key but may contain many null values. 
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        List<String> list = new ArrayList<>(Arrays.asList(products));
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            treeMap.put(list.get(i), i);
        }
        String key = "";
        for (Character c : searchWord.toCharArray()) {
            key += c;
            String from = treeMap.ceilingKey(key);
            String to = treeMap.floorKey(key + "{");
            System.out.println("sandeep look here "+ from+" "+ to);
            if(from==null || to == null)break;
            res.add(list.subList(treeMap.get(from), Math.min(treeMap.get(from) + 3, treeMap.get(to) + 1)));
        }
        while (res.size() < searchWord.length()) {
           res.add(new ArrayList<>());
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> res = suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
        System.out.println(res.toString());
    }
}
