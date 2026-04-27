import java.util.ArrayList;
import java.util.List;
class CustomDoublyLinkedList2 {
    Node head; // Head of the doubly linked list

    // Definition of a Node in the doubly linked list
    class Node {
        int data; // Data stored in the node
        Node next; // Reference to the next node
        Node prev; // Reference to the previous node

        // Constructor to create a new node with the given data
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Method to add a new node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        if (head == null) {
            head = newNode; // If the list is empty, the new node becomes the head
            return;
        }
        Node currNode = head; // Start from the head
        // Traverse to the last node of the list
        while (currNode.next != null) {
            currNode = currNode.next; // Move to the next node
        }
        currNode.next = newNode; // Link the last node to the new node
        newNode.prev = currNode; // Set the previous pointer of the new node to the last node
    }

    // Method to print the doubly linked list from head to tail
    public void printList() {
        if (head == null) {
            System.out.println("List is empty"); // Print if the list is empty
            return;
        }
        Node currNode = head; // Start from the head
        // Traverse and print each node's data
        while (currNode != null) {
            System.out.print(currNode.data + " <-> "); // Print data of current node
            currNode = currNode.next; // Move to the next node
        }
        System.out.println("null"); // End of the list
    }

    // Optimized method using the two-pointer technique to find pairs with the given sum
    public List<List<Integer>> findAllPairsWithSum(int targetSum) { // T: O(N) | S: O(K)

        List<List<Integer>> ds = new ArrayList<>();

        if (head == null) return ds;

        Node left = head;
        Node right = head;

        // find tail
        while (right.next != null) {
            right = right.next;
        }

        // Safer version (recommended in interviews)
        // while (left != null && right != null && left != right && left.prev != right)
        while (left.data < right.data) {

            int sum = left.data + right.data;

            if (sum == targetSum) {

                List<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);

                ds.add(pair);

                left = left.next;
                right = right.prev;
            }
            else if (sum < targetSum) {
                left = left.next;
            }
            else {
                right = right.prev;
            }
        }

        return ds;
    }
}

public class Optimal_TwoPointerApproach {
    public static void main(String[] args) {
        CustomDoublyLinkedList2 list = new CustomDoublyLinkedList2();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(5);
        list.addLast(7);
        list.addLast(8);

        System.out.println("Original List:");
        list.printList(); // Print the list before searching for pairs

        System.out.println("\nPairs with sum 10:");
        list.findAllPairsWithSum(10);  // Looking for pairs that sum to 10
    }
}

/**
 * 🎯 Find Pairs with Given Sum (Optimal DLL + DS)
 *
 * 🔹 Core Idea:
 * - Use two pointers:
 *      left → head
 *      right → tail
 *
 * - Store valid pairs in List<List<Integer>>
 *
 * --------------------------------------------------
 *
 * 🔹 Steps:
 *
 * 1. Initialize:
 *
 *      ds = empty list
 *      left = head
 *      right = last node
 *
 * --------------------------------------------------
 *
 * 2. Traverse:
 *
 *      while (left != right && left.prev != right)
 *
 * --------------------------------------------------
 *
 * 3. Calculate:
 *
 *      sum = left.data + right.data
 *
 * --------------------------------------------------
 *
 * 4. If sum == target:
 *
 *      add [left, right] to ds
 *      left = left.next
 *      right = right.prev
 *
 * --------------------------------------------------
 *
 * 5. If sum < target:
 *
 *      left = left.next
 *
 * --------------------------------------------------
 *
 * 6. If sum > target:
 *
 *      right = right.prev
 *
 * --------------------------------------------------
 *
 * 7. Return ds
 *
 * --------------------------------------------------
 *
 * 🔹 Complexity:
 *
 * 👉 Time = O(N)
 * 👉 Space = O(K)
 *
 * --------------------------------------------------
 *
 * 🔹 Key Insight:
 *
 * - DLL allows backward traversal
 * - Same as two-pointer array technique
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 *
 * "I use two pointers from both ends and store valid pairs,
 * achieving O(N) time and O(K) space."
 */