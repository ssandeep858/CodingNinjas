package com.mycompany.mavenproject1.ArraysPatterns;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 */
import java.util.*;
public class EvenOddSum {

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int odd = 0, even = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            if (s.charAt(i) % 2 == 0) {
                even += Character.getNumericValue(s.charAt(i));
            } else {
                odd += Character.getNumericValue(s.charAt(i));
            }
        }
        System.out.println(even + " " + odd);
    }
}
