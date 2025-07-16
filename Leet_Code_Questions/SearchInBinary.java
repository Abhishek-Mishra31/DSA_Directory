package Leet_Code_Questions;

//__________________Question 700: Search in a Binary Search Tree ( Leetcode )___________________________________________

public class SearchInBinary {
    int val;
    SearchInBinary left;
    SearchInBinary right;

    SearchInBinary() {
    }

    SearchInBinary(int val) {
        this.val = val;
    }

    SearchInBinary(int val, SearchInBinary left, SearchInBinary right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static SearchInBinary searchBST(SearchInBinary root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        SearchInBinary left = searchBST(root.left, val);
        SearchInBinary right = searchBST(root.right, val);

        if (left == null) {
            return right;
        }

        return left;
    }

    public static void main(String[] args) {
        SearchInBinary node5 = new SearchInBinary(3);
        SearchInBinary node4 = new SearchInBinary(1);
        SearchInBinary node3 = new SearchInBinary(7);
        SearchInBinary node2 = new SearchInBinary(2, node4, node5);
        SearchInBinary root = new SearchInBinary(4, node2, node3);
        SearchInBinary answer = searchBST(root, 2);
        System.out.println(answer.left.val);
        System.out.println(answer.right.val);

    }
}
