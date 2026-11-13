// ASSIGNMENT PROBLEM 3: Reverse the Queue (In-place Singly Linked List Reversal)
class QueueNode {
    int data;
    QueueNode next;
    public QueueNode(int data) { this.data = data; this.next = null; }
}

public class ReverseTheQueue {
    public static QueueNode reverse(QueueNode head) {
        QueueNode prev = null;
        QueueNode current = head;
        while (current != null) {
            QueueNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    public static void printList(QueueNode head) {
        QueueNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        QueueNode head = new QueueNode(1);
        head.next = new QueueNode(2);
        head.next.next = new QueueNode(3);
        head.next.next.next = new QueueNode(4);

        head = reverse(head);
        printList(head); // Expected: 4 -> 3 -> 2 -> 1 -> null
    }
}
