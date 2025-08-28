package com.mycompany.mavenproject1.HashMapsPriorityQueues;

import java.util.ArrayList;
import java.util.PriorityQueue;
/*
 * You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.

Time complexity should be O(nlogk) and space complexity should be not more than O(k).

Order of elements in the output is not important.
Sample Input :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
4
Sample Output :
12
16
20
25
 */
import java.util.concurrent.PriorityBlockingQueue;

public class KLargestElement {

    public static ArrayList<Integer> kLargest(int input[], int k) {

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> a-b);
        for(int i=0;i<input.length;i++){
            pq.add(input[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        ArrayList<Integer> res=new ArrayList<>(pq);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(kLargest(new int[]{2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6}, 4));
    }
}
