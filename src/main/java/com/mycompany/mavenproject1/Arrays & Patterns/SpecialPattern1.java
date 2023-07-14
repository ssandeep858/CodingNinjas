/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
   *
  **
 ***
****
 */
import java.util.*;

public class SpecialPattern1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numOfRows=sc.nextInt();
        int row=1;
        while(row<=numOfRows){
            int col=1;
            while(col<=numOfRows){
                if(col>numOfRows-row){
                    System.out.print("*");
                }else
                System.out.print(" ");
                col++;
            }
            System.out.println("");
            row++;
        }
    }
    
}
