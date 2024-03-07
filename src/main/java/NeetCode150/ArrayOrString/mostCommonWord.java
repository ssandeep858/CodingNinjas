/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.ArrayOrString;

import java.util.*;

/**
 *
 * @author ssingh Input: paragraph = "Bob hit a ball, the hit BALL flew far
 * after it was hit.", banned = ["hit"] Output: "ball"
 */
public class mostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {

        // for constant lookup using hasSet or HashMap
        HashSet<String> set = new HashSet<>();
        for (String currentString : banned) {
            set.add(currentString);
        }

        // replace all non words => \\w+
        // [^a-zA-Z] which are not words
        String words[] = paragraph.toLowerCase().split("[^a-zA-Z]");
        for (String currentString : words) {
            System.out.println(currentString);
        }
        HashMap<String,Integer> hashMap=new HashMap<>();
        for (String currentString : words) {
            if(!set.contains(currentString)){
                hashMap.put(currentString, hashMap.getOrDefault(currentString, 0)+1);
            }
        }
        
        int max=0;
        String res="";
        
        for(Map.Entry<String,Integer> map: hashMap.entrySet()){
            if(hashMap.get(map.getKey())>max){
                max=hashMap.get(map.getKey());
                res=map.getKey();
            }
        }
        
        return res;
        
    }

    public static void main(String[] args) {
        String res = mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        System.out.println("result is ");
        System.out.println(res);
    }

}
