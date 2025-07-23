package Leet_Code_Questions;

import java.nio.file.Path;

// __________________ Question: 129- Sum Root to Leaf Numbers(Leetcode)_________________________________________
public class PathSum_II {
    int val;
    PathSum_II left;
    PathSum_II right;

    PathSum_II() {
    }

    PathSum_II(int val) {
        this.val = val;
    }

    PathSum_II(int val, PathSum_II left, PathSum_II right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static int sumNumbers(PathSum_II root) {
           return sumHelper(root , 0);
    }

    public static int sumHelper(PathSum_II node , int sum){
        if(node == null){
            return 0;
        }

        sum = sum * 10 + node.val;

        if(node.left == null && node.right == null){
            return sum;
        }

        return sumHelper(node.left , sum) + sumHelper(node.right , sum);

    }

    public static void main(String[] args) {
        PathSum_II node1 = new PathSum_II(2);
        PathSum_II node2 = new PathSum_II(3);
        PathSum_II root = new PathSum_II(1 , node1 , node2);

        System.out.println(sumNumbers(root));
    }
}
