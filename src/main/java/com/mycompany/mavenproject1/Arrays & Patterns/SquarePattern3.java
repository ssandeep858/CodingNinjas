
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ssand
 */
public class SquarePattern3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfRows = sc.nextInt();
        int row = 1;
        while(row<=numOfRows){
            int col=1;
            while(col<=numOfRows){
                System.out.print(col);
                col++;
            }
            row++;
            System.out.println("");
        }
    }
}
