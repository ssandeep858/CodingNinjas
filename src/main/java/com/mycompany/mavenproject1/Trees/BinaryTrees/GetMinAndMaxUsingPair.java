package com.mycompany.mavenproject1.Trees.BinaryTrees;

import NeetCode150.Array.ListOrHashMaps.minCostConnectPoints;

/*
 * Problem statement
For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.

Return the output as an object of Pair class, which is already created.

Note:
All the node data will be unique and hence there will always exist a minimum and maximum node data.
 * 
 */
class Pair<T, U> {
    T minimum;
    U maximum;

    public Pair(T minimum, U maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

}

public class GetMinAndMaxUsingPair {

    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
        // Your code goes here
        if (root == null) {
            return new Pair<>(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        Pair<Integer, Integer> leftPair = getMinAndMax(root.left);
        Pair<Integer, Integer> rightPair = getMinAndMax(root.right);

        int min = Math.min(root.data, Math.min(leftPair.minimum, rightPair.minimum));
        int max = Math.max(root.data, Math.max(leftPair.maximum, rightPair.maximum));
        return new Pair<>(min, max);
    }

    public static int[] getMinAndMaxE(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        }

        int[] left = getMinAndMaxE(root.left);
        int[] right = getMinAndMaxE(root.right);

        int min = Math.min(root.data, Math.min(left[0], right[0]));
        int max = Math.max(root.data, Math.max(left[1], right[1]));

        return new int[] { min, max };
    }

}
