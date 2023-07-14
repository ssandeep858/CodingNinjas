
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 */
public class NthFibonacci {
    public static int fibElement(int n){
        if(n==1){
            return 0;
        }
        else if(n==2){
            return 1;
        }
        int first=0;
        int second=1;
        int sum=0;
        for(int i=1;i<n;i++){
            System.out.println("first before is "+first);
            System.out.println("second before is "+second);
            System.out.println("sum before is "+sum);
            sum=first+second;
            first=second;
            second=sum;
            System.out.println("first is "+first);
            System.out.println("second is "+second);
            System.out.println("sum is "+sum);
        }
        return sum;
    }
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt(); 
        System.out.println(fibElement(n));
    }
    
}
