// PROBLEM 4: Delete N-th Node from Singly Linked List
public class DeleteNthNode {
    public static Node deleteNthNode(Node head, int n) {
        if (head == null) return null;
        if (n == 1) return head.next;

        Node curr = head;
        for (int i = 0; i < n - 2 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr != null && curr.next != null) {
            curr.next = curr.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        head = deleteNthNode(head, 3);
        System.out.println("3rd node deleted successfully.");
    }
}
