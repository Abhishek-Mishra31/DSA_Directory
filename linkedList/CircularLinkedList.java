package linkedList;

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size;


    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }


    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
        size++;
    }

    public void delete(int val) {
        Node current = head;
        if (current == null) {
            return;
        }

        if(head == tail){
            head = null;
            tail = null;
            return;
        }

        if (current.value == val) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node n = current.next;
            if (n.value == val) {
                current.next = n.next;
                break;
            }
            current = current.next;
        } while (current != head);
    }


    public void displayList() {
        Node current = head;
        if (current != null) {
            do {
                assert current != null;
                System.out.print(current.value + "-> ");
                if (current.next != null) {
                    current = current.next;
                }

            } while (current != head);
        }
        System.out.print("Head");
    }


    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
