package com.mycompany.mavenproject1.ArraysPatterns;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ssand
 */
public class FindUnique {

    public static int findUnique(int[] arr) {
       
        int res=0;
        for(int i=0;i<arr.length;i++){
            res^=arr[i];
        }
        System.out.println(res);
        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for (int j = 0; j < arr.length; j++) {
                if(j ==i)
                    continue;
                //System.out.println("arr[i] is " + arr[i] + " and " + "arr[j] is " + arr[j]);
                if (arr[i] == arr[j]) {
                    found = true;
                }
            }
            if (found == false) {
                //System.out.println("false arr[i] is " + arr[i]);
                return arr[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int res = findUnique(new int[]{2, 3, 1, 6, 3, 6, 2});
        
        System.out.println(res);
    }
}
