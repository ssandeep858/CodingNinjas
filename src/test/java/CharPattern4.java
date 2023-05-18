/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * 
 *
4
A
BC
CDE
DEFG
 */
import java.util.*;
public class CharPattern4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numOfRows=sc.nextInt();
        int row=1;
        char first='A';
        while(row<=numOfRows){
            int col=1;
            while(col<=row){
                System.out.print((char)(first+col-1));
                col++;
            }
            first++;
            System.out.println();
            row++;
        } 
    }
}
