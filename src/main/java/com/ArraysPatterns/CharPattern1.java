package com.mycompany.mavenproject1.ArraysPatterns;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ssand ABC ABC ABC
 */
import java.util.*;

public class CharPattern1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfRows = sc.nextInt();
        int row = 1;
        while (row <= numOfRows) {
            int col = 1;
            while (col <= numOfRows) {
                char temp = (char) ('A' + col - 1);
                System.out.print(temp);
                col++;
            }
            System.out.println();
            row++;
        }
    }
}
