/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author ssingh Problem statement Amit has been working with an organization
 * called 'Money Traders' for the past few years. The organization is into the
 * money trading business. His manager assigned him a task. For a given
 * array/list of stock's prices for N days, find the stock's span for each day.
 *
 * The span of the stock's price today is defined as the maximum number of
 * consecutive days(starting from today and going backwards) for which the price
 * of the stock was less than today's price.
 *
 * For example, if the price of a stock over a period of 7 days are [100, 80,
 * 60, 70, 60, 75, 85], then the stock spans will be [1, 1, 1, 2, 1, 4, 6].
 *
 * Explanation: On the sixth day when the price of the stock was 75, the span
 * came out to be 4, because the last 4 prices(including the current price of
 * 75) were less than the current or the sixth day's price.
 *
 * Similarly, we can deduce the remaining results. Amit has to return an
 * array/list of spans corresponding to each day's stock's price. Help him to
 * achieve the task.
 */
public class StockSpan {

    public static int[] stockSpan(int[] price) {
        //Your code goes here

        // VERY IMPORTANT ONLY DEAL WITH INDEXES AND STORE INDEXES, NO NEED TO STORE ELEMENTS IN STACK
        int[] arr = new int[price.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < price.length; i++) {
            while (!stack.isEmpty() && price[i] > price[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                arr[i] = i + 1;
            } else {
                arr[i] = i - stack.peek();
            }
            stack.push(i);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] span = new int[]{60, 70, 80, 100, 90, 75, 80, 120};
        System.out.println(Arrays.toString(stockSpan(span)));
    }

}
