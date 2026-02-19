package com.mycompany.mavenproject1.HashMapsPriorityQueues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TicketSelling {
    /*
     * You want to buy a ticket for a well-known concert which is happening in your
     * city. But the number of tickets available is limited. Hence the sponsors of
     * the concert decided to sell tickets to customers based on some priority.
     * 
     * A queue is maintained for buying the tickets and every person is attached
     * with a priority (an integer, 1 being the lowest priority).
     * 
     * The tickets are sold in the following manner -
     * 
     * 1. The first person (pi) in the queue requests for the ticket.
     * 2. If there is another person present in the queue who has higher priority
     * than pi, then ask pi to move at end of the queue without giving him the
     * ticket.
     * 3. Otherwise, give him the ticket (and don't make him stand in queue again).
     * Giving a ticket to a person takes exactly 1 second and it takes no time for
     * removing and adding a person to the queue. And you can assume that no new
     * person joins the queue.
     * 
     * Given a list of priorities of N persons standing in the queue and the index
     * of your priority (indexing starts from 0). Find and return the time it will
     * take until you get the ticket
     * Sample Input 1 :
     * 3
     * 3 9 4
     * 2
     * Sample Output 1 :
     * 2
     * Sample Output 1 Explanation :
     * Person with priority 3 comes out. But there is a person with higher priority
     * than him. So he goes and then stands in the queue at the end. Queue's status
     * : {9, 4, 3}. Time : 0 secs.
     * Next, the person with priority 9 comes out. And there is no person with
     * higher priority than him. So he'll get the ticket. Queue's status : {4, 3}.
     * Time : 1 secs.
     * Next, the person with priority 4 comes out (which is you). And there is no
     * person with higher priority than you. So you'll get the ticket. Time : 2
     * secs.
     * Sample Input 2 :
     * 5
     * 2 3 2 2 4
     * 3
     * Sample Output 2 :
     * 4
     */
    // 222
    // The Problem: Multiple people can have the SAME priority as you!
    // You need to track which specific person is you, not just the priority value:

    public static int buyTickeTEnhanced(int input[], int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        LinkedList<int[]> linkedList = new LinkedList<>();
        boolean hasServed = false;
        int time = 0;
        for (int i = 0; i < input.length; i++) {
            priorityQueue.add(input[i]);
            linkedList.add(new int[] { input[i], i });
        }

        while (!hasServed) {
            int currentHighestPriority = priorityQueue.peek();
            int currentFrontQueueELementPair[] = linkedList.peek();
            if (currentFrontQueueELementPair[0] == currentHighestPriority) {
                if (currentFrontQueueELementPair[1] == k) {
                    hasServed = true;
                }
                time++;
                linkedList.poll();
                priorityQueue.poll();

            } else {
                linkedList.add(linkedList.poll());
            }
        }

        return time;
    }

    public static int buyTicketWRONGSOLUTION(int input[], int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < input.length; i++) {
            priorityQueue.add(new int[] { input[i], i });
            linkedList.add(input[i]);
        }

        int time = 0;
        boolean broughtTicket = false;

        while (!broughtTicket) {
            if (priorityQueue.peek()[0] == linkedList.peek()) {
                if (priorityQueue.peek()[1] == k) {
                    // THIS IS WHERE CODE GOES WRONG
                    // WHEN WE HAVE (2,0),(2,2),(2,3) THEN AS PER PQ ANY 2 CAN BE POPPED/PEEK SO OUR
                    // RESULT COMES WRONG.
                    time++;
                    broughtTicket = true;
                } else {
                    int d[] = priorityQueue.poll();
                    int d2 = linkedList.poll();
                    time++;
                }
            } else {
                int temp = linkedList.poll();
                linkedList.add(temp);
            }
        }

        return time;
    }

    public static int buyTicket(int input[], int k) {
        int myPriority = input[k];
        LinkedList<Boolean> isTarget = new LinkedList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < input.length; i++) {
            linkedList.add(input[i]);
            maxHeap.add(input[i]);
            isTarget.add(i == k);
        }
        System.out.println(linkedList);
        System.out.println(maxHeap);
        int time = 0;
        while (!linkedList.isEmpty()) {
            int currentPriority = linkedList.peek();
            int maxPriority = maxHeap.peek();
            boolean myPosition = isTarget.peek();
            System.out.println("current is " + currentPriority);
            System.out.println("max heap is " + maxPriority);
            if (currentPriority == maxPriority) {
                linkedList.poll();
                maxHeap.poll();
                isTarget.poll();
                time++;
                if (currentPriority == myPriority && myPosition) {
                    return time;
                }
            } else {
                linkedList.poll();
                linkedList.add(currentPriority);
                isTarget.add(isTarget.poll());
            }
            System.out.println(linkedList);
            System.out.println(maxHeap);
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println(buyTicket(new int[] { 2, 3, 2, 2, 4 }, 3));
    }
    /*
     * 3 ,9 ,4
     * 2
     * maxHeap
     * 9 , 4 , 3
     * time=0;
     * 
     * peek == arr??
     * 3==9
     * list se delete plus end mein add
     * 9 4 3
     * 9== 9
     * pop and list se delete
     * time++
     * 4
     */
}
