// PROBLEM 1: Print Circular Singly Linked List
class Node {
    int data;
    Node next;
    public Node(int data) { this.data = data; }
}

public class PrintCircularSinglyLinkedList {
    public static void printCircular(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data);
            current = current.next;
            if (current != head) {
                System.out.print(" ");
            }
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = head; // Circular link
        printCircular(head); // Expected: 10 20 30
    }
}
