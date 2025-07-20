package Leet_Code_Questions;

// _____________________________ Question 110 - IsBalanced Tree ( leetcode ) ________________________________________
public class isBalancedTree {
    int val;
    isBalancedTree left;
    isBalancedTree right;

    isBalancedTree() {
    }

    isBalancedTree(int val) {
        this.val = val;
    }

    isBalancedTree(int val, isBalancedTree left, isBalancedTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    private static int findHeight(isBalancedTree node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);
        if((leftHeight == -1) && (rightHeight == -1)){
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        return Math.max(leftHeight , rightHeight) + 1;
    }


    public static boolean isBalanced(isBalancedTree root) {
        return findHeight(root) != -1;
    }


    public static void main(String[] args) {
        isBalancedTree node4 = new isBalancedTree(7);
        isBalancedTree node3 = new isBalancedTree(15);
        isBalancedTree node2 = new isBalancedTree(20, node3, node4);
        isBalancedTree node1 = new isBalancedTree(9);
        isBalancedTree root = new isBalancedTree(3, node1, node2);


        isBalancedTree node9 = new isBalancedTree(4);
        isBalancedTree node10 = new isBalancedTree(4);
        isBalancedTree node6 = new isBalancedTree(2);
        isBalancedTree node7 = new isBalancedTree(3, node9, node10);
        isBalancedTree node8 = new isBalancedTree(3);
        isBalancedTree node5 = new isBalancedTree(2, node7, node8);

        isBalancedTree root_2 = new isBalancedTree(1, node5, node6);


        System.out.println(isBalanced(root));
        System.out.println(isBalanced(root_2));

    }
}
