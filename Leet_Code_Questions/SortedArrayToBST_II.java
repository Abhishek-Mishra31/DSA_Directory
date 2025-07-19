package Leet_Code_Questions;

// ______________________ Question 109 ( Leetcode )___________________________________________________________
public class SortedArrayToBST_II {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        private static ListNode currentHead;

        public TreeNode() {

        }

        private static TreeNode populateSorted(int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = start + (end - start) / 2;
            TreeNode leftChild = populateSorted(start, mid - 1);

            TreeNode root = new TreeNode(currentHead.val);
            root.left = leftChild;


            currentHead = currentHead.next;
            root.right = populateSorted(mid + 1, end);

            return root;

        }

        public TreeNode sortedListToBST_II(ListNode head) {
            if (head == null) {
                return null;
            }

            currentHead = head;

            int size = 0;
            ListNode p = head;
            while (p != null) {
                size++;
                p = p.next;
            }

            return populateSorted(0, size - 1);
        }

    }

    public static void printTreeInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printTreeInOrder(node.left);
        System.out.print(node.val + " ");
        printTreeInOrder(node.right);
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("This is question number 109 from leetcode");
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        System.out.println("Original Sorted Linked List:");
        printList(head);

        TreeNode sol = new TreeNode();

        TreeNode root = sol.sortedListToBST_II(head);

        System.out.println("\nIn-order traversal of the resulting BST:");
        printTreeInOrder(root);
        System.out.println();

    }
}
