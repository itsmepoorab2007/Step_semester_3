// ASSIGNMENT PROBLEM 5: Round-Robin Game Turns (Circular Singly Linked List)
class PlayerNode {
    String name;
    PlayerNode next;
    public PlayerNode(String name) { this.name = name; }
}

class CircularLinkedList {
    PlayerNode tail;

    public void addLast(String name) {
        PlayerNode newNode = new PlayerNode(name);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void printTurns(int turns) {
        if (tail == null || turns <= 0) return;
        PlayerNode curr = tail.next; // Head is tail.next
        for (int i = 0; i < turns; i++) {
            System.out.print(curr.name + (i == turns - 1 ? "" : " "));
            curr = curr.next;
        }
        System.out.println();
    }
}

public class RoundRobinGameTurns {
    public static void main(String[] args) {
        CircularLinkedList game = new CircularLinkedList();
        game.addLast("Asha");
        game.addLast("Ravi");
        game.addLast("Neha");
        game.printTurns(7); // Expected: Asha Ravi Neha Asha Ravi Neha Asha
    }
}
