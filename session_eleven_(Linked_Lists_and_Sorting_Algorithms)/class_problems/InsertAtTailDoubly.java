// PROBLEM 2: Insert at Tail of Doubly Linked List
class DNode {
    int data;
    DNode prev, next;
    public DNode(int data) { this.data = data; }
}

public class InsertAtTailDoubly {
    public static DNode insertAtTailDoubly(DNode head, int value) {
        DNode newNode = new DNode(value);
        if (head == null) {
            return newNode;
        }
        DNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
        return head;
    }

    public static void main(String[] args) {
        DNode head = new DNode(1);
        head.next = new DNode(2);
        head.next.prev = head;
        head.next.next = new DNode(3);
        head.next.next.prev = head.next;

        head = insertAtTailDoubly(head, 4);
        System.out.println("Inserted successfully at tail.");
    }
}
