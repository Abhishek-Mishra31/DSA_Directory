package Leet_Code_Questions;

import java.util.LinkedList;
import java.util.Queue;

// ___________Question 101- Symmetric tree i.e we have to tell is tree is mirror form or not (Leetcode)____________
public class SymmetricTree {
    int val;
    SymmetricTree left;
    SymmetricTree right;

    SymmetricTree(int val) {
        this.val = val;
    }

    SymmetricTree(int val, SymmetricTree left, SymmetricTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static boolean isSymmetric(SymmetricTree root) {
        if (root == null) {
            return false;
        }

        Queue<SymmetricTree> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            SymmetricTree left = queue.poll();
            SymmetricTree right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }
        return true;
    }

    public static void main(String[] args) {
        SymmetricTree node7 = new SymmetricTree(3);
        SymmetricTree node5 = new SymmetricTree(3);
        SymmetricTree node3 = new SymmetricTree(2, null, node7);
        SymmetricTree node2 = new SymmetricTree(2, null, node5);
        SymmetricTree root = new SymmetricTree(1, node2, node3);

        System.out.println(isSymmetric(root));


    }
}
