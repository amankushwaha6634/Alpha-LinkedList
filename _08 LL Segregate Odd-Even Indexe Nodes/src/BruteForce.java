import java.util.ArrayList;
import java.util.List;

class CustomLinkedList {
    Node head; // Head of the linked list

    // Definition of a Node in the linked list
    class Node {
        int data;      // Data stored in the node
        Node next;     // Pointer to the next node

        public Node(int data1) {
            this.data = data1;
            this.next = null;
        }
    }

    /*
        Using only one extra array:

        Idea:
        - First store all odd-indexed elements
        - Then store all even-indexed elements
        - Finally rewrite linked list using that array

        Example:
            Original:
            0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 50

            Odd indices (1,3,5):
            1, 3, 5

            Even indices (0,2,4,6):
            0, 2, 4, 50

            Single array:
            [1, 3, 5, 0, 2, 4, 50]

            Final List:
            1 -> 3 -> 5 -> 0 -> 2 -> 4 -> 50
    */
    public void segregateOddEvenIndices() {

        // If list has 0 or 1 node, no need to change
        if (head == null || head.next == null) {
            return;
        }

        // Single extra array
        List<Integer> arr = new ArrayList<>();

        Node current = head;
        int index = 0;

        // Step 1: Store odd-indexed elements first
        while (current != null) {
            if (index % 2 == 1) {
                arr.add(current.data);
            }

            current = current.next;
            index++;
        }

        // Step 2: Again traverse and store even-indexed elements
        current = head;
        index = 0;

        while (current != null) {
            if (index % 2 == 0) {
                arr.add(current.data);
            }

            current = current.next;
            index++;
        }

        // Step 3: Rewrite linked list from array
        current = head;
        int i = 0;

        while (current != null) {
            current.data = arr.get(i);
            current = current.next;
            i++;
        }
    }

    // Method to add a node at the end of the list
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

    // Method to print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }
}

public class BruteForce {
    public static void main(String[] args) {
        // Create a linked list
        CustomLinkedList list = new CustomLinkedList();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(50);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Segregate odd and even indexed nodes
        list.segregateOddEvenIndices();

        // Print the modified list
        System.out.println("After Segregating Odd and Even Indexed Nodes: ( indexes only )");
        list.printList();
    }
}
