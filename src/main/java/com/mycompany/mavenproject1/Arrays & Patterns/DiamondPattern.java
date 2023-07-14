/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 *      r=1 c=5/5
 **    `r=2 c=4/5
 ***    r=3 c=3/5
 **     r=4 c=4/5
 *      r=5 c=5/5
 */
import java.util.*;

public class DiamondPattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfRows =5/2+1;
        int row, col;
        for (row = 0; row <= numOfRows; row++) {
            for (col = 1; col <= numOfRows-row; col++) {
                System.out.print(" ");
            }
            for (col = 1; col <= 2 * row - 1; col++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        for (row = numOfRows-1; row >=1 ; row--) {
            for (col = 1; col <= numOfRows-row; col++) {
                System.out.print(" ");
            }
            for (col = 1; col <= 2 * row - 1; col++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
