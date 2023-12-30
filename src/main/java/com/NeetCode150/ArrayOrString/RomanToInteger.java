/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.ArrayOrString;

/**
 *
 * @author ssingh I 1 V 5 X 10 L 50 C 100 D 500 M 1000 Roman numerals are
 * usually written largest to smallest from left to right. However, the numeral
 * for four is not IIII. Instead, the number four is written as IV. Because the
 * one is before the five we subtract it making four. The same principle applies
 * to the number nine, which is written as IX. There are six instances where
 * subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
 * and M (1000) to make 400 and 900.
 */
public class RomanToInteger {

    public static int getMapValue(char c) {
        switch (c) {
            case 'I': {
                return 1;
            }
            case 'V': {
                return 5;
            }
            case 'X': {
                return 10;
            }
            case 'L': {
                return 50;
            }
            case 'C': {
                return 100;
            }
            case 'D': {
                return 500;
            }
            case 'M': {
                return 1000;
            }
            default:
                return 0;
        }
    }

    public static int romanToInt(String s) {

        int sum = 0;
        int first = getMapValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int second = getMapValue(s.charAt(i));

            if (second > first) {
                sum -= first;
            } else {
                sum += first;
            }
            first = second;
        }
        sum += first;
        return sum;
    }

    // IV 4   1   5  MCMXCIV
    // MC  1100  1000 100
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
 // 50 5 1 1 1
