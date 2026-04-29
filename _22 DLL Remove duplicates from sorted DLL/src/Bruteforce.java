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
            head = newNode; // Case: List is empty, new node becomes the head
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
            System.out.println("List is empty"); // Case: List is empty
            return;
        }
        Node currNode = head; // Start from the head
        // Traverse and print each node's data
        while (currNode != null) {
            System.out.print(currNode.data + " <-> "); // Print data of the current node
            currNode = currNode.next; // Move to the next node
        }
        System.out.println("null"); // End of the list
    }

    // Method to remove duplicates from a sorted doubly linked list
    public void removeDuplicatesFromSortedDLL() { // T: O(N) | S: O(1)

        if (head == null) return;

        Node temp = head;

        while (temp != null && temp.next != null) {

            Node nextNode = temp.next;

            // 🔥 Skip all duplicates
            while (nextNode != null) {
                if (nextNode.data != temp.data) {
                    break;
                }
                nextNode = nextNode.next;
            }

            // 🔥  (IMPORTANT LINE)
            temp.next = nextNode;

            // Fix prev pointer
            if (nextNode != null) {
                nextNode.prev = temp;
            }

            // Move forward
            temp = temp.next;
        }
    }
}

// T: 0(N) || s:0(1)
// Unique Case : Keep Remember -
// 1. The method traverses the list only once, visiting each node exactly once.
// 2. The inner while loop (skipping duplicates) only processes nodes that are duplicates, so the overall work done across all iterations is linear.

public class Bruteforce {
    public static void main(String[] args) {
        CustomDoublyLinkedList2 list = new CustomDoublyLinkedList2();

        // Adding nodes to the doubly linked list
        list.addLast(1);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println("Original List:");
        list.printList(); // Print the list before removing duplicates

        list.removeDuplicatesFromSortedDLL(); // Remove duplicates

        System.out.println("\nList after removing duplicates:");
        list.printList(); // Print the list after removing duplicates
    }
}


/**
 * 🎯 Remove Duplicates from Sorted Doubly Linked List — Algorithm
 *
 * 🔹 Problem:
 * - Given a sorted doubly linked list
 * - Remove all duplicate nodes
 *
 * Example:
 *      1 <-> 1 <-> 1 <-> 2 <-> 3 <-> 3
 *
 * Result:
 *      1 <-> 2 <-> 3
 *
 * --------------------------------------------------
 *
 * 🔹 Core Idea:
 * - Since list is sorted → duplicates are adjacent
 * - Use two pointers:
 *
 *      temp → current node
 *      nextNode → runner pointer to skip duplicates
 *
 * --------------------------------------------------
 *
 * 🔹 Steps:
 *
 * 1. Handle edge case:
 *
 *      if (head == null)
 *          return
 *
 * --------------------------------------------------
 *
 * 2. Initialize:
 *
 *      temp = head
 *
 * --------------------------------------------------
 *
 * 3. Traverse list:
 *
 *      while (temp != null && temp.next != null)
 *
 * --------------------------------------------------
 *
 * 4. Move runner pointer:
 *
 *      nextNode = temp.next
 *
 *      while (nextNode != null && nextNode.data == temp.data)
 *          nextNode = nextNode.next
 *
 * --------------------------------------------------
 *
 * 5. Skip duplicates:
 *
 *      temp.next = nextNode
 *
 * --------------------------------------------------
 *
 * 6. Fix backward link:
 *
 *      if (nextNode != null)
 *          nextNode.prev = temp
 *
 * --------------------------------------------------
 *
 * 7. Move forward:
 *
 *      temp = temp.next
 *
 * --------------------------------------------------
 *
 * 🔹 Dry Run:
 *
 *      1 <-> 1 <-> 1 <-> 2
 *
 * temp = 1
 * nextNode moves → 2
 *
 * temp.next = 2
 *
 * Result:
 *      1 <-> 2
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
 * 🔹 Key Insight:
 *
 * - We don't delete nodes individually
 * - We skip duplicates in one jump
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 *
 * "Since the list is sorted, I skip all adjacent duplicates
 * by linking current node to next distinct node in one pass."
 */
