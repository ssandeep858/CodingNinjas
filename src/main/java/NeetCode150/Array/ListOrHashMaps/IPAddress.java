/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.Arrays;

/**
 *
 * @author ssingh
 */
public class IPAddress {

   public static boolean checkIPV4(String s) {
        String arr[] = s.split("\\.");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length()==1 && arr[i].charAt(0) == '0'){
                continue;
            }
            if (arr[i].length() == 0 || arr[i].charAt(0) == '0' || arr[i].length() > 3) {
                return false;
            }
            int l = arr[i].length();
            for (int j = 0; j < l; j++) {
                if (!Character.isDigit(arr[i].charAt(j))) {
                    return false;
                }
            }
            if(Integer.parseInt(arr[i]) > 255){
                return false;
            }
        }
        return true;
    }

    public static boolean checkIPV6(String s) {
        String arr[] = s.split("\\:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > 4|| arr[i].length()==0) {
                return false;
            }
            int l = arr[i].length();
            for (int j = 0; j < l; j++) {
                 if (!((arr[i].charAt(j) >= '0' && arr[i].charAt(j) <= '9') || (arr[i].charAt(j) >= 'A' && arr[i].charAt(j) <= 'F')
                        || (arr[i].charAt(j) >= 'a' && arr[i].charAt(j) <= 'f'))) {
                    System.out.println("yaha galti hai");
                    return false;
                }
            }
        }
        return true;
    }

    public static String validIPAddress(String queryIP) {
        
        if (queryIP.length()==0 || queryIP.charAt(queryIP.length()-1) == ':' || queryIP.charAt(queryIP.length() - 1) == '.') {
            return "Neither";
        }
        if (queryIP.split("\\.").length == 4) {
            //System.out.println("4");
            if (checkIPV4(queryIP)) {
                return "IPv4";
            }
        } else if (queryIP.split("\\:").length == 8) {
            //System.out.println("8");
            if (checkIPV6(queryIP)) {
                return "IPv6";
            }
        }
        return "Neither";

    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("192.0.0.1"));
    }

}
