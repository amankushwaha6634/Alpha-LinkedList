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

    // Function to find the middle node of a linked list using slow and fast pointers
    static Node findMiddle(Node head) { // T: O(N/2) | S: O(1)
        // If the list is empty, return null
        if (head == null) {
            return null;
        }

        Node slow = head;  // Slow pointer
        Node fast = head;  // Fast pointer

        // Traverse the list with the slow pointer moving one step and the fast pointer moving two steps
        while (fast != null && fast.next != null) { // It always require in case of Tortoise and hare
            slow = slow.next;        // Move slow pointer by one step
            fast = fast.next.next;   // Move fast pointer by two steps

            // Explanation: In case of odd list fast will always reach last node || in case of even list it will never reach last node it will always reach null ie. end point.
            // The loop stops when:
            // 1. **Odd-length list**: When fast reaches the last node (fast.next == null),
            //    slow will be at the exact middle node.
            // 2. **Even-length list**: When fast reaches end (fast == null),
            //    slow will be at the 2nd middle node (the right middle in case of even length).
        }

        // Slow pointer will be at the middle when fast pointer reaches the end
        return slow;
    }

}

// Main class to test the CustomLL2 class and findMiddle method
public class Optimal_TortoiseandHare {
    public static void main(String[] args) {
        // Create a linked list
        CustomLL2 list = new CustomLL2();

        // Adding sample nodes to the list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Print the linked list
        System.out.println("List:");
        list.printList();

        // Find the middle node using the slow and fast pointer technique
        CustomLL2.Node middleNode = CustomLL2.findMiddle(list.head); // class method call

        // Print the middle node
        if (middleNode != null) {
            System.out.println("Middle node is: " + middleNode.data);
        } else {
            System.out.println("The list is empty.");
        }
    }
}


/**
 * 🎯 Find Middle of Linked List (Tortoise & Hare) — Algorithm Idea
 *
 * 🔹 Problem:
 * - Find the middle node of a singly linked list
 *
 * Example:
 *      1 -> 2 -> 3 -> 4 -> 5
 *                 ^
 *               answer = 3
 *
 * --------------------------------------------------
 *
 * 🔹 Core Idea:
 * - Use two pointers:
 *
 *      slow → moves 1 step
 *      fast → moves 2 steps
 *
 * - When fast reaches end,
 *   slow will be at middle
 *
 * --------------------------------------------------
 *
 * 🔹 Why this works?
 *
 * - fast moves twice as fast as slow
 *
 * So:
 *
 *      when fast completes full list
 *      slow completes half list
 *
 * 👉 Half of list = middle position
 *
 * --------------------------------------------------
 *
 * 🔹 Steps:
 *
 * 1. Handle edge case:
 *
 *      if (head == null)
 *          return null
 *
 * --------------------------------------------------
 *
 * 2. Initialize pointers:
 *
 *      slow = head
 *      fast = head
 *
 * --------------------------------------------------
 *
 * 3. Traverse:
 *
 *      while (fast != null && fast.next != null)
 *
 *          slow = slow.next
 *          fast = fast.next.next
 *
 * --------------------------------------------------
 *
 * 4. Loop ends when:
 *
 *      fast reaches end
 *
 * 👉 slow will be at middle
 *
 * --------------------------------------------------
 *
 * 🔹 Dry Run:
 *
 *      1 -> 2 -> 3 -> 4 -> 5
 *
 * Step 1:
 *      slow = 1, fast = 1
 *
 * Step 2:
 *      slow = 2, fast = 3
 *
 * Step 3:
 *      slow = 3, fast = 5
 *
 * Step 4:
 *      fast.next = null → stop
 *
 * 👉 slow = 3 (middle)
 *
 * --------------------------------------------------
 *
 * 🔹 Even Length Case:
 *
 *      1 -> 2 -> 3 -> 4
 *
 * Movement:
 *
 *      slow = 2, fast = 3
 *      slow = 3, fast = null
 *
 * 👉 slow = 3 (RIGHT middle)
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
 * - Fast pointer acts like a "speed runner"
 * - Slow pointer acts like a "walker"
 * - When runner finishes, walker reaches midpoint
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 *
 * "I use slow and fast pointers where fast moves twice as fast.
 * When fast reaches the end, slow naturally lands at the middle."
 */