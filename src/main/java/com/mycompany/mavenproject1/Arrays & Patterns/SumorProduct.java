
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ssand Write a program that asks the user for a number N and a choice
 * C. And then give them the possibility to choose between computing the sum and
 * computing the product of all integers in the range 1 to N (both inclusive).
 * If C is equal to - 1, then print the sum 2, then print the product Any other
 * number, then print '-1' (without the quotes) Input format : Line 1 : Integer
 * N Line 2 : Choice C Output Format : Sum or product according to user's choice
 * Constraints : 1 <= N <= 12 Sample Input 1 : 10 1 Sample Output 1 : 55 Sample
 * Input 2 : 10 2 Sample Output 2 : 3628800
 */
public class SumorProduct {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            String num = sc.nextLine();
            String input =sc.nextLine();
        boolean add = false, multipy = false;
        if (input.equals("1")) {
            add = true;
        } else if (input.equals("2")) {
            multipy = true;
        }
        if (!add && !multipy) {
            System.out.print(-1);
            return;
        }
        int res=add ? 0:1;
        for (int i = 1; i <= Integer.valueOf(num); i++) {
            if(add){
                res+=i;
            }else
                res*=i;
        }
        System.out.print(res);
    }
}
