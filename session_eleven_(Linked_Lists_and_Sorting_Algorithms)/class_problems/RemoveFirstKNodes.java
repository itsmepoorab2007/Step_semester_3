// PROBLEM 3: Remove First K Nodes from Singly Linked List
public class RemoveFirstKNodes {
    public static Node removeFirstKNodes(Node head, int k) {
        if (head == null || k <= 0) return head;
        Node curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) break;
            curr = curr.next;
        }
        return curr;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node newHead = removeFirstKNodes(head, 2);
        // Expected starts at 3
        System.out.println("New head data: " + (newHead != null ? newHead.data : "null"));
    }
}
