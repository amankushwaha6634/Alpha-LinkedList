import java.util.HashMap;
import java.util.Map;

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
    public boolean detectLoop() { // T: 0(N x 2 Map operation (insert, find) cost maybe log/constant ) => 0(N) | lets take constant for that. || S : 0(N) To store all nodes
        // Step 1: Initialize a pointer 'temp' at the head of the linked list
        Node temp = head;

        // Step 2: Create a map to keep track of visited nodes
        // The key in the map is the node reference, and the value is a marker (e.g., integer 1)
        Map<Node, Integer> nodeMap = new HashMap<>();

        // Step 3: Traverse the linked list
        while (temp != null) {
            // Step 4: Check if the current node has already been visited
            if (nodeMap.containsKey(temp)) {
                // If the node is found in the map, it indicates a loop
                return true;
            }

            // Step 5: Add the current node to the map to mark it as visited
            nodeMap.put(temp, 1);

            // Step 6: Move to the next node in the linked list
            temp = temp.next;
        }

        // Step 7: If we reach the end of the list (null), no loop is detected
        return false;
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
            while (temp != null && temp.next != null) { // reach last node using temp
                temp = temp.next;
            }
            // Link the last node's next to the loopNode (second node)
            temp.next = loopNode;
        }

        // Print the linked list (will cause an infinite loop, but we're checking for the loop)
        System.out.println("List (with loop):");
        list.printList();

        // Check for loop in the list
        boolean hasLoop = list.detectLoop(); // Using list.detectLoop() instead
        System.out.println("Does the list have a loop? " + (hasLoop ? "Yes" : "No"));
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
 * 🎯 Detect Loop in Linked List (Using HashMap) — Algorithm Steps
 *
 * 🔹 Problem:
 * - Detect whether a linked list contains a loop (cycle)
 *
 * --------------------------------------------------
 *
 * 🔹 Core Idea:
 * - While traversing the list,
 *   store each visited node in a HashMap
 *
 * - If a node is visited again,
 *   it means we have entered a loop

 *
 * 🔹 Complexity:
 *
 * 👉 Time = O(N)
 * 👉 Space = O(N)
 *
 * --------------------------------------------------
 *
 * 🔹 Key Insight:
 *
 * - A loop means revisiting same node
 * - HashMap helps detect repetition instantly
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 *
 * "I use a HashMap to store visited nodes and detect repetition,
 * which indicates a cycle, achieving O(N) time and O(N) space."
 */


/*
🔹 Map (HashMap) Operations Time Complexity (Java)

--------------------------------------------------------------
| Operation            | Average Case        | Worst Case     |
--------------------------------------------------------------
| put(key, value)      | O(1)                | O(N)           |
| get(key)             | O(1)                | O(N)           |
| containsKey(key)     | O(1)                | O(N)           |
| remove(key)          | O(1)                | O(N)           |
| size()               | O(1)                | O(1)           |
| isEmpty()            | O(1)                | O(1)           |
| keySet()/values()    | O(N)                | O(N)           |
| entrySet()           | O(N)                | O(N)           |
--------------------------------------------------------------

🔹 Why Worst Case = O(N)?

- Due to hash collisions
- Many keys go into same bucket
- Then operations become linear search

--------------------------------------------------------------

🔹 Why Average = O(1)?

- Hashing distributes keys across buckets
- Direct access to bucket using hash

--------------------------------------------------------------

🔹 Java 8+ Improvement 🔥

- If too many collisions happen:
      Linked List → Balanced Tree (Red-Black Tree)

👉 Worst case improves to O(log N) (instead of pure O(N))

--------------------------------------------------------------

🔹 In Your Loop Detection Problem:

- put() used N times → O(N)
- containsKey() used N times → O(N)

👉 Total = O(N)

--------------------------------------------------------------

🔹 Interview Line:

"HashMap provides O(1) average time for insert and lookup.
In worst case, due to collisions, it can degrade,
but Java optimizes it using trees to O(log N)."
*/