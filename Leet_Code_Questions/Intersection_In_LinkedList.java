package Leet_Code_Questions;

public class Intersection_In_LinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode A = headA;
        ListNode B = headB;

        while (A != B) {
            A = (A == null) ? headA : A.next;
            B = (B == null) ? headB : B.next;
        }

        return A;
    }

    public static void main(String[] args) {
        ListNode obj = new ListNode(1);

    }

}
