/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

import java.util.Arrays;

/**
 *
 * @author ssingh
 */
public class testing {

    public static int[] allIndexes(int input[], int x, int fsf, int index) {
        if (index == input.length) {
            return new int[fsf];
        }

        if (input[index] == x) {
            int res[] = allIndexes(input, x, fsf + 1, index + 1);
            res[fsf] = index;
            return res;
        } else {
            int res[] = allIndexes(input, x, fsf, index + 1);
            return res;
        }

    }

    public static int[] allIndexes(int input[], int x) {
        return allIndexes(input, x, 0, 0);
    }

    public static int convertStringToInt(String input) {
        if (input.length() == 1) {
            return Integer.parseInt(input.charAt(0) + "");
        }

        int temp = convertStringToInt(input.substring(1));
        int ttp = input.length() - 1;
        int firstNum = Integer.parseInt(input.charAt(0) + "");
        return (int) (firstNum * Math.pow(10, ttp) + temp);
    }

    public static char helper(int num) {

        return (char) (num + 'a' - 1);
    }

    public static String[] getCode(String s) {
        if (s.length() == 0) {
            return new String[]{""};
        }

        boolean numCheck = (s.length() > 1 && Integer.parseInt(s.substring(0, 2)) < 27);

        if (numCheck) {
            String[] smallOutput1 = getCode(s.substring(1));
            String[] smallOutput2 = getCode(s.substring(2));
            String[] finalResult = new String[smallOutput1.length + smallOutput2.length];

            for (int i = 0; i < smallOutput1.length; i++) {
                finalResult[i] = helper(Integer.parseInt(s.charAt(0) + "")) + smallOutput1[i];
            }

            for (int i = 0; i < smallOutput2.length; i++) {
                finalResult[i + smallOutput1.length] = helper(Integer.parseInt(s.substring(0, 2))) + smallOutput2[i];
            }
            return finalResult;
        } else {
            String[] smallOutput1 = getCode(s.substring(1));
            for (int i = 0; i < smallOutput1.length; i++) {
                smallOutput1[i] = helper(Integer.parseInt(s.charAt(0) + "")) + smallOutput1[i];
            }
            return smallOutput1;
        }
    }

    public static char[] helperFunction(int number) {
        switch (number) {
            case 2:
                return new char[]{'a', 'b', 'c'};
            case 3:
                return new char[]{'d', 'e', 'f'};
            case 4:
                return new char[]{'g', 'h', 'i'};
            case 5:
                return new char[]{'j', 'k', 'l'};
            case 6:
                return new char[]{'m', 'n', 'o'};
            case 7:
                return new char[]{'p', 'q', 'r', 's'};
            case 8:
                return new char[]{'t', 'u', 'v'};
            case 9:
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return new char[]{};
        }
    }

    public static String[] keypad(int n) {
        if (n == 0) {
            return new String[]{""};
        }
        String[] temp = keypad(n / 10);
        char[] smallRes = helperFunction(n % 10);
        String[] finalResult = new String[temp.length * smallRes.length];//as doing cross product
        int c = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < smallRes.length; j++) {
                finalResult[c++] = temp[i] + "" + smallRes[j];
            }
        }
        return finalResult;
    }

    public static int fact(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static String[] permutation(String s){
        if(s.length()==0){
            return new String[]{""};
        }
        
        String res[]=new String[fact(s.length())];
        int resCount=0;
        for( int i =0;i<s.length();i++){
            String subString=s.substring(0, i)+s.substring(i+1);
            String[] smallOutput=permutation(subString);
            //System.out.println("substring size is "+ subString.length()+" "+smallOutput.length);
            // very very very important
            for(int j=0;j<smallOutput.length;j++){
                res[resCount++]=s.charAt(i)+smallOutput[j];
            }
        }
        return res;
    }
    
  
    public static void main(String[] args) {

        String p[]=permutation("abc");
        System.out.println(Arrays.toString(p));
        String f[] = keypad(23);
        System.out.println(Arrays.toString(f));
        String res[] = getCode("1123");
        System.out.println(Arrays.toString(res));
        System.out.println(convertStringToInt("00012312"));
        String input = "123";
        System.out.println(input.charAt(0));
        int res1[] = allIndexes(new int[]{1, 2, 3, 2, 4, 2}, 2);
        for (int i = 0; i < res1.length; i++) {
            System.out.print(res1[i] + " ");
        }
    }
}
