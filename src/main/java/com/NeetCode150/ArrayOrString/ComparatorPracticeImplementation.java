/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.ArrayOrString;

import java.util.*;
import java.util.PriorityQueue;

/**
 *
 * @author ssingh
 */
public class ComparatorPracticeImplementation {
        public static void main(String[] args) {
        ComparatorPractice c=new ComparatorPractice();
        Sandeep s1=new Sandeep(7, "sandy");
        Sandeep s2=new Sandeep(8, "sandyy");
        Sandeep s3=new Sandeep(9, "sandyyy");
        Sandeep s4=new Sandeep(10, "sandyyyy");
        Sandeep s5=new Sandeep(11, "sandyyyyy");
        Sandeep s6=new Sandeep(12, "sandyyyyyy");
        PriorityQueue<Sandeep> pq= new PriorityQueue<>(c);
        pq.add(s1);
        pq.add(s2);
        pq.add(s3);pq.add(s4);pq.add(s5);pq.add(s6);
        System.out.println(pq.peek().name);
        System.out.println(pq.peek().age);
    }
}
