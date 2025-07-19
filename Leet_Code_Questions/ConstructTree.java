package Leet_Code_Questions;

import java.util.Arrays;
import java.util.Queue;

// ____________________________________Question 105 (Leetcode)_______________________________________________________
public class ConstructTree {
    int val;
    ConstructTree left;
    ConstructTree right;

    ConstructTree() {
    }

    ConstructTree(int val) {
        this.val = val;
    }

    ConstructTree(int val, ConstructTree left, ConstructTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static ConstructTree buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int root = preorder[0];
        int index = 0;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                index = i;
            }
        }

        ConstructTree node = new ConstructTree(root);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));

        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return node;
    }


    public static void main(String[] args) {
        ConstructTree node4 = new ConstructTree(7);
        ConstructTree node3 = new ConstructTree(15);
        ConstructTree node2 = new ConstructTree(20, node3, node4);
        ConstructTree node1 = new ConstructTree(9);
        ConstructTree root = new ConstructTree(3, node1, node2);


        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        ConstructTree result = buildTree(preorder, inorder);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);


    }
}
