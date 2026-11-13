// ASSIGNMENT PROBLEM 1: Priority Token Insertion (Singly Linked List)
class Node {
    int data;
    Node next;
    public Node(int data) { this.data = data; this.next = null; }
}

class SinglyLinkedList {
    Node head;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void insertAt(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node curr = head;
        for (int i = 0; i < index - 1 && curr != null; i++) {
            curr = curr.next;
        }
        if (curr != null) {
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}

public class PriorityTokenInsertion {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(101);
        list.addLast(102);
        list.addLast(103);
        
        list.addFirst(100);
        list.addLast(104);
        list.insertAt(2, 150);
        
        list.printList(); // Expected: 100 -> 101 -> 150 -> 102 -> 103 -> 104 -> null
    }
}
