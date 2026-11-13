// PROBLEM 5: Split Singly Linked List into Two Halves
public class SplitListInHalf {
    public static Node splitListInHalf(Node head) {
        if (head == null || head.next == null) return null;

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null; // Terminate first half
        }
        return slow; // Head of second half
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node secondHalf = splitListInHalf(head);
        System.out.println("List split successfully.");
    }
}
