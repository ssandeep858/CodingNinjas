package com.mycompany.mavenproject1.DP;

import java.util.Arrays;

/*
 * Problem statement
Given a positive integer 'n', 
find and return the minimum number of steps that 'n' has to take to get reduced to 1. 
You can perform any one of the following 3 steps:

1.) Subtract 1 from it. (n = n - ­1) ,
2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
Write brute-force recursive solution for this.
 */
public class MinStepsToOne {

    public static int countMinStepsToOne(int n) {
        // Your code goes here
        if (n == 1) {
            return 0;
        }
        int opt1 = countMinStepsToOne(n - 1);
        int opt2 = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            opt2 = countMinStepsToOne(n / 3);
        }
        int opt3 = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            opt3 = countMinStepsToOne(n / 2);
        }
        return 1 + Math.min(opt1, Math.min(opt2, opt3));
    }

    // Memoization is top down. so coming back from 10 to 1
    public static int countMinStepsToOneMemoization(int n) {
        int storage[] = new int[n + 1];
        Arrays.fill(storage, -1);
        return countMinStepsToOneMemoization(n, storage);
    }

    public static int countMinStepsToOneMemoization(int n, int[] storage) {
        if(storage[n]!=-1){
            return storage[n];
        }
        if(n==1){
            storage[n]=0;
            return storage[n];
        }
        int opt1 = countMinStepsToOneMemoization(n - 1, storage);
        int opt2 = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            opt2 = countMinStepsToOneMemoization(n / 3,storage);
        }
        int opt3 = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            opt3 = countMinStepsToOneMemoization(n / 2,storage);
        }
        storage[n]=1 + Math.min(opt1, Math.min(opt2, opt3));
        return storage[n];
    }

    public static int countMinStepsToOneDynamic(int n) {
        if(n==0){
            return 0;
        }
        int dp[]= new int[n+1];
        Arrays.fill(dp, -1);
        dp[1]=0;
        for(int i=2;i<=n;i++){

            int opt1=dp[i-1];
            int opt2=Integer.MAX_VALUE;
            if(i%2==0){
                opt2=dp[i/2];
            }
            int opt3=Integer.MAX_VALUE;
            if(i%3==0){
                opt3=dp[i/3];
            }
            dp[i]=1 + Math.min(opt1, Math.min(opt2, opt3));
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(countMinStepsToOneDynamic(10));
    }
}
