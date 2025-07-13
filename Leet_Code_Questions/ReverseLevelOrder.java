package Leet_Code_Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// ___________________ Question 107. Binary Tree traversal level order II ( Leetcode ) ___________________________________

public class ReverseLevelOrder {
    int val;
    ReverseLevelOrder left;
    ReverseLevelOrder right;

    ReverseLevelOrder(int val) {
        this.val = val;
    }

    ReverseLevelOrder(int val, ReverseLevelOrder left, ReverseLevelOrder right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static List<List<Integer>> levelOrderBottom(ReverseLevelOrder root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<ReverseLevelOrder> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                ReverseLevelOrder currentNode = queue.poll();
                assert currentNode != null;
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(0, currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseLevelOrder node4 = new ReverseLevelOrder(15);
        ReverseLevelOrder node5 = new ReverseLevelOrder(7);
        ReverseLevelOrder node6 = new ReverseLevelOrder(6);
        ReverseLevelOrder node2 = new ReverseLevelOrder(9);
        ReverseLevelOrder node3 = new ReverseLevelOrder(20, node4, node5);
        ReverseLevelOrder root = new ReverseLevelOrder(3, node2, node3);

        List<List<Integer>> result = levelOrderBottom(root);
        System.out.println(result);
    }
}
