/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh
 */
public class SubStringOfString {

    public static void generate2(String word) {
        for (int from = 0; from < word.length(); from++) {
            for (int to = from + 1; to <= word.length(); to++) {
                System.out.println("output was " + word.substring(from, to));
                if (from == word.length() - 1 && to == word.length()) {
                    System.out.println("output was " + word.substring(from + 1, to));
                }
            }
        }
    }

    public static void subStringsSlidingWindow(String word) {
        int count = 0;
        int startWindow = 0, endWindow = 1;
        while (count != word.length() - 1) {
            if (endWindow == word.length() + 1) {
                startWindow++;
                endWindow = startWindow + 1;
                count++;
            }
            System.out.println(word.subSequence(startWindow, endWindow++));
            //for empty array
            if (startWindow == word.length() - 1) {
                System.out.println(word.subSequence(startWindow + 1, endWindow-1));
            }
        }
    }

    //  0 2
    public static void main(String[] args) {
        subStringsSlidingWindow("xyz");
    }
}
