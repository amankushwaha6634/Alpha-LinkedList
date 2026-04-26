import java.util.HashMap;
import java.util.Map;

class CustomLL2 {
    Node head; // Head of the linked list

    // Definition of a Node in the linked list
    class Node {
        int data;      // Data stored in the node
        Node next;     // Pointer to the next node

        // Constructor to initialize a node
        public Node(int data1) {
            this.data = data1;  // Set the data
            this.next = null;   // Initialize next as null
        }
    }

    // Method to add a node with the given data at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data); // Create a new node
        if (head == null) {
            head = newNode; // If the list is empty, make the new node the head
            return;
        }
        Node currNode = head;
        while (currNode.next != null) { // Traverse to the last node
            currNode = currNode.next;
        }
        currNode.next = newNode; // Attach the new node at the end
    }

    // Method to print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        Map<Node, Integer> visitedNodes = new HashMap<>(); // Map to track visited nodes

        while (currNode != null) { // Traverse and print each node
            // Check if the current node has already been visited
            if (visitedNodes.containsKey(currNode)) {
                System.out.println("Loop detected. Stopping printing.");
                break; // Stop printing to avoid infinite loop
            }

            System.out.print(currNode.data + " -> ");
            visitedNodes.put(currNode, 1); // Mark the current node as visited
            currNode = currNode.next;
        }

        System.out.println("null");
    }

    // Method to detect a loop in the linked list using Tortoise and Hare algorithm
    public boolean detectLoop() { // T:0(N) s:0(1)
        // Step 1: Initialize two pointers, slow and fast, at the head
        Node slow = head;
        Node fast = head;

        // Step 2: Traverse the linked list with the slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow one step
            fast = fast.next.next;  // Move fast two steps

            // Step 3: Check if slow and fast pointers meet
            if (slow == fast) {
                return true; // Loop detected
            }
        }

        // If fast reaches last node(in case of odd list)
        // If fast reaches null (in case of even list)
        // while loop will break : It means list is linear data structure.

        // If fast reaches the end of the list, there is no loop
        return false;
    }

    // Function to return the length of the loop when slow and fast are on the same node
    static int findLength(Node slow, Node fast) {
        int cnt = 1; // Initialize counter for loop length
        fast = fast.next; // Move fast one step ahead

        // Traverse the loop until fast pointer meets slow pointer again
        while (slow != fast) {
            cnt++;           // Increment counter for each node in the loop
            fast = fast.next; // Move fast one step forward
        }

        return cnt; // Return the length of the loop
    }

    // Function to find the length of the loop in the linked list
    static int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Traverse the list to detect a loop using the Tortoise and Hare algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow one step
            fast = fast.next.next;  // Move fast two steps

            // If slow and fast pointers meet, there is a loop
            if (slow == fast) {
                return findLength(slow, fast); // Calculate the length of the loop
            }
        }

        return 0; // If no loop is detected, return 0
    }
}

// Main class to test the CustomLL2 class
public class Optimal_TortoiseNHare {
    public static void main(String[] args) {
        // Create a linked list
        CustomLL2 list = new CustomLL2();

        // Adding sample nodes to the list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Creating a loop in the list by manually linking the last node to the second node
        CustomLL2.Node temp = list.head;
        CustomLL2.Node loopNode = null;
        int position = 2; // Create the loop starting at position 2 (second node)

        // Traverse the list to find the node at the specified position
        while (temp != null) {
            position--;
            if (position == 0) {
                loopNode = temp; // Mark the loop start node
            }
            temp = temp.next;
        }

        // Link the last node to the loopNode (second node) to create a loop
        if (loopNode != null) {
            temp = list.head;
            while (temp != null && temp.next != null) { // Reach the last node
                temp = temp.next;
            }
            temp.next = loopNode; // Create the loop
        }

        // Print the linked list (will cause an infinite loop, but we're checking for the loop)
        System.out.println("List (with loop):");
        list.printList();

        // Check for loop in the list
        boolean hasLoop = list.detectLoop(); // Using list.detectLoop() instead
        System.out.println("Does the list have a loop? " + (hasLoop ? "Yes" : "No"));

        // Get the length of the loop if present
        int loopLength = CustomLL2.lengthOfLoop(list.head);
        System.out.println("Length of the loop: " + (loopLength > 0 ? loopLength : "No loop detected"));
    }
}

/*
 * Linked List with a Loop:
 *
 * 1 -> 2 -> 3 -> 4 -> 5
 *      ^______________|
 *
 * The loop starts at node 2 and continues in the cycle 2 -> 3 -> 4 -> 5 -> 2 -> ...
 * This is achieved by connecting the last node (5) back to the second node (2).
 */

/**
 * 🎯 Length of Loop (Floyd’s Algorithm) — Optimal
 *
 * 🔹 Core Idea:
 * - First detect loop using slow & fast
 * - Once they meet → start counting loop length
 *
 * --------------------------------------------------
 *
 * 🔹 Steps:
 *
 * 1. Initialize:
 *
 *      slow = head
 *      fast = head
 *
 * --------------------------------------------------
 *
 * 2. Detect loop:
 *
 *      while (fast != null && fast.next != null)
 *
 *          slow = slow.next
 *          fast = fast.next.next
 *
 *          if (slow == fast)
 *              break
 *
 * --------------------------------------------------
 *
 * 3. If no loop:
 *
 *      if (slow != fast)
 *          return 0
 *
 * --------------------------------------------------
 *
 * 4. Count loop length:
 *
 *      count = 1
 *      temp = slow.next
 *
 *      while (temp != slow)
 *          count++
 *          temp = temp.next
 *
 * --------------------------------------------------
 *
 * 5. Return count
 *
 * --------------------------------------------------
 *
 * 🔹 Dry Run:
 *
 *      1 -> 2 -> 3 -> 4 -> 5
 *           ^______________|
 *
 * Loop: 2 → 3 → 4 → 5 → 2
 *
 * Length = 4
 *
 * --------------------------------------------------
 *
 * 🔹 Complexity:
 *
 * 👉 Time = O(N)
 * 👉 Space = O(1)
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 *
 * "After detecting cycle using Floyd’s algorithm,
 * I traverse the loop once to count its length."
 */