package linkedlist;

/**
 * A Simple Linked List
 */

public class SimpleLinkedList {

    Node head;
    Node current;

    public SimpleLinkedList() {
        Node head = new Node("Head");
        this.head = head;
        this.current = head;
    }

    public Node getHead() {
        return head;
    }

    public Node getCurrent() {
        return current;
    }

    public void addNode(String value) {
        Node node = new Node(value);
        current.next = node;
        current = node;
    }


    public void reverseSimpleLinedList1() {
        Node current = this.head.next;
        Node preNode = null;
        Node nextNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = preNode;
            preNode = current;
            current = nextNode;
        }
        this.head.next = preNode;
    }

    public Node reverseSimpleLinedList2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;
        Node newHead = reverseSimpleLinedList2(temp);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public void printSimpleLinkedList() {
        Node current = this.head.next;
        while (current != null) {
            System.out.print(current.value);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SimpleLinkedList sll = new SimpleLinkedList();
        sll.addNode("A");
        sll.addNode("B");
        sll.addNode("C");
        sll.addNode("D");
        sll.printSimpleLinkedList();
        sll.head.next = sll.reverseSimpleLinedList2(sll.head.next);
        sll.printSimpleLinkedList();
    }

}
