package Leet_Code_Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    int val;
    InOrderTraversal left;
    InOrderTraversal right;

    InOrderTraversal(int val) {
        this.val = val;
    }

    InOrderTraversal(int val, InOrderTraversal left, InOrderTraversal right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static List<Integer> getInOrder(InOrderTraversal root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<InOrderTraversal> stack = new Stack<>();

        InOrderTraversal current = root;


        while (current!= null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);

            current = current.right;
        }
        return result;
    }

    public static void main(String[] args) {
        InOrderTraversal node5 = new InOrderTraversal(13);
        InOrderTraversal node4 = new InOrderTraversal(15);
        InOrderTraversal node3 = new InOrderTraversal(12);
        InOrderTraversal node2 = new InOrderTraversal(20, node4, node5);
        InOrderTraversal root = new InOrderTraversal(10, node2, node3);

        List<Integer> answer = getInOrder(root);
        System.out.println(answer);
    }
}
