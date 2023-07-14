/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 * Sample Input 1 :
3
Sample Output 1 :
*
*1*
*121*
*12321*
*121*
*1*
*
 */
import java.util.*;

public class HalfDiamondPattern {

    public static void main(String[] args) {

        int numOfRows = 3;
        int row, col;
        System.out.println("*");
        
        for(int i=1;i<=numOfRows;i++){
            for(row=1;row<=i;row++){
                if(row==1)
                    System.out.print("*");
                System.out.print(row);
                if(row==i){
                    int temp=row;
                    while(temp>=1&&temp!=1){
                        System.out.print(--temp);
                    }
                    System.out.println("*");
                }
            }
            //System.out.println("");
           
        }
        for(int i=numOfRows-1;i>=1;i--){
            for(row=1;row<=i;row++){
                if(row==1)
                    System.out.print("*");
                System.out.print(row);
                if(row==i){
                    int temp=row;
                    while(temp>=1&&temp!=1){
                        System.out.print(--temp);
                    }
                    System.out.println("*");
                }
            }
            //System.out.println("");
           
        }
      System.out.println("*");

    }
}
