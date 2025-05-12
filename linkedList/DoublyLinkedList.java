package linkedList;

public class DoublyLinkedList {
    private Node head;
    private int size;
    private Node tail;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public Node find(int value) {
        Node iterator = head;
        while (iterator != null) {
            if (iterator.value == value) {
                return iterator;
            }
            iterator = iterator.next;
        }
        return null;
    }

    public void insertFirst(int data) {
        Node newElement = new Node(data);
        if (head != null) {
            head.prev = newElement;
        }
        newElement.prev = null;
        newElement.next = head;
        head = newElement;
        size++;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        Node temp = head;

        newNode.next = null;
        while (temp.next != null) {
            temp = temp.next;
        }

        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        newNode.prev = temp;
        temp.next = newNode;
        size++;
    }

    public void insertAfter(int value, int data) {
        Node place = find(value);

        if (place == null) {
            System.out.println("doesn't exist");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = place.next;
        place.next = newNode;
        newNode.prev = place;

        if (newNode.next != null) {
            newNode.next.prev = newNode;
        } else {
            tail = newNode;
        }
        size++;
    }

    public void displayList() {


        Node current = head;
        Node last = null;
        while (current != null) {
            System.out.print(current.value + " -> ");
            last = current;
            current = current.next;
        }
        System.out.print("END");
        System.out.println();
        System.out.println("printing in reverse");
        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.print("START");
    }


    private static class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }


        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }


    }
}
