/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 * 
5
9
8
4
5
6
 */
import java.util.*;

public class isDecreasingOrIncreasing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int prev = sc.nextInt();
        boolean isDecreasing = true;
        boolean isIncreasing = true;
        int switchCount = 0;
        while (sc.hasNextInt()) {
            int next = sc.nextInt();
            if (next == prev) {
                System.out.println("== case false");
                System.exit(0);
            } else if (next > prev){
                if(isDecreasing == true){
                    isDecreasing=false;
                    switchCount++;
                    isIncreasing=true;
                }
                isIncreasing=true;
                }
            else {
                if(isIncreasing == true){
                    isIncreasing=false;
                    switchCount++;
                    isDecreasing=true;
                }
                isDecreasing=true;
            }
            prev=next;
        }
        if(switchCount<=1)
                System.out.println("true");
            else System.out.println("false");
    }
}
