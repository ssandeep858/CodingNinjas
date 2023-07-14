/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 */
public class OddEvenArrange {

    public static void arrange(int[] arr, int n) {
        // Your code goes here
        int oddIndex = 0;
        int evenIndex = n - 1;
        int startPoint = 1;
        while (startPoint <= n) {
            if (startPoint % 2 == 0) {
                arr[evenIndex] = startPoint;
                evenIndex--;
            } else {
                arr[oddIndex] = startPoint;
                oddIndex++;
            }
            startPoint++;
        }
    }
}
