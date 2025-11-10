package Topics_Practice;

import java.util.Scanner;

public class SegmentTree {

    static int[] tree;
    int n;

    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 1, 0, n - 1);
    }

    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    public static int sumQuery(int node, int start, int end, int left, int right){
        if(right < start || end < left){
            return Integer.MAX_VALUE;
        }

        if(left <= start && end <= right){
            return tree[node];
        }

        int mid = (start + end)/2;
        int leftSum = sumQuery(2 * node , start , mid , left , right);
        int rightSum = sumQuery(2 * node + 1 , mid + 1 , end , left , right);

        return leftSum + rightSum;
    }

    public static int minSumQuery(int node , int start , int end ,int left , int right){
            if(right < start || end < left){
                return 0;
            }

            if(left <= start && end <= right){
                return tree[node];
            }

            int mid = (start + end)/2;
            int leftSum = sumQuery(2 * node , start , mid , left , right);
            int rightSum = sumQuery(2 * node + 1 , mid + 1 , end , left , right);

            return Math.min(leftSum, rightSum);
    }


    public void printTree(){
        for (int i = 1; i < 2 * n; i++) {
            System.out.println(tree[i]);
        }
    }


    public static void main(String[] args) {
        System.out.println("Enter the number of elements: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array values: ");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        SegmentTree st = new SegmentTree(arr);
        st.printTree();

        System.out.println("Sum Query result is "  + sumQuery(1 , 0 , n - 1, 1 , 3 ));

        System.out.println("Minimum Sum Query result is " + minSumQuery(1 , 0 , n - 1 , 2 ,3));


    }
}
