import java.util.HashSet;
import java.util.Set;

class CustomLL1 {
    Node head; // Head of the linked list

    class Node {
        int data;
        Node next;

        public Node(int data1) {
            this.data = data1;
            this.next = null;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    // 🔥 Using Set instead of Map
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        Set<Node> visited = new HashSet<>();

        while (currNode != null) {

            if (visited.contains(currNode)) {
                System.out.println("Loop detected. Stopping printing.");
                break;
            }

            System.out.print(currNode.data + " -> ");
            visited.add(currNode);
            currNode = currNode.next;
        }

        System.out.println("null");
    }

    // 🔥 Using Set instead of Map
    public boolean detectLoop() { // T: O(N) | S: O(N)

        Node temp = head;
        Set<Node> visited = new HashSet<>();

        while (temp != null) {

            if (visited.contains(temp)) {
                return true;
            }

            visited.add(temp);
            temp = temp.next;
        }

        return false;
    }

    // 🔥 START NODE using Set (your required)
    public Node startNodeOfCycle() { // T: O(N) | S: O(N)

        Node temp = head;
        Set<Node> set = new HashSet<>();

        while (temp != null) {

            if (set.contains(temp)) {
                return temp;
            }

            set.add(temp);
            temp = temp.next;
        }

        return null;
    }
}

// Main class
public class Bruteforce {
    public static void main(String[] args) {

        CustomLL1 list = new CustomLL1();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Create loop at node 2
        CustomLL1.Node temp = list.head;
        CustomLL1.Node loopNode = null;
        int position = 2;

        while (temp != null) {
            position--;
            if (position == 0) {
                loopNode = temp;
            }
            temp = temp.next;
        }

        if (loopNode != null) {
            temp = list.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = loopNode;
        }

        System.out.println("List (with loop):");
        list.printList();

        boolean hasLoop = list.detectLoop();
        System.out.println("Does the list have a loop? " + (hasLoop ? "Yes" : "No"));

        CustomLL1.Node cycleStartNode = list.startNodeOfCycle();

        if (cycleStartNode != null) {
            System.out.println("Cycle starts at node with data: " + cycleStartNode.data);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}