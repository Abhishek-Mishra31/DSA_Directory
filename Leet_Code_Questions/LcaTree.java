package Leet_Code_Questions;

// __________________ Question 237: Find the LCA[Least common ancestors] (Leetcode) ________________________

public class LcaTree {
    int val;
    LcaTree left;
    LcaTree right;

    LcaTree() {
    }

    LcaTree(int val) {
        this.val = val;
    }

    LcaTree(int val, LcaTree left, LcaTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static LcaTree lowestCommonAncestor(LcaTree root, LcaTree p, LcaTree q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        LcaTree left = lowestCommonAncestor(root.left, p, q);
        LcaTree right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return (left == null) ? right : left;
    }

    // Question no 235- find the same LCA node but in binary tree
    public static LcaTree lowestCommonAncestorBST(LcaTree Broot, LcaTree p, LcaTree q) {
        if (Broot == null) {
            return null;
        }

        if (Broot == p || Broot == q) {
            return Broot;
        }

        if (p.val < Broot.val && q.val < Broot.val) {
            Broot = lowestCommonAncestor(Broot.left, p, q);
        } else if (p.val > Broot.val && q.val > Broot.val) {
            Broot = lowestCommonAncestor(Broot.right, p, q);
        } else {
            return Broot;
        }
        return Broot;
    }

    public static void main(String[] args) {
        LcaTree node8 = new LcaTree(4);
        LcaTree node7 = new LcaTree(7);
        LcaTree node6 = new LcaTree(8);
        LcaTree node5 = new LcaTree(0);
        LcaTree node4 = new LcaTree(2, node7, node8);
        LcaTree node3 = new LcaTree(6);
        LcaTree node2 = new LcaTree(1, node5, node6);
        LcaTree node1 = new LcaTree(5, node3, node4);
        LcaTree root = new LcaTree(3, node1, node2);


        // Binary tree implementation for finding LCA
        LcaTree Bnode8 = new LcaTree(5);
        LcaTree Bnode7 = new LcaTree(3);
        LcaTree Bnode6 = new LcaTree(9);
        LcaTree Bnode5 = new LcaTree(7);
        LcaTree Bnode4 = new LcaTree(4, Bnode7, Bnode8);
        LcaTree Bnode3 = new LcaTree(0);
        LcaTree Bnode2 = new LcaTree(8, Bnode5, Bnode6);
        LcaTree Bnode1 = new LcaTree(2, Bnode3, Bnode4);
        LcaTree Broot = new LcaTree(6, Bnode1, Bnode2);

        LcaTree answer = lowestCommonAncestor(root, node1, node3);
        LcaTree Banswer = lowestCommonAncestorBST(Broot, Bnode1, Bnode2);

        System.out.println(answer.val);
        System.out.println(Banswer.val);


    }
}
