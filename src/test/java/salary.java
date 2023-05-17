/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 */
import java.util.*;

public class salary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a[] = new String[2];
        a = sc.nextLine().split(" ");
        int base = Integer.parseInt(a[0]);
        char grade = a[1].charAt(0);
        double total = 0;
        switch (grade) {
            case 'A': {
                total = base + (0.2 * base) + (0.5 * base) + 1700 - (0.11 * base);
                break;
            }
            case 'B': {
                total = base + (0.2 * base) + (0.5 * base) + 1500 - (0.11 * base);
                break;
            }
            default: {
                total = base + (0.2 * base) + (0.5 * base) + 1300 - (0.11 * base);
            }
        }
        total = Math.round(total);
        System.out.println((int) total);

    }

}
