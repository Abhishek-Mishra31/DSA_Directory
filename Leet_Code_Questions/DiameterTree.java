package Leet_Code_Questions;
// _____________________ Question 543 - Diameter of Binary Tree ( Leetcode )______________________________________
public class DiameterTree {
    int val;
    DiameterTree left;
    DiameterTree right;

    DiameterTree() {
    }

    DiameterTree(int val) {
        this.val = val;
    }

    DiameterTree(int val, DiameterTree left, DiameterTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static int diameter = 0;

    public static int diameterOfBinaryTree(DiameterTree root) {
        diameter = 0;

        findHeight(root);
        return diameter - 1;
    }

    public static int findHeight(DiameterTree node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        DiameterTree node5 = new DiameterTree(5);
        DiameterTree node4 = new DiameterTree(4);
        DiameterTree node3 = new DiameterTree(3);
        DiameterTree node2 = new DiameterTree(2, node4, node5);
        DiameterTree root = new DiameterTree(1, node2, node3);

        DiameterTree node_2 = new DiameterTree(2);
        DiameterTree root_2 = new DiameterTree(1, node_2, null);

        int answer = diameterOfBinaryTree(root);
        System.out.println(answer);
        System.out.println(diameterOfBinaryTree(root_2));
    }

}
