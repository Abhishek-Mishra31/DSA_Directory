import java.lang.management.MemoryType;

public class Maximum_Paths_Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        static int maxSum = Integer.MIN_VALUE;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static int maxPathSum(TreeNode root) {
            traverse(root);
            return maxSum;
        }

        public static int traverse(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = Math.max(0, traverse(node.left));
            int right = Math.max(0, traverse(node.right));

            int currentMax = left + right + node.val;
            maxSum = Math.max(maxSum, currentMax);

            return node.val + Math.max(left, right);

        }


        public static void main(String[] args) {

            TreeNode node1 = new TreeNode(2, null, null);
            TreeNode node2 = new TreeNode(3, null, null);
            TreeNode root = new TreeNode(1, node1, node2);
            System.out.println(maxPathSum(root));

        }
    }

}
