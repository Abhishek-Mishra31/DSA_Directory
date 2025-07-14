package Leet_Code_Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//___________ Question 144 - Binary Tree Inorder Traversal (Leetcode) _________________________________
public class PreOrderTraversal {
    int val;
    PreOrderTraversal left;
    PreOrderTraversal right;

    PreOrderTraversal(int val) {
        this.val = val;
    }

    PreOrderTraversal(int val, PreOrderTraversal left, PreOrderTraversal right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static List<Integer> getTraversal(PreOrderTraversal root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<PreOrderTraversal> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            PreOrderTraversal current = stack.pop();
            result.add(current.val);

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        PreOrderTraversal node5 = new PreOrderTraversal(13);
        PreOrderTraversal node4 = new PreOrderTraversal(15);
        PreOrderTraversal node3 = new PreOrderTraversal(12);
        PreOrderTraversal node2 = new PreOrderTraversal(20, node4, node5);
        PreOrderTraversal root = new PreOrderTraversal(10, node2, node3);

        List<Integer> answer = getTraversal(root);
        System.out.println(answer);


    }
}
