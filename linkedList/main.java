package linkedList;

public class main {
    public static void main(String[] args) {
        System.out.println("hello linkedList");
//        linkedlist ll = new linkedlist();
//        ll.insertAtFirst(8);
//        ll.insertAtFirst(18);
//        ll.insertAtFirst(20);
//        ll.displayList();
//        ll.insertAtLast(72);
//        ll.displayList();
//        ll.insertAtIndex(2, 17);
//        ll.displayList();
//        System.out.println();
//        ll.displayList();
//        ll.removeLast();
//        ll.displayList();
//        System.out.println();
//        ll.removeByIndex(2);
//        ll.displayList();


        DoublyLinkedList dl = new DoublyLinkedList();
//        dl.insertFirst(10);
//        dl.insertFirst(20);
//        dl.insertFirst(30);
//        dl.displayList();
//        System.out.println();
//        dl.insertLast(40);
//        dl.displayList();
//        System.out.println();
//        dl.insertAfter(20, 60);
//        System.out.println();
//        dl.displayList();

        CircularLinkedList cl = new CircularLinkedList();
        cl.insertFirst(2);
        cl.insertFirst(4);
        cl.insertFirst(8);
        cl.insertFirst(10);
        cl.displayList();
        System.out.println();
        cl.delete(10);
        cl.displayList();

    }
}
