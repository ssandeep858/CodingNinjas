/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stacks;

/**
 *
 * @author ssingh Problem statement Implement a Stack Data Structure
 * specifically to store integer data using a Singly Linked List.
 *
 * The data members should be private.
 *
 * You need to implement the following public functions :
 *
 * 1. Constructor: It initialises the data members as required.
 *
 * 2. push(data) : This function should take one argument of type integer. It
 * pushes the element into the stack and returns nothing.
 *
 * 3. pop() : It pops the element from the top of the stack and in turn, returns
 * the element being popped or deleted. In case the stack is empty, it returns
 * -1.
 *
 * 4. top : It returns the element being kept at the top of the stack. In case
 * the stack is empty, it returns -1.
 *
 * 5. size() : It returns the size of the stack at any given instance of time.
 *
 * 6. isEmpty() : It returns a boolean value indicating whether the stack is
 * empty or not.
 *
 * Operations Performed on the Stack: Query-1(Denoted by an integer 1): Pushes
 * an integer data to the stack.
 *
 * Query-2(Denoted by an integer 2): Pops the data kept at the top of the stack
 * and returns it to the caller.
 *
 * Query-3(Denoted by an integer 3): Fetches and returns the data being kept at
 * the top of the stack but doesn't remove it, unlike the pop function.
 *
 * Query-4(Denoted by an integer 4): Returns the current size of the stack.
 *
 * Query-5(Denoted by an integer 5): Returns a boolean value denoting whether
 * the stack is empty or not. Detailed explanation ( Input/output format, Notes,
 * Images ) Constraints: 1 <= q <= 10^5 1 <= x <= 5 -2^31 <= data <= 2^31 - 1
 * and data != -1
 *
 * Where 'q' is the total number of queries being performed on the stack, 'x' is
 * the range for every query and data represents the integer pushed into the
 * stack.  *
 * Time Limit: 1 second Sample Input 1: 6 1 13 1 47 4 5 2 3 Sample Output 1: 2
 * false 47 13
 */
class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public class StackImplementUsingLL {

    //Define the data members
    private Node head;
    private int size;

    public StackImplementUsingLL() {
        //Implement the Constructor
        head = null;
        size = 0;
    }

    /*----------------- Public Functions of Stack -----------------*/
    public int getSize() {
        //Implement the getSize() function
        return size;
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void push(int element) {
        //Implement the push(element) function
        if (head == null) {
            Node firstElement = new Node(element);
            head = firstElement;
            size++;
        } else {
            Node newElement = new Node(element);
            newElement.next = head;
            head = newElement;
            size++;
        }
    }

    public int pop() {
        //Implement the pop() function
        if (size > 0) {
            int temp = head.data;
            head = head.next;
            size--;
            return temp;
        } else {
            return -1;
        }
    }

    public int top() {
        //Implement the top() function
        if (size == 0) {
            return -1;
        }
        return head.data;

    }
}
