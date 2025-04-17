/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.NeetCode75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author ssingh
 */
public class topKFrequent {
//PriorityQueue<String> pq=new PriorityQueue<String>(5, Comparator.comparing(String::length));
//PriorityQueue<String> pq=new PriorityQueue<String>(5, (a,b) -> a.length() - b.length());
// VERY VERY VERY IMPORTANT 
//PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0)+1);
        }
        System.out.println(hashMap);
        int []res=new int[k];
        //This will sort on base of values but will take whole hash pair as input
        //PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
//        for( Map.Entry hash: hashMap.entrySet()){
//            // not hash.value or hash.key
//            pq.add(hash);
//        }
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> hashMap.get(b)-hashMap.get(a));
        for( Map.Entry<Integer,Integer> hash: hashMap.entrySet()){
            // not hash.value or hash.key
            pq.add(hash.getKey());
        }
        for( int i=0;i<k;i++){
            System.out.println(pq.peek());
            res[i]=pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int [] input=new int[]{1,1,1,2,2,3,3,3,3};
        int[] res=topKFrequent(input, 2);
        for(int i =0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
