package Leet_Code_Questions;

// ____________________ Question 108- Convert Sorted Array to Binary Search Tree - (Leetcode)_______________________________

public class SortedArrayToBST {
    int val;
    SortedArrayToBST left;
    SortedArrayToBST right;

    SortedArrayToBST() {
    }

    SortedArrayToBST(int val) {
        this.val = val;
    }

    static SortedArrayToBST root = new SortedArrayToBST();

    SortedArrayToBST(int val, SortedArrayToBST left, SortedArrayToBST right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    private static SortedArrayToBST populateSorted(int[] num, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = (start + end) / 2;
        SortedArrayToBST root = new SortedArrayToBST(num[mid]);
        root.left = populateSorted(num, start, mid);
        root.right = populateSorted(num, mid + 1, end);

        return root;

    }

    public static SortedArrayToBST sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        return populateSorted(nums, 0, nums.length);
    }


    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        SortedArrayToBST result = sortedArrayToBST(arr); // answer will be stored in this result value
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);

    }
}
