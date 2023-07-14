/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * 
 *
    E
    DE
    CDE
    BCDE
    ABCDE
 */
import java.util.*;
public class CharPattern5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numOfRows=sc.nextInt();
        int row=1;
        char first=(char)('A'+numOfRows);
        while(row<=numOfRows){
            int col=1;
            while(col<=row){
                System.out.print((char)(first+col-1));
                col++;
            }
            first--;
            System.out.println();
            row++;
        } 
    }
}
