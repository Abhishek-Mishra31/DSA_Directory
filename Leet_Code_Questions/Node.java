package Leet_Code_Questions;

// ____________________ Question 116 - Populating next right pointers in each node ( Leetcode ) __________________________
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftmost = root;
        while (leftmost.left != null) {
            Node current = leftmost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public static void printTreeWithNext(Node root) {
        Node levelStart = root;

        while (levelStart != null) {
            Node current = levelStart;
            while (current != null) {
                String nextVal = (current.next != null) ? String.valueOf(current.next.val) : "null";
                System.out.print(current.val + "->" + nextVal + "  ");
                current = current.next;
            }
            System.out.println();
            levelStart = levelStart.left;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        Node result = connect(node1);
        printTreeWithNext(result);
    }
}
