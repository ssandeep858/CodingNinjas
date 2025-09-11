package com.mycompany.mavenproject1.DP;

public class Fibonacci {

    /*
     * The Fibonacci Sequence (with indices):
     * 
     * Position 0: 0
     * Position 1: 1
     * Position 2: 1
     * Position 3: 2
     * Position 4: 3
     * Position 5: 5
     * Position 6: 8
     * 
     * So yes, 5 is at index/position 5, which makes it the 6th number in the
     * sequence (when counting from 1).
     * 2n-1 calls so O(n) is complexity
     */
    public static int fib(int n) {
        int arr[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = -1;
        }
        return fibDP(n, arr);
    }

    private static int fibDP(int n, int[] arr) {
        if (n == 0 || n == 1) {
            arr[n] = n;
            return n;
        }
        if (arr[n] != -1) {
            return arr[n];
        }
        arr[n] = fibDP(n - 1, arr) + fibDP(n - 2, arr);
        return arr[n];
    }

    // pure DP with no recursion and top down approach.
    private static int fibDPIIterative(int n) {
        int arr[]=new int[n+1];
        arr[0]=0;
        arr[1]=1;

        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(fibDPIIterative(44));
    }
}
