package queues;

import java.util.*;

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public class QueueUsingLL {

    //Define the data members
    private Node front;
    private Node rear;
    private int size;

    public QueueUsingLL() {
        //Implement the Constructor
        front = null;
        rear = null;
        size = 0;
    }

    /*----------------- Public Functions of Stack -----------------*/
    public int getSize() {
        //Implement the getSize() function
        return size;
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return size == 0;
    }

    public void enqueue(int data) {
        //Implement the enqueue(element) function
        Node firstNode = new Node(data);
        if (size == 0) {
            front = firstNode;
            rear = firstNode;
        } else {
            rear.next = firstNode;
            rear = rear.next;
        }
        size++;
    }
    
    public int dequeue() {
        //Implement the dequeue() function
        if (size == 0) {
            return -1;
        }
        int temp = front.data;
        front = front.next;
        size--;
        if (size == 0) {
            front = null;
            rear = null;
        }
        return temp;
    }

    public int front() {
        //Implement the front() function
        if (size == 0) {
            return -1;
        }
        int temp = front.data;
        return temp;
    }
}
