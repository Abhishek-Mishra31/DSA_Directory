package linkedList;

public class linkedlist {

    private Node head;
    private Node tail;
    private int size;

    linkedlist() {
        size = 0;
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

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void insertAtFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;

        if (size == 0) {
            tail = head;
        }

        size += 1;
    }


    public void insertAtLast(int data) {
        if (tail == null) {
            insertAtFirst(data);
        }

        Node lastNode = new Node(data);
        tail.next = lastNode;
        lastNode = tail;
        size++;
    }

    public void insertAtIndex(int index, int data) {
        Node temp = head;
        if (index == 0) {
            insertAtFirst(data);
            return;
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(data, temp.next);
        temp.next = newNode;
        size++;
    }

    public void removeFirst() {
        if (head == null) {
            tail = null;
        }
        head = head.next;
        size--;

    }

    public void removeLast() {
        Node secondLast = get(size - 2);
        secondLast.next = null;
        size--;
    }

    public void removeByIndex(int index) {
        if (index == 0) {
            removeFirst();
        }

        if (index == size - 1) {
            removeLast();
        }

        Node element = get(index - 1);
        element.next = element.next.next;
        size--;
    }


    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.print("END");
    }

    private class Node {
        private int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }


}
