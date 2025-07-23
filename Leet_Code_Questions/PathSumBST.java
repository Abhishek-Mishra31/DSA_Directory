package Leet_Code_Questions;

// _________________________ Question 124: find maximum path sum value of BST(Leetcode)____________________________
public class PathSumBST {
    int val;
    PathSumBST left;
    PathSumBST right;

    PathSumBST() {
    }

    PathSumBST(int val) {
        this.val = val;
    }

    PathSumBST(int val, PathSumBST left, PathSumBST right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static int ans = Integer.MIN_VALUE;

    public static int maxPathSum(PathSumBST root) {
        sumHelper(root);
        return ans;
    }

    private static int sumHelper(PathSumBST node) {
        if (node == null) {
            return 0;
        }

        int left = sumHelper(node.left);
        int right = sumHelper(node.right);

        int leftGain = Math.max(0, left);
        int rightGain = Math.max(0, right);

        int pathSum = leftGain + rightGain + node.val;
        ans = Math.max(ans, pathSum);

        return  node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        PathSumBST node1 = new PathSumBST(2);
        PathSumBST node2 = new PathSumBST(3);
        PathSumBST root = new PathSumBST(1, node1, node2);
        System.out.println(maxPathSum(root));
    }
}
