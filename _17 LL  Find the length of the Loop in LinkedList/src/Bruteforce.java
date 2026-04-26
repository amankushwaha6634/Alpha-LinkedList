import java.util.HashMap;
import java.util.Map;

// Class to represent a custom linked list
class CustomLL1 {
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

    // Method to detect a loop in the linked list
    public boolean detectLoop() {
        Node temp = head; // Start traversing from the head
        Map<Node, Integer> nodeMap = new HashMap<>(); // Map to track visited nodes

        // Traverse the linked list
        while (temp != null) {
            if (nodeMap.containsKey(temp)) {
                // If the node is found in the map, it indicates a loop
                return true;
            }
            nodeMap.put(temp, 1); // Mark the current node as visited
            temp = temp.next;     // Move to the next node
        }

        // If we reach the end of the list, no loop is detected
        return false;
    }

    // Method to calculate the length of a loop in a linked list
    public static int lengthOfLoop(Node head) { // T: 0(N x 2 Map operation (insert, find) cost maybe log/constant ) => 0(N) | lets take constant for that. || S : 0(N) To store all nodes
        // Step 1: Create a HashMap to store visited nodes and their timer values.
        // The key is the node reference, and the value is an integer (the timer value).
        Map<Node, Integer> visitedNodes = new HashMap<>();

        // Step 2: Initialize a temporary pointer to traverse the linked list.
        Node temp = head;

        // Step 3: Initialize a timer variable to track the traversal sequence of nodes.
        int timer = 1;

        // Step 4: Traverse the linked list while the current node (temp) is not null.
        while (temp != null) {
            // Step 5: Check if the current node is already present in the HashMap.
            if (visitedNodes.containsKey(temp)) {
                // If the node is found in the map, calculate the loop length.
                int loopLength = timer - visitedNodes.get(temp);
                return loopLength; // Return the length of the loop
            }

            // Step 6: Store the current node and its timer value in the HashMap.
            visitedNodes.put(temp, timer);

            // Step 7: Move to the next node in the linked list.
            temp = temp.next;

            // Step 8: Increment the timer.
            timer++;
        }

        // if temp is reaching null it means list is linear DS/data structure
        // Step 9: If traversal completes and no loop is detected, return 0.
        return 0;
    }
}

// Main class to test the CustomLL1 class
public class Bruteforce {
    public static void main(String[] args) {
        // Create a linked list
        CustomLL1 list = new CustomLL1();

        // Adding sample nodes to the list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Creating a loop in the list by manually linking the last node to the second node
        CustomLL1.Node temp = list.head;
        CustomLL1.Node loopNode = null;
        int position = 2; // We want to create the loop starting at position 2 (second node)

        // Traverse the list and find the node at the specified position
        while (temp != null) {
            position--;
            if (position == 0) {
                loopNode = temp; // Mark the second node
            }
            temp = temp.next;
        }

        // Create a loop by linking the last node to the second node
        if (loopNode != null) {
            temp = list.head;
            while (temp != null && temp.next != null) { // Reach the last node using temp
                temp = temp.next;
            }
            temp.next = loopNode; // Link the last node's next to the loopNode (second node)
        }

        // Print the linked list
        System.out.println("List (with loop):");
        list.printList();

        // Check for loop in the list
        boolean hasLoop = list.detectLoop();
        System.out.println("Does the list have a loop? " + (hasLoop ? "Yes" : "No"));

        // Find the length of the loop
        int loopLength = CustomLL1.lengthOfLoop(list.head);
        System.out.println("Length of the loop: " + loopLength);
    }
}


/**
 * 🎯 Length of Loop in Linked List (Using HashMap) — Algorithm
 *
 * 🔹 Core Idea:
 * - Store node with "time/index"
 * - When node repeats → loop found
 * - Loop length = current_time - first_time_seen
 *
 * --------------------------------------------------
 *
 * 🔹 Steps:
 *
 * 1. Initialize:
 *
 *      temp = head
 *      timer = 0
 *      map = empty HashMap<Node, Integer>
 *
 * --------------------------------------------------
 *
 * 2. Traverse:
 *
 *      while (temp != null)
 *
 * --------------------------------------------------
 *
 * 3. Check repetition:
 *
 *      if (map.containsKey(temp))
 *
 *          loopLength = timer - map.get(temp)
 *          return loopLength
 *
 * --------------------------------------------------
 *
 * 4. Store node:
 *
 *      map.put(temp, timer)
 *
 * --------------------------------------------------
 *
 * 5. Move forward:
 *
 *      temp = temp.next
 *      timer++
 *
 * --------------------------------------------------
 *
 * 6. If no loop:
 *
 *      return 0
 *
 * --------------------------------------------------
 *
 * 🔹 Complexity:
 *
 * 👉 Time = O(N)
 * 👉 Space = O(N)
 */