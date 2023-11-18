/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.ArrayOrString;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author ssingh
 */
class Sandeep{

    int age;
    String name;
    
    public Sandeep(int age, String name){
        this.age=age;
        this.name=name;
    }
}

public class ComparatorPractice implements Comparator<Sandeep>{

    @Override
    public int compare(Sandeep s1, Sandeep s2) {
        return Integer.compare(s2.age, s1.age);
    }
    
}
