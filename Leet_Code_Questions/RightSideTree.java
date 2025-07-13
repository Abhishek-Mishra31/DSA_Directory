package Leet_Code_Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideTree {
    int val;
    RightSideTree left;
    RightSideTree right;

    RightSideTree(int val) {
        this.val = val;
    }

    RightSideTree(int val, RightSideTree left, RightSideTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static List<Integer> rightSideView(RightSideTree root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<RightSideTree> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                RightSideTree currentNode = queue.poll();
                assert currentNode != null;

                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RightSideTree node4 = new RightSideTree(15);
        RightSideTree node5 = new RightSideTree(7);
        RightSideTree node2 = new RightSideTree(9);
        RightSideTree node3 = new RightSideTree(20, node4, node5);
        RightSideTree root = new RightSideTree(3, node2, node3);

        List<Integer> answer = rightSideView(root);
        System.out.println(answer);
    }
}
