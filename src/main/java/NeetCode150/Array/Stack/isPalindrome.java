/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.Stack;

/**
 *
 * @author ssingh
 */
public class isPalindrome {

// could be solved using left and right pointer 
// just check if it lies between A Z a z 0 9 and if difference of char value = Math.abs('A'-'a')    
//(lc == rc || isLetter(lc) && isLetter(rc) && Math.abs(lc - rc) == Math.abs('a' - 'A')
// either same hoga ya fir left mein A ho ya right me a so absolute difference dekhengein    
    
    
    //  s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    public static String getCleanString(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                res += (s.charAt(i) + "").toLowerCase();
            }
        }
        return res;
    }

    //  racecar
    //  0123456
    public static  boolean isPalindrome(String s) {
        s = getCleanString(s);
        System.out.println(s);
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() -1 - i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
