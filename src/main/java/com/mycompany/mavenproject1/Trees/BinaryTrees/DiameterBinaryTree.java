/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees.BinaryTrees;

/**
 *
 * @author ssingh
 */
class Diameter {

    int height;
    int diameter;

    public Diameter(int height, int diameter) {
        this.diameter = diameter;
        this.height = height;
    }
}

public class DiameterBinaryTree {

    // ab agr dhyan se dekhe toh har node pr height nikalni padh rhi hai and fir diameter ki call bhi rahi hai
    // diamater dobara hieght nikal rha hai. So basically ek jawab jo humne nikala tha uski calculation dobara karni padh rhi hai
    // Ab agr tree badia se split hai toh complexity hogi nlogn as har tree ke node pr left aur right ki hieght niklegi jo ki O(N) hogi
    // and then ussi main root node ke left and right pr same recursive cal kr di which will be T(n/2) work so basicall equation bantihai merge sort jaisi
    // On + t(n/2) jiski complexity hoti hai nlogn in best case scenario
    // Ab imagine karo tree ache se split nahi hai and sirf ek ho side ko hai. 
    // Then complexity hogi O(n2) as root neeche wale ko bolega hieght laa which is On and then neeche wale pr diameter call krega which is T(n-1)
    // matlab jaise bubble sort mein hota tha ki ek node ko sabse compare krke max ko last mein rakh dete the and then same process ko bache hue n-1 elements 
    // pr perform krte the. so equation hoti thi Kn + T(n-1) jiski complexity hoti hai O(n2) worst case scenario. 
    public static int diameter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int value1 = height(root.left) + height(root.right);
        int value2 = diameter(root.left);
        int value3 = diameter(root.right);
        return Math.max(value1, Math.max(value2, value3));
    }

    public static Diameter enhancedDiameter(BinaryTreeNode<Integer> root) {
        if( root ==null){
            return new Diameter(0, 0);
        }
        Diameter leftSide= enhancedDiameter(root.left);
        Diameter rightSide= enhancedDiameter(root.right);
        int height=1+Math.max(leftSide.height,rightSide.height);
        int value1=leftSide.height+rightSide.height;
        int value2=leftSide.diameter;
        int value3=rightSide.diameter;
        return new Diameter(height, Math.max(value1, Math.max(value2, value3)));
    }

    public static int height(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) {
            return 0;
        }
        int h = 1;
        int leftH = height(root.left);
        int rightH = height(root.right);
        return h + Math.max(leftH, rightH);
    }
}
