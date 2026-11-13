// ASSIGNMENT PROBLEM 4: Train Coaches Both Ways (Doubly Linked List)
class CoachNode {
    String name;
    CoachNode prev, next;
    public CoachNode(String name) { this.name = name; }
}

class DoublyLinkedListTrain {
    CoachNode head, tail;

    public void addLast(String name) {
        CoachNode newNode = new CoachNode(name);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void remove(String name) {
        CoachNode curr = head;
        while (curr != null) {
            if (curr.name.equals(name)) {
                if (curr == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (curr == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                return;
            }
            curr = curr.next;
        }
    }

    public void printForward() {
        System.out.print("Forward: ");
        CoachNode curr = head;
        while (curr != null) {
            System.out.print(curr.name);
            if (curr.next != null) System.out.print(" <-> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void printBackward() {
        System.out.print("Backward: ");
        CoachNode curr = tail;
        while (curr != null) {
            System.out.print(curr.name);
            if (curr.prev != null) System.out.print(" <-> ");
            curr = curr.prev;
        }
        System.out.println();
    }
}

public class TrainCoachesBothWays {
    public static void main(String[] args) {
        DoublyLinkedListTrain train = new DoublyLinkedListTrain();
        train.addLast("Engine");
        train.addLast("A1");
        train.addLast("B1");
        train.addLast("B2");
        train.addLast("Guard");

        train.remove("B1");
        train.printForward();
        train.printBackward();
    }
}
