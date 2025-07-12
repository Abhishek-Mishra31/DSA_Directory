package Leet_Code_Questions;
// _________________Problem-102 (Leetcode )_______________________________________
// _________________Problem-637 ( Leetcode ) _____________________________________

// we have to traverse level by level and return the result into level form like

// Build the binary tree manually:
//         1
//        / \
//       2   3
//      / \   \
//     4   5   6

// for this tree we have to implement given method leverOrder() that will return
// [[1] , [2,3] , [4,5,6]]

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                assert currentNode != null;
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    // for the calculating the average of each level elements we modified this function , in this function we don't need to create a list for currentLevel , we only calculate the output of the all levels ,
    public static List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double averageLevel = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                assert currentNode != null;
                averageLevel += currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            averageLevel = averageLevel / levelSize;
            result.add(averageLevel);
        }
        return result;
    }


    // question is that find the successor ( element which is just right to the given targeted element )
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode currentNode = queue.poll();
            assert currentNode != null;

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }


    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20, node4, node5);
        TreeNode root = new TreeNode(3, node2, node3);

        List<List<Integer>> answer = levelOrder(root);
        System.out.println(answer);

        List<Double> avgAnswer = averageOfLevels(root);
        System.out.println(avgAnswer);

        TreeNode successor = findSuccessor(root, 9);
        System.out.println(successor.val);

    }
}
