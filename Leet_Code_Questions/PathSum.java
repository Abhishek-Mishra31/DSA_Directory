package Leet_Code_Questions;
// ________________ Question 105- Has Path Sum (Leetcode)___________________

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    int val;
    PathSum left;
    PathSum right;

    PathSum() {
    }

    PathSum(int val) {
        this.val = val;
    }

    PathSum(int val, PathSum left, PathSum right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static boolean hasPathSum(PathSum root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }

        boolean leftTree = hasPathSum(root.left, targetSum - root.val);

        boolean rightTree = hasPathSum(root.right, targetSum - root.val);

        return leftTree || rightTree;
    }

    // helper method to solve question no 113 ( next Question )
    private static void PathFind(PathSum node, int remainingSum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null) {
            return;
        }
        currentPath.add(node.val);

        if (node.left == null && node.right == null && remainingSum == node.val) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {

            PathFind(node.left, remainingSum - node.val, currentPath, allPaths);
            PathFind(node.right, remainingSum - node.val, currentPath, allPaths);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    // _______________________Question 113 - Path Sum Find ( Leetcode )_______________________________________________
    public static List<List<Integer>> pathSumFind(PathSum root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        PathFind(root, targetSum, new ArrayList<Integer>(), result);
        return result;
    }


    public static void main(String[] args) {
        PathSum node8 = new PathSum(1);
        PathSum node7 = new PathSum(2);
        PathSum node6 = new PathSum(7);
        PathSum node5 = new PathSum(4, null, node8);
        PathSum node4 = new PathSum(13);
        PathSum node3 = new PathSum(11, node6, node7);
        PathSum node2 = new PathSum(8, node4, node5);
        PathSum node1 = new PathSum(4, node3, null);
        PathSum root = new PathSum(5, node1, node2);

        PathSum node10 = new PathSum(2);
        PathSum node11 = new PathSum(3);
        PathSum root2 = new PathSum(1, node10, node11);

        System.out.println(hasPathSum(root, 22));
        System.out.println(hasPathSum(root2, 5));

        List<List<Integer>> answer = pathSumFind(root, 22);
        System.out.println(answer);


    }
}
