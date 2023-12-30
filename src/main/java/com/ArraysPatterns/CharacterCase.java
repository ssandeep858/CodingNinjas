package com.mycompany.mavenproject1.ArraysPatterns;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 */
public class CharacterCase {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the character");
        char c=sc.nextLine().charAt(0);
        if(c>='A'&&c<='Z'){
            System.out.println("1");
        }else if(c>='a'&&c<='z'){
            System.out.println("0");
        }
        else System.out.println("-1");
    }
}
