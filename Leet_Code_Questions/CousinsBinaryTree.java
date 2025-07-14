package Leet_Code_Questions;

// ____________________________Question 993 - Cousins in binary tree ( Leetcode )____________________________________________
public class CousinsBinaryTree {
    int val;
    CousinsBinaryTree left;
    CousinsBinaryTree right;

    CousinsBinaryTree(int val) {
        this.val = val;
    }

    CousinsBinaryTree(int val, CousinsBinaryTree left, CousinsBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static boolean isCousins(CousinsBinaryTree root, int x, int y) {
        if (root == null) {
            return false;
        }

        CousinsBinaryTree xx = findNode(root, x);
        CousinsBinaryTree xy = findNode(root, y);

        return (
                (findLevel(root, xx, 0) == findLevel(root, xy, 0)) && (!isSiblings(root, xx, xy))
        );

    }

    public static CousinsBinaryTree findNode(CousinsBinaryTree node, int x) {
        if (node == null) {
            return null;
        }

        if (node.val == x) {
            return node;
        }

        CousinsBinaryTree n = findNode(node.left, x);
        if (n != null) {
            return n;
        }

        return findNode(node.right, x);
    }

    public static int findLevel(CousinsBinaryTree node, CousinsBinaryTree x, int level) {
        if (node == null) {
            return 0;
        }

        if (node == x) {
            return level;
        }

        int l = findLevel(node.left, x, level + 1);
        if (l != 0) {
            return l;
        }

        return findLevel(node.right, x, level + 1);
    }

    public static boolean isSiblings(CousinsBinaryTree node, CousinsBinaryTree x, CousinsBinaryTree y) {
        if (node == null) {
            return false;
        }

        return ((node.left == x && node.right == y) || (node.left == y && node.right == x) ||
                isSiblings(node.left, x, y) || isSiblings(node.right, x, y)

        );
    }

    public static void main(String[] args) {

        CousinsBinaryTree node4 = new CousinsBinaryTree(4);
        CousinsBinaryTree node2 = new CousinsBinaryTree(2, node4, null);
        CousinsBinaryTree node3 = new CousinsBinaryTree(3);
        CousinsBinaryTree root = new CousinsBinaryTree(1, node2, node3);


        System.out.println(isCousins(root, 2, 3));



    }
}
