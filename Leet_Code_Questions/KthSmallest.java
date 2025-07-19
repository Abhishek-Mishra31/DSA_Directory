package Leet_Code_Questions;

// __________________ Question 230 (Leetcode) ____________________________________________________
public class KthSmallest {
    int val;
    KthSmallest left;
    KthSmallest right;

    KthSmallest() {
    }

    KthSmallest(int val) {
        this.val = val;
    }

    static int count = 0;

    KthSmallest(int val, KthSmallest left, KthSmallest right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static int kthSmallestFind(KthSmallest root, int k) {
        return helper(root, k).val;
    }

    private static KthSmallest helper(KthSmallest node, int k) {

        if (node == null) {
            return null;
        }

        KthSmallest left = helper(node.left, k);

        if (left != null) {
            return left;
        }
        count++;

        if (count == k) {
            return node;
        }
        return helper(node.right, k);
    }

    public static void main(String[] args) {
        KthSmallest node5 = new KthSmallest(1);
        KthSmallest node4 = new KthSmallest(2, node5, null);
        KthSmallest node3 = new KthSmallest(4);
        KthSmallest node2 = new KthSmallest(3, node4, node3);
        KthSmallest node1 = new KthSmallest(6);
        KthSmallest root = new KthSmallest(5, node2, node1);
        System.out.println(kthSmallestFind(root, 3));
    }

}
