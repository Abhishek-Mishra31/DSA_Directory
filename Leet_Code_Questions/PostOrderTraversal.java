package Leet_Code_Questions;

import java.util.*;

//___________ Question 145 - Binary Tree Postorder Traversal (Leetcode) _________________________________
public class PostOrderTraversal {
    int val;
    PostOrderTraversal left;
    PostOrderTraversal right;

    PostOrderTraversal(int val) {
        this.val = val;
    }

    PostOrderTraversal(int val, PostOrderTraversal left, PostOrderTraversal right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static List<Integer> getPostTraversal(PostOrderTraversal root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<PostOrderTraversal> stack = new Stack<>();
        stack.add(root);


        while (!stack.isEmpty()) {
            PostOrderTraversal current = stack.pop();
            result.add(current.val);
            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        PostOrderTraversal node5 = new PostOrderTraversal(13);
        PostOrderTraversal node4 = new PostOrderTraversal(15);
        PostOrderTraversal node3 = new PostOrderTraversal(12);
        PostOrderTraversal node2 = new PostOrderTraversal(20, node4, node5);
        PostOrderTraversal root = new PostOrderTraversal(10, node2, node3);

        List<Integer> answer = getPostTraversal(root);
        System.out.println(answer);
    }
}
