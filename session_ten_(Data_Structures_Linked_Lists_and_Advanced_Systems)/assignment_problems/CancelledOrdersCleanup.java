// ASSIGNMENT PROBLEM 2: Cancelled Orders Cleanup
class OrderNode {
    int data;
    OrderNode next;
    public OrderNode(int data) { this.data = data; this.next = null; }
}

public class CancelledOrdersCleanup {
    public static OrderNode removeAll(OrderNode head, int code) {
        while (head != null && head.data == code) {
            head = head.next;
        }
        OrderNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.data == code) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void printList(OrderNode head) {
        OrderNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample 1: 5 -> 3 -> 5 -> 8 -> 5, code = 5
        OrderNode head = new OrderNode(5);
        head.next = new OrderNode(3);
        head.next.next = new OrderNode(5);
        head.next.next.next = new OrderNode(8);
        head.next.next.next.next = new OrderNode(5);

        head = removeAll(head, 5);
        printList(head); // Expected: 3 -> 8 -> null
    }
}
