package com.mycompany.mavenproject1.ArraysPatterns;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
4444
333 
22  
1
 */
import java.util.*;
public class SpecialPattern3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numOfRows=sc.nextInt();
        int row=1;
        while(row<=numOfRows){
            int col=1;
            while(col<=numOfRows){
                if(col<=numOfRows-row+1)
                    System.out.print(numOfRows-row+1);
                else 
                    System.out.print(" ");
            col++;
            }
            System.out.println("");
            row++;
        }
    }
}
