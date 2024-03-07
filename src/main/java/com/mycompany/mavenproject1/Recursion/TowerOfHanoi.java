/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Recursion;

/**
 *
 * @author ssingh Tower of Hanoi is a mathematical puzzle where we have three
 * rods and n disks. The objective of the puzzle is to move all disks from
 * source rod to destination rod using third rod (say auxiliary). The rules are
 * : 1) Only one disk can be moved at a time. 2) A disk can be moved only if it
 * is on the top of a rod. 3) No disk can be placed on the top of a smaller
 * disk. Print the steps required to move n disks from source rod to destination
 * rod. Source Rod is named as 'a', auxiliary rod as 'b' and destination rod as
 * 'c'. Input Format : Integer n Output Format : Steps in different lines (in
 * one line print source and destination rod name separated by space)
 * Constraints : 0 <= n <= 20 Sample Input 1 : 2 Sample Output 1 : a b a c b c
 * Sample Input 2 : 3 Sample Output 2 : a c a b c b a c b a b c a c
 */
public class TowerOfHanoi {

    public static void printState(int start, int end) {
        System.out.println((char) (start + 96) + " " + (char) (end + 96));
    }

    public static void towerOfHanoi(int disks, int start, int end) {
        if (disks == 1) {
            printState(start, end);
        } else {
            int other = 6 - (start + end);
            towerOfHanoi(disks - 1, start, other);
            printState(start, end);
            towerOfHanoi(disks - 1, other, end);
        }
    }

    public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
        // Write your code here
        //System.out.println((destination-96));
        towerOfHanoi(disks, (source - 96), (destination - 96));
    }

    public static void main(String[] args) {
        towerOfHanoi(3, 'a', 'b', 'c');
    }
}
