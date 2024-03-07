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
 * @author ssingh Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the
 * original list of strings.
 *
 * Please implement encode and decode Input: ["lint","code","love","you"]
 * Output: ["lint","code","love","you"] Explanation: One possible encode method
 * is: "lint:;code:;love:;you"
 */
public class EncodeAndDecode {

    public static String encode(List<String> strs) {
        // write your code here
        String res = "";
        for (int i = 0; i < strs.size(); i++) {
            res += strs.get(i).length() + "#" + strs.get(i);
        }
        return res;
    }

    public static List<String> decode(String str) {
        // write your code here
        //str+=" ";
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#' && j < str.length()) {
                j++;
            }
            String currentLengthString = str.substring(i, j);
            int currentLength = Integer.valueOf(currentLengthString);
            res.add(str.substring(j + 1, j + 1 + currentLength).trim());
            i = j + 1 + currentLength;
        }
        return res;
    }

    public static void main(String[] args) {
        String res = encode(Arrays.asList("lintcdcdcdc", "code", "love", "you"));
        System.out.println(res);
        List<String> r = decode(res);
        System.out.println(Arrays.toString(r.toArray()));
    }
}
