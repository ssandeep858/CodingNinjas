/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 */
public class FahrenhietCelcius {

    public static void printFahrenheitTable(int start, int end, int step) {
        /* Your class should be named Solution 
		 * Don't write main(). 
		 * Don't read input, it is passed as function argument. 
		 * Print the specified output in required format. 
		 * Taking input is handled automatically. 
         */
        int fStart = start, fEnd = end, fStep = step;
        for (int i = fStart; i <= fEnd; i += fStep) {
            int temp = Math.round(((i - 32) * 5) / 9);
            System.out.println(i + " " + temp);
        }

    }
}    