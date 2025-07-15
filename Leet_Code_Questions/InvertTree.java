package Leet_Code_Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// _____________________ Question 226 - Invert the given binary tree ( Leetcode )______________________________________

public class InvertTree {
    int val;
    InvertTree left;
    InvertTree right;

    InvertTree() {
    }

    InvertTree(int val) {
        this.val = val;
    }

    InvertTree(int val, InvertTree left, InvertTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static InvertTree getInvertTree(InvertTree root) {
        if (root == null) {
            return null;
        }

        InvertTree left = getInvertTree(root.left);
        InvertTree right = getInvertTree(root.right);

        root.left = right;
        root.right = left;

        printSubtreeValues(root);

        return root;
    }

    public static void printSubtreeValues(InvertTree root) {
        if (root == null) return;

        Queue<InvertTree> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> values = new ArrayList<>();

        while (!queue.isEmpty()) {
            InvertTree node = queue.poll();
            values.add(node.val);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        for (int val : values) {
            System.out.print(val + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        InvertTree node7 = new InvertTree(9);
        InvertTree node6 = new InvertTree(6);
        InvertTree node5 = new InvertTree(3);
        InvertTree node4 = new InvertTree(1);
        InvertTree node3 = new InvertTree(7, node6, node7);
        InvertTree node2 = new InvertTree(2, node4, node5);
        InvertTree root = new InvertTree(4, node2, node3);
        getInvertTree(root);

    }
}
