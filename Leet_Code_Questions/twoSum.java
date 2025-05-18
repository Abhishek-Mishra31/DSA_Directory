package Leet_Code_Questions;

public class twoSum {

    public static class ListNode {
        int val;
        private ListNode head;
        private ListNode tail;
        ListNode next;
        private int size;

        ListNode() {
            size = 0;
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void insertAtFirst(int data) {
            ListNode node = new ListNode(data);
            node.next = head;
            head = node;

            if (size == 0) {
                tail = head;
            }

            size += 1;
        }

        public void displayList() {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val);
                current = current.next;
            }
            System.out.println();
        }

    }

    public static ListNode Sum(ListNode n1, ListNode n2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (n1 != null || n2 != null || carry != 0) {
            int x = (n1 != null) ? n1.val : 0;
            int y = (n2 != null) ? n2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.insertAtFirst(2);
        l1.insertAtFirst(4);
        l1.insertAtFirst(3);
        l1.displayList();

        ListNode l2 = new ListNode();
        l2.insertAtFirst(5);
        l2.insertAtFirst(6);
        l2.insertAtFirst(4);
        l2.displayList();

        ListNode result = Sum(l1.head , l2.head);
        ListNode temp = result;
        while(temp != null){
            System.out.print(temp.val);
            temp = temp.next;
        }
        System.out.println();
    }
}
