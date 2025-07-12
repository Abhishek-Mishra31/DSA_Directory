package Domain_Camp_Questions.DS_QUESTIONS;

public class Day_1_DoublyLinkedList {

        static class Node {
            char data;
            Node prev;
            Node next;

            public Node(char data) {
                this.data = data;
                this.prev = null;
                this.next = null;
            }
        }

        private Node head;
        private Node tail;

        public Day_1_DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void add(char data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        public boolean isPalindrome() {
            if (head == null || head.next == null) {
                return true;
            }

            Node left = head;
            Node right = tail;

            while (left != right && left.prev != right) {
                if (left.data != right.data) {
                    return false;
                }
                left = left.next;
                right = right.prev;
            }
            return true;
        }

        // Main method for testing
        public static void main(String[] args) {
            Day_1_DoublyLinkedList list1 = new Day_1_DoublyLinkedList();
            list1.add('R');
            list1.add('A');
            list1.add('C');
            list1.add('E');
            list1.add('C');
            list1.add('A');
            list1.add('R');
            System.out.println("List 1 (RACE CAR) is a palindrome: " + list1.isPalindrome());

            Day_1_DoublyLinkedList list2 = new Day_1_DoublyLinkedList();
            list2.add('H');
            list2.add('E');
            list2.add('L');
            list2.add('L');
            list2.add('O');
            System.out.println("List 2 (HELLO) is a palindrome: " + list2.isPalindrome());

            Day_1_DoublyLinkedList list3 = new Day_1_DoublyLinkedList();
            list3.add('1');
            list3.add('2');
            list3.add('3');
            list3.add('2');
            list3.add('1');
            System.out.println("List 3 (12321) is a palindrome: " + list3.isPalindrome());
            
            Day_1_DoublyLinkedList list4 = new Day_1_DoublyLinkedList();
            list4.add('1');
            list4.add('2');
            list4.add('3');
            list4.add('4');
            System.out.println("List 4 (1234) is a palindrome: " + list4.isPalindrome());

            Day_1_DoublyLinkedList list5 = new Day_1_DoublyLinkedList();
            list5.add('A');
            System.out.println("List 5 (A) is a palindrome: " + list5.isPalindrome());

            Day_1_DoublyLinkedList list6 = new Day_1_DoublyLinkedList();
            System.out.println("List 6 (empty) is a palindrome: " + list6.isPalindrome());
        }
}
