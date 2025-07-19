package Leet_Code_Questions;

// ___________________ Question 98 - Validate the binary tree (Leetcode)_____________________________________________
public class ValidBinaryTree {
    int val;
    ValidBinaryTree left;
    ValidBinaryTree right;

    ValidBinaryTree() {
    }

    ValidBinaryTree(int val) {
        this.val = val;
    }

    ValidBinaryTree(int val, ValidBinaryTree left, ValidBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static boolean isValidBST(ValidBinaryTree root) {
        return helper(root, null, null);
    }

    private static boolean helper(ValidBinaryTree node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }

        if (low != null && node.val <= low) {
            return false;
        }

        if (high != null && node.val >= high) {
            return false;
        }

        Boolean leftTree = helper(node.left, low, node.val);
        Boolean rightTree = helper(node.right, node.val, high);

        return leftTree && rightTree;
    }

    public static void main(String[] args) {
        ValidBinaryTree node4 = new ValidBinaryTree(6);
        ValidBinaryTree node3 = new ValidBinaryTree(3);
        ValidBinaryTree node2 = new ValidBinaryTree(4, node3, node4);
        ValidBinaryTree node1 = new ValidBinaryTree(1);
        ValidBinaryTree root = new ValidBinaryTree(5, node1, node2);


        ValidBinaryTree node5 = new ValidBinaryTree(3);
        ValidBinaryTree node6 = new ValidBinaryTree(1);
        ValidBinaryTree root2 = new ValidBinaryTree(2, node6, node5);


        System.out.println(isValidBST(root));
        System.out.println(isValidBST(root2));

    }
}
