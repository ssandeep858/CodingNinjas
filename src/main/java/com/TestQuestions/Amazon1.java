/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author ssingh
 */
public class Amazon1 {

    public static int[] findMaximumBookId(List<Integer> portalUpdate) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<Integer> maxCounts = new PriorityQueue<>((a,b)-> b-a);
        int res[] = new int[portalUpdate.size()];
        for (int i = 0; i < portalUpdate.size(); i++) {
            int value = portalUpdate.get(i);
            int currentCount = hashMap.getOrDefault(value, 0);
            maxCounts.remove(value > 0 ? hashMap.getOrDefault(value, 0) : hashMap.get((-value)));
            if (value > 0) {
                hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
            } else {
                value = -portalUpdate.get(i);
                hashMap.put(value, hashMap.get(value) - 1);
            }
            maxCounts.add(hashMap.get(value));
            res[i] = maxCounts.peek();
            System.out.println(Arrays.toString(hashMap.entrySet().toArray()));
            System.out.println(Arrays.toString(res));
            //System.out.println(Arrays.toString(maxCounts.toArray()));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMaximumBookId(Arrays.asList(6, 6, 2, -6, -2, -6)));
    }
}
