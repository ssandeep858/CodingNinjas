package com.mycompany.mavenproject1.HashMapsPriorityQueues;

import java.util.HashMap;

public class UniqueChar {

    /*
     * Given a string S, you need to remove all the duplicates. That means, the
     * output string should contain each character only once. The respective order
     * of characters should remain same, as in the input string.
     * Sample Input 1 :
     * ababacd
     * Sample Output 1 :
     * abcd
     * Sample Input 2 :
     * abcde
     * Sample Output 2 :
     * abcde
     */

    public static String uniqueChar(String str) {
        HashMap<Character,Integer> hashMap=new HashMap<>();
        StringBuilder stringBuilder= new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(!hashMap.containsKey(str.charAt(i))){
                hashMap.put(str.charAt(i), hashMap.getOrDefault(str.charAt(i), 0)+1);
                System.out.println("inside "+ str.charAt(i));
                System.out.println(hashMap);
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        System.out.println(uniqueChar("ababacd"));
    }
}
