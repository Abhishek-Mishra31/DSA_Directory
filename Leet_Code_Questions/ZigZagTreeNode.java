package Leet_Code_Questions;

import java.util.*;
// _____________________Question 103 - Leetcode ( Binary Tree Zigzag Level Order Traversal ) __________________________
public class ZigZagTreeNode {
    int val;
    ZigZagTreeNode left;
    ZigZagTreeNode right;

    ZigZagTreeNode(int val) {
        this.val = val;
    }

    ZigZagTreeNode(int val, ZigZagTreeNode left, ZigZagTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static List<List<Integer>> zigzagLevelOrder(ZigZagTreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<ZigZagTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean rev = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {

                if (!rev) {
                    ZigZagTreeNode currentNode = queue.pollFirst();
                    assert currentNode != null;
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.addLast(currentNode.right);
                    }

                } else {
                    ZigZagTreeNode currentNode = queue.pollLast();
                    assert currentNode != null;
                    currentLevel.add(currentNode.val);
                    if (currentNode.right != null) {
                        queue.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.addFirst(currentNode.left);
                    }
                }

            }
            rev = !rev;
            result.add(currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        ZigZagTreeNode node4 = new ZigZagTreeNode(15);
        ZigZagTreeNode node5 = new ZigZagTreeNode(7);
        ZigZagTreeNode node6 = new ZigZagTreeNode(6);
        ZigZagTreeNode node2 = new ZigZagTreeNode(9);
        ZigZagTreeNode node3 = new ZigZagTreeNode(20, node4, node5);
        ZigZagTreeNode root = new ZigZagTreeNode(3, node2, node3);

        List<List<Integer>> resultZigZag = zigzagLevelOrder(root);
        System.out.println(resultZigZag);
    }


}
