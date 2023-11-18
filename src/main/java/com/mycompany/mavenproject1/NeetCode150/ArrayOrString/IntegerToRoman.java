/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.ArrayOrString;

/**
 *
 * @author ssingh Example 1:
 *
 * Input: num = 3 Output: "III" Explanation: 3 is represented as 3 ones. Example
 * 2:
 *
 * Input: num = 58 Output: "LVIII" Explanation: L = 50, V = 5, III = 3. Example
 * 3:
 *
 * Input: num = 1994 Output: "MCMXCIV" Explanation: M = 1000, CM = 900, XC = 90
 * and IV = 4.
 */
public class IntegerToRoman {

    public static String getMapValue(int num) {
        switch (num) {
            case 1: {
                return "I";
            }
            case 4: {
                return "IV";
            }
            case 5: {
                return "V";
            }
            case 9: {
                return "IX";
            }
            case 10: {
                return "X";
            }
            case 40: {
                return "XL";
            }
            case 50: {
                return "L";
            }
            case 90: {
                return "XC";
            }
            case 100: {
                return "C";
            }
            case 400: {
                return "CD";
            }
            case 500: {
                return "D";
            }
            case 900: {
                return "CM";
            }
            case 1000: {
                return "M";
            }
            default:
                return "INVALID";
        }
    }

    public static String intToRoman(int num) {
        int romanNumbers[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String res = "";
        int currentIndex = romanNumbers.length - 1;
        while (num != 0) {
            if (num / romanNumbers[currentIndex] > 0) {
                res += getMapValue(romanNumbers[currentIndex]);
                num = num - romanNumbers[currentIndex];
            } else {
                currentIndex--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
