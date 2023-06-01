
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 5432*
 543*1
 54*21
 5*321
 *4321
 */
public class NumberStarPattern1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for(int i=1;i<=input;i++){
            for(int j=1;j<=input;j++){
                if(j==input-i+1){
                    System.out.print("*");
                }
                else{
                    System.out.print(input-j+1);
                }
            }
            System.out.println("");
        }
    }
}
