/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author ssingh
 */
public class Mavenproject1 {

    public static void print(int n) {
        if (n < 0) {
            return;
        }
        if (n == 0) {
            System.out.println(n);
            return;
        }
        print(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        print(3);
    }
}
