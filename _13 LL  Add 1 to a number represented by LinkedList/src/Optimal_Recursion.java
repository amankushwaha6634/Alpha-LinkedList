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
        while (currNode != null) { // Traverse and print each node
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null"); // End of the list
    }

    // Method to add 1 to the number represented by the linked list using backtracking
    public void addOne() {  // T:0(N) s:0(N)
        // Start recursive backtracking from the head node
        if (addOneRecursive(head) == 1) {
            // If carry is left after adding 1 to the most significant digit
            Node newNode = new Node(1);  // Create a new node with data 1
            newNode.next = head;  // Add it at the front of the list
            head = newNode;  // Set new node as the head
        }
    }

    // Recursive method to add 1 and propagate the carry back
// Recursive method using % and /
    private int addOneRecursive(Node node) {

        // Base case
        if (node == null) {
            return 1; // initial carry
        }

        // Go till last node
        int carry = addOneRecursive(node.next);

        int sum = node.data + carry;

        // 🔥 Using % and /
        node.data = sum % 10;
        return sum / 10;
    }
}

// Main class to test the CustomLL2 class and addOne method
public class Optimal_Recursion {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL2 list = new CustomLL2();

        // Adding sample nodes to represent a number (e.g., 1 -> 2 -> 3, which represents 123)
        list.addLast(9);
        list.addLast(9);
        list.addLast(9);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Add 1 to the number represented by the linked list using backtracking
        list.addOne();

        // Print the updated list
        System.out.println("List after adding 1:");
        list.printList();
    }
}


/**
 * 🎯 Add 1 to Number Represented by Linked List (Recursion + % /) — Algorithm
 *
 * 🔹 Problem:
 * - Linked list represents a number:
 *      1 -> 2 -> 3 = 123
 *
 * - Add 1 to it
 *
 *      Result:
 *      1 -> 2 -> 4
 *
 * --------------------------------------------------
 *
 * 🔹 Core Idea:
 * - Use recursion to reach last node (least significant digit)
 * - While backtracking:
 *      add carry
 *      update digit using % 10
 *      propagate carry using / 10
 *
 * --------------------------------------------------
 *
 * 🔹 Steps:
 *
 * 1. Call recursive function:
 *
 *      carry = addOneRecursive(head)
 *
 * --------------------------------------------------
 *
 * 2. Base Case:
 *
 *      if (node == null)
 *          return 1   // initial carry (we are adding 1)
 *
 * --------------------------------------------------
 *
 * 3. Recursive Call:
 *
 *      carry = addOneRecursive(node.next)
 *
 * 👉 This ensures we reach LAST node first
 *
 * --------------------------------------------------
 *
 * 4. Backtracking Step:
 *
 *      sum = node.data + carry
 *
 *      node.data = sum % 10   // update digit
 *      carry = sum / 10       // propagate carry
 *
 *      return carry
 *
 * --------------------------------------------------
 *
 * 5. After recursion completes:
 *
 *      if (carry == 1)
 *          create new node with value 1
 *          attach at front:
 *
 *          newNode.next = head
 *          head = newNode
 *
 * --------------------------------------------------
 *
 * 🔹 Dry Run:
 *
 *      9 -> 9 -> 9
 *
 * Step 1:
 *      Reach end → return carry = 1
 *
 * Step 2 (Backtracking):
 *
 *      Last node:
 *          9 + 1 = 10 → digit = 0, carry = 1
 *
 *      Middle node:
 *          9 + 1 = 10 → digit = 0, carry = 1
 *
 *      First node:
 *          9 + 1 = 10 → digit = 0, carry = 1
 *
 * Step 3:
 *      carry = 1 → add new node
 *
 * Final:
 *      1 -> 0 -> 0 -> 0
 *
 * --------------------------------------------------
 *
 * 🔹 Complexity:
 *
 * 👉 Time = O(N)
 * 👉 Space = O(N)   // recursion stack
 *
 * --------------------------------------------------
 *
 * 🔹 Key Insight:
 *
 * - Recursion naturally processes list from right → left
 * - No need to reverse the list
 * - Carry flows backward during recursion unwind
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 *
 * "I use recursion to reach the least significant digit,
 * then propagate carry backward using modulo and division,
 * achieving O(N) time and O(N) stack space."
 */